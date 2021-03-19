package hib;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_log", schema = "student", catalog = "")
public class StudentLogEntity {
    private String sno;
    private String password;

    @Id
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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
        StudentLogEntity that = (StudentLogEntity) o;
        return Objects.equals(sno, that.sno) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, password);
    }
}
