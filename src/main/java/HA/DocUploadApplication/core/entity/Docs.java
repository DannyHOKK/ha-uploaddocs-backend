package HA.DocUploadApplication.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DOCS")
public class Docs{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF_NO")
    private Integer refNo;

    @Column(name = "CATEGORY")
    @NotNull
    private String category;

    @Column(name = "FILE_NAME")
    @NotNull
    private String filename;

    @Column(name = "DATA")
    @Lob
    private byte[] data;

    @Column(name = "DESCRIPTION")
    @NotNull
    private String desc;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATE_DATE")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss",timezone = "GMT+8")
    private Date createDT;

    @Column(name = "CREATE_BY")
    private String createBy;

    public Docs() {
    }

    public Docs(String category, String filename, byte[] data, String desc, String remark, Date createDT, String createBy) {
        this.category = category;
        this.filename = filename;
        this.data = data;
        this.desc = desc;
        this.remark = remark;
        this.createDT = createDT;
        this.createBy = createBy;
    }

    public Integer getRefNo() {
        return refNo;
    }

    public void setRefNo(Integer refNo) {
        this.refNo = refNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}