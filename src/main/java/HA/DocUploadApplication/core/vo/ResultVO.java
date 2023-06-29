package HA.DocUploadApplication.core.vo;

public class ResultVO<T> {
    public static Integer SUCCESS_CODE = 0;
    public static Integer ERROR_CODE = -1;
    public static Integer WARN_CODE = 1;
    public static Integer VALIDA_FAIL_CODE = -2;
    public static Integer TOKEN_EXPIRATION_CODE = -3;
    private Integer code;
    private String msg;
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
