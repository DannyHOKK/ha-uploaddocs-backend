package HA.DocUploadApplication.core.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocsUploadDTO{


    private String category;

    private String desc;

    private String remark;

    private Date createDT;

    private String createBy;

    public DocsUploadDTO() {
    }

    public DocsUploadDTO(String category, String desc, String remark) {
        this.category = category;
        this.desc = desc;
        this.remark = remark;
    }

    public DocsUploadDTO(String category, String desc, String remark, Date createDT, String createBy) {
        this.category = category;
        this.desc = desc;
        this.remark = remark;
        this.createDT = createDT;
        this.createBy = createBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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