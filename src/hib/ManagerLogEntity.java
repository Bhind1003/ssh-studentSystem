package hib;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manager_log", schema = "student", catalog = "")
public class ManagerLogEntity {
    private String mno;
    private String password;

    @Id
    @Column(name = "mno")
    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerLogEntity that = (ManagerLogEntity) o;
        return Objects.equals(mno, that.mno) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mno, password);
    }
}
