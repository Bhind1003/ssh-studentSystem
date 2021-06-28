package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import dao.manDAO;
import dao.stuDAO;
import dao.userDAO;
import hib.NoticeEntity;
import hib.StudInfoEntity;
import hib.StudSchoolEntity;
import hib.StudentLogEntity;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

public class stu {
    StudInfoEntity stu;
    StudSchoolEntity sch;
    String password;
    String password2;
    String password3;
    String msg = "";
    String condition;
    File img;
    private stuDAO stuDAO;//依赖注入
    private InputStream inputStream;

    public StudInfoEntity getStu() {
        return stu;
    }

    public void setStu(StudInfoEntity stu) {
        this.stu = stu;
    }

    public StudSchoolEntity getSch() {
        return sch;
    }

    public void setSch(StudSchoolEntity sch) {
        this.sch = sch;
    }

    public void setStuDAO(stuDAO stuDAO) {
        System.out.println("stuDAO注入");
        this.stuDAO = stuDAO;
    }

    public String getInfo() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String sno = (String) session.get("user");
        System.out.println("要查询的学生信息学号是：" + sno);
        stu = stuDAO.select1(sno);
        if (stu != null) {
            return "success";
        } else {
            return "error";
        }
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String updateInfo() {
        ActionContext context = ActionContext.getContext();
        msg = "";
        if (context.getParameters().get("id").getValue() == null) {
            System.out.println("修改学生个人信息页面信息传回");
            StudInfoEntity tmp = stuDAO.select1(stu.getSno());
            tmp.setEmail(stu.getEmail());
            tmp.setPhone(stu.getPhone());
            if (img != null) {
                String destPath = "D:\\IdeaProjects\\ssh\\web\\upfile\\";//你要保存的路径
                File destFile = new File(destPath, stu.getSno() + ".jpg");
                try {
                    FileUtils.copyFile(img, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stu.setPic("/upfile/" + stu.getSno() + ".jpg");
            }
            if (tmp != null) {
                tmp.setPic(stu.getPic());
                tmp = stuDAO.updateINFO(tmp);
                msg = "修改个人信息成功！";
            }
            else msg = "修改个人信息失败！";
        } else {
            System.out.println("跳转到修改个人信息页面");
            msg = "";
            String id = context.getParameters().get("id").getValue();
            stu = stuDAO.select1(id);
        }
        return "success";
    }

    public String getSchool() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        String sno = (String) session.get("user");
        System.out.println("要查询的学生学校信息学号是：" + sno);
        sch = stuDAO.selectSchool(sno);
        if (stu != null) {
            return "success";
        } else {
            return "error";
        }
    }

    public String updateSchool() {
        ActionContext context = ActionContext.getContext();
        msg = "";
        if (context.getParameters().get("id").getValue() == null) {
            System.out.println("修改在校信息页面信息传回");
            sch = stuDAO.updateSchool(sch);
            if (sch != null) msg = "修改在校信息成功！";
            else msg = "修改在校信息失败！";
        } else {
            System.out.println("跳转到修改在校信息页面");
            msg = "";
            String id = context.getParameters().get("id").getValue();
            sch = stuDAO.selectSchool(id);
        }
        return "success";
    }

    public void setPassword3(String password3) {
        this.password3 = password3;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public String changePass() {
        msg = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        String sno = (String) session.get("user");
        System.out.println("要修改密码的学生学号是：" + sno);
        int judge1 = password.trim().compareTo(new userDAO().select1(sno).getPassword());
        if (judge1 == 0) {
            if (password2.trim().compareTo(password3) == 0) {
                StudentLogEntity tmp = new StudentLogEntity();
                tmp.setSno(sno);
                tmp.setPassword(password3);
                tmp = new userDAO().saveStuPass(tmp);
                if (tmp != null) msg = "修改学生密码成功！";
                else msg = "修改学生密码失败！";
            } else {
                msg = "两次输入的密码不一样！";
            }
        } else msg = "原来密码输入错误！";
        return "success";
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNotice() {
        msg="";
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("notice");
        List<NoticeEntity> tmp = stuDAO.listNotice();
        if (condition != null && !condition.trim().equals("")) {
            tmp = new manDAO().findNotice(condition);
            msg=condition+":条件查询结果如下：";
        }
        session.put("notice", tmp);
        System.out.println("查询全部通知成功！");
        return "success";
    }

    public String download() throws FileNotFoundException {
        String path = "D:\\IdeaProjects\\ssh\\web\\upfile\\";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        try {
            inputStream = new FileInputStream(new File(path, id.hashCode() + ".pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件发送用户下载成功！");
        return Action.SUCCESS;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}
