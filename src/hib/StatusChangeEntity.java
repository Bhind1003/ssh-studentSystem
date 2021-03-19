package hib;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "status_change", schema = "student", catalog = "")
public class StatusChangeEntity {
    private int changeno;
    private String sno;
    private String changeName;
    private Date date;
    private String detail;

    @Id
    @Column(name = "changeno")
    public int getChangeno() {
        return changeno;
    }

    public void setChangeno(int changeno) {
        this.changeno = changeno;
    }

    @Basic
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "change_name")
    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusChangeEntity that = (StatusChangeEntity) o;
        return changeno == that.changeno &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(changeName, that.changeName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changeno, sno, changeName, date, detail);
    }
}
