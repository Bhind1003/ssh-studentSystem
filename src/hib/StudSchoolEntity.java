package hib;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stud_school", schema = "student", catalog = "")
public class StudSchoolEntity {
    private String sno;
    private String deptName;
    private String specialty;
    private String clazz;
    private String dormitory;

    @Id
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "specialty")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "dormitory")
    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudSchoolEntity that = (StudSchoolEntity) o;
        return Objects.equals(sno, that.sno) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(specialty, that.specialty) &&
                Objects.equals(clazz, that.clazz) &&
                Objects.equals(dormitory, that.dormitory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, deptName, specialty, clazz, dormitory);
    }
}
