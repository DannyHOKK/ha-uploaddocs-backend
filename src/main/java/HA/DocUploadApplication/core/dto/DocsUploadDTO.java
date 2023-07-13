package HA.DocUploadApplication.core.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocsUploadDTO{


    private String category;

    private String filename;

    private String desc;

    private String remark;

    public DocsUploadDTO() {
    }

    public DocsUploadDTO( String category, String filename, String desc, String remark) {
        this.category = category;
        this.filename = filename;
        this.desc = desc;
        this.remark = remark;
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