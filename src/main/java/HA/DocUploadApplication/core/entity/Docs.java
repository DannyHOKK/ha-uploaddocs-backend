package HA.DocUploadApplication.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Clob;

@Entity
@Table(name = "DOCS")
public class Docs implements Serializable {

    @Id
    @Column(name = "REF_NO")
    private Integer refNo;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "DATA")
    private byte[] data;

    @Column(name = "DESC")
    private String desc;

    @Column(name = "REMARK")
    private String remark;

    public Docs() {
    }

    public Docs(String category, String fileName, byte[] data, String desc, String remark) {
        this.category = category;
        this.fileName = fileName;
        this.data = data;
        this.desc = desc;
        this.remark = remark;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
}