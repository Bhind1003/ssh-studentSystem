package hib;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manager", schema = "student", catalog = "")
public class ManagerEntity {
    private String mno;
    private String mname;
    private String msex;
    private String phone;
    private String email;

    @Id
    @Column(name = "mno")
    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    @Basic
    @Column(name = "mname")
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Basic
    @Column(name = "msex")
    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerEntity that = (ManagerEntity) o;
        return Objects.equals(mno, that.mno) &&
                Objects.equals(mname, that.mname) &&
                Objects.equals(msex, that.msex) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mno, mname, msex, phone, email);
    }
}
