package HA.DocUploadApplication.core.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCS")
public class Docs  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF_NO")
    private Integer refNo;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "FILE_NAME")
    private String filename;

    @Column(name = "DATA")
    @Lob
    private byte[] data;

    @Column(name = "DESCRIPTION")
    private String desc;

    @Column(name = "REMARK")
    private String remark;

    public Docs() {
    }

    public Docs(String category, String filename, byte[] data, String desc, String remark) {
        this.category = category;
        this.filename = filename;
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
}