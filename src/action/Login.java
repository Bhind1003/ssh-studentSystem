package action;

import dao.userDAO;
import hib.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Map;
import java.util.Objects;

public class Login extends ActionSupport {
    private StudentLogEntity user;
    public StudentLogEntity getUser() {
        return user;
    }
    public void setUser(StudentLogEntity user) {
        this.user = user;
    }
    String msg="";
    public String getMsg() {
        return msg;
    }
    String checkNum;//接收验证码
    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }
    public String login()throws Exception{
        msg="";
        String checked =(String) ServletActionContext.getRequest().getSession().getAttribute("checked");
        if(checkNum.equalsIgnoreCase(checked)){
            StudentLogEntity tmp=userDAO.select1(user.getSno());
            if(tmp==null){
                msg="用户帐号不存在！";
                return "error";
            }
            boolean judge= Objects.equals(tmp, user);
            if(judge){
                Map<String, Object> session=ActionContext.getContext().getSession();
                session.put("user", user.getSno());
                return "success";
            }else {
                msg="密码输入错误，请重试！";
                return "error";
            }
        }else{
            msg="验证码输入错误，请重试！";
            return "error";
        }
    }
    public String logout()throws Exception{
        Map<String, Object> session= ActionContext.getContext().getSession();
        session.remove("user");
        session.clear();//清除储存的内容
        return "success";
    }
    private userDAO userDAO;
    public void setUserDAO(userDAO userDAO) {
        System.out.println("userDAO注入成功");
        this.userDAO=userDAO;
    }
    public String login2() throws Exception {
        msg="";
        String checked =(String) ServletActionContext.getRequest().getSession().getAttribute("checked");
        if(checkNum.equalsIgnoreCase(checked)){
            ManagerLogEntity tmp=userDAO.select2(user.getSno());
            if(tmp==null){
                msg="用户帐号不存在！";
                return "error";
            }
            ManagerLogEntity tmp2 = new ManagerLogEntity();
            tmp2.setMno(user.getSno());
            tmp2.setPassword(user.getPassword());
            boolean judge=tmp.equals(tmp2);
            if(judge){
                Map<String, Object> session=ActionContext.getContext().getSession();
                session.put("user", user.getSno());
                return "success";
            }else {
                msg="密码输入错误，请重试！";
                return "error";
            }
        } else{
            msg="验证码输入错误，请重试！";
            return "error";
        }
    }
    public void validate(){
//        if(user!=null&&(user.getSno()==null||user.getSno().trim().equals(""))){
//            addFieldError("us.name","帐号不能为空！");
//        }
//        if(user!=null&&(user.getPassword()==null||user.getPassword().trim().equals(""))){
//            addFieldError("us.password","密码不能为空！");
//        }
    }
}
