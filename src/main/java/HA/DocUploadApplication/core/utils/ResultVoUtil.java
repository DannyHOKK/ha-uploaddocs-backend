package HA.DocUploadApplication.core.utils;

import HA.DocUploadApplication.core.vo.ResultVO;

public class ResultVoUtil {

    public static <T>ResultVO<T> success(String msg, T object){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(ResultVO.SUCCESS_CODE);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }
    public static <T>ResultVO<T> success(String msg){
        return success(msg,null);
    }
    public static <T>ResultVO<T> success(T object){
        return success(null, object);
    }
    public static <T>ResultVO<T> success(){
        return success(null);
    }

    public static <T>ResultVO<T> error(String msg, T object){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(ResultVO.ERROR_CODE);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }
    public static <T>ResultVO<T> error(String msg){
        return error(msg,null);
    }
    public static <T>ResultVO<T> error(T object){
        return error(null,object);
    }
    public static <T>ResultVO<T> error(){
        return error(null);
    }

    public static <T>ResultVO<T> validFail(String msg, T object){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(ResultVO.VALIDA_FAIL_CODE);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }
    public static <T>ResultVO<T> validFail(String msg){
        return validFail(msg,null);
    }
    public static <T>ResultVO<T> validFail(T object){
        return validFail(null,object);
    }
    public static <T>ResultVO<T> validFail(){
        return validFail(null);
    }
    public static <T>ResultVO<T> warn(String msg, T object){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(ResultVO.WARN_CODE);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }
    public static <T>ResultVO<T> warn(String msg){
        return warn(msg,null);
    }
}
