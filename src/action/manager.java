package action;

import com.opensymphony.xwork2.ActionContext;
import dao.manDAO;
import dao.stuDAO;
import dao.userDAO;
import hib.ManagerLogEntity;
import hib.NoticeEntity;
import hib.StudInfoEntity;
import hib.StudSchoolEntity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class manager {
    String condition;
    String msg = "";
    NoticeEntity noticeEntity;
    manDAO manDAO;
    String password;
    String password2;
    String password3;
    String kind;
    StudSchoolEntity sch;
    File img;
    StudInfoEntity stu;
    File file;
    String cntMsg;

    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        try (FileChannel inputChannel = new FileInputStream(source).getChannel(); FileChannel outputChannel = new FileOutputStream(dest).getChannel()) {
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String findNotice() {
        msg = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("notice2");
        List<NoticeEntity> tmp = manDAO.findNotice(condition);
        msg = condition + ",条件搜索结果如下";
        session.put("notice2", tmp);
        System.out.println("搜索通知成功！");
        return "success";
    }

    public String getNotice() {
        msg = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("notice2");
        List<NoticeEntity> tmp = manDAO.listNotice();
        session.put("notice2", tmp);
        System.out.println("查询全部通知成功！");
        return "success";
    }

    public String getMsg() {
        return msg;
    }

    public NoticeEntity getNoticeEntity() {
        return noticeEntity;
    }

    public void setNoticeEntity(NoticeEntity noticeEntity) {
        this.noticeEntity = noticeEntity;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String changeNotice() {
        msg = "";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        if (id == null) {
            if (manDAO.saveNotice(noticeEntity) != null) {
                if (file != null) {
                    String destPath = "D:\\IdeaProjects\\ssh\\web\\upfile\\";//你要保存的路径
                    File destFile = new File(destPath, noticeEntity.getDate().hashCode() + ".pdf");
                    try {
                        System.out.println(destFile.toString());
//                        FileUtils.copyFile(file, destFile);
                        copyFileUsingFileChannels(file, destFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                msg = "保存通知成功！";
            } else {
                msg = "保存通知失败！";
            }
        } else if (id.trim().compareTo("add") == 0) {
            noticeEntity = new NoticeEntity();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
            noticeEntity.setDate(ft.format(new Date()));
        } else {
            noticeEntity = manDAO.selectOne(id);
            System.out.println("跳转到修改通知界面");
        }
        return "success";
    }

    public String deleteNotice() {
        msg = "";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        if (manDAO.deleteNotice(id) != null) {
            msg = "删除通知成功！";
        } else {
            msg = "删除通知失败！";
        }
        return "success";
    }

    public void setManDAO(manDAO manDAO) {
        this.manDAO = manDAO;
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

    public String changePass() {
        msg = "";
        Map<String, Object> session = ActionContext.getContext().getSession();
        String mno = (String) session.get("user");
        System.out.println("要修改密码的管理员号是：" + mno);
        int judge1 = password.trim().compareTo(new userDAO().select2(mno).getPassword());
        if (judge1 == 0) {
            if (password2.trim().compareTo(password3) == 0) {
                ManagerLogEntity tmp = new ManagerLogEntity();
                tmp.setMno(mno);
                tmp.setPassword(password3);
                tmp = new userDAO().saveManPass(tmp);
                if (tmp != null) msg = "修改管理员登录密码成功！";
                else msg = "修改管理员登录密码失败！";
            } else {
                msg = "两次输入的密码不一样！";
            }
        } else msg = "原来密码输入错误！";
        return "success";
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String findSchool() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        if (id == null) {
            System.out.println("无其余操作传入");
            msg = "";
            session.remove("school2");
            List<StudSchoolEntity> tmp = manDAO.listSchool(kind, condition);
            session.put("school2", tmp);
            if (condition != null) {
                msg = kind + ":" + condition + ",条件搜索结果如下";
            }
            System.out.println("查询全部学生在校信息成功！");
            condition = null;
        } else if (id.trim().compareTo("count") == 0) {
            System.out.println("count操作传入");
            List<StudSchoolEntity> tmp = (List<StudSchoolEntity>) session.get("school2");
            msg = "数量为" + tmp.size() + "条记录";
            session.put("school2", tmp);
            System.out.println("查询全部学生在校信息数量成功！");
        }
        kind = null;
        condition = null;
        return "success";
    }

    public String getCntMsg() {
        return cntMsg;
    }

    public StudSchoolEntity getSch() {
        return sch;
    }

    public void setSch(StudSchoolEntity sch) {
        this.sch = sch;
    }

    public String updateSchool2() {
        ActionContext context = ActionContext.getContext();
        msg = "";
        if (context.getParameters().get("id").getValue() == null) {
            System.out.println("修改在校信息页面信息传回");
            sch = new stuDAO().updateSchool(sch);
            if (sch != null) msg = "修改学生在校信息成功！";
            else msg = "修改在校信息失败！";
        } else {
            System.out.println("跳转到修改在校信息页面");
            msg = "";
            String id = context.getParameters().get("id").getValue();
            sch = new stuDAO().selectSchool(id);
            if (sch == null) {
                sch = new StudSchoolEntity();
                sch.setSno(id);
            }
        }
        return "success";
    }

    public String deleteSchool() {
        msg = "";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        if (manDAO.deleteSchool(id) != null) {
            msg = "删除学生在校信息成功！";
        } else {
            msg = "删除学生在校信息失败！";
        }
        return "success";
    }

    public String listINFO() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        if (id == null) {
            msg = "";
            session.remove("stu2");
            List<StudInfoEntity> tmp = manDAO.listStu(kind, condition);
            session.put("stu2", tmp);
            if (condition != null) {
                msg = kind + condition + ",条件搜索结果如下";
            }
            System.out.println("查询全部学生个人信息成功！");
        } else if (id.trim().compareTo("count") == 0) {
            cntMsg = "";
            System.out.println("count操作传入");
            List<StudInfoEntity> tmp = (List<StudInfoEntity>) session.get("stu2");
            if (condition != null) cntMsg = kind + "为" + condition + "数量为" + tmp.size() + "条记录";
            else cntMsg = "数量为" + tmp.size() + "条记录";
            session.put("stu2", tmp);
            condition = null;
        }
        kind = null;
        condition = null;
        return "success";
    }

    public void setImg(File img) {
        this.img = img;
    }

    public StudInfoEntity getStu() {
        return stu;
    }

    public void setStu(StudInfoEntity stu) {
        this.stu = stu;
    }

    public String changeInfo() throws IOException {
        msg = "";
        ActionContext context = ActionContext.getContext();
        if (context.getParameters().get("id").getValue() == null) {
            System.out.println("修改学生个人信息页面信息传回");
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
            StudInfoEntity tmp = new stuDAO().updateINFO(stu);
            if (tmp != null) {
                msg = "保存个人信息成功！";
                if (new userDAO().select1(tmp.getSno()) == null) manDAO.saveLog(tmp.getSno(), tmp.getSno());
            } else msg = "保存个人信息失败！";
        } else {
            System.out.println("跳转到修改个人信息页面");
            msg = "";
            String id = context.getParameters().get("id").getValue();
            stu = new stuDAO().select1(id);
        }
        return "success";
    }

    public String deleteInfo() {
        msg = "";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        StudInfoEntity tmp = manDAO.deleteInfo(id);
        if (tmp != null) {
            msg = "删除学生个人信息成功！";
            if (new userDAO().select1(tmp.getSno()) != null) manDAO.deleteLog(id);
        } else {
            msg = "删除学生个人信息失败！";
        }
        return "success";
    }

    public String resetPass() {
        msg = "";
        ActionContext context = ActionContext.getContext();
        String id = context.getParameters().get("id").getValue();
        manDAO.saveLog(id, id);
        msg = id + "学号的登录密码重置成功！";
        return "success";
    }
}
