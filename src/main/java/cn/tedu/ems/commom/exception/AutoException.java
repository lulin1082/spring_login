package cn.tedu.ems.commom.exception;

/**
 * @Author: lulin
 * @Date: 3/9/2019 10:43 PM
 * @Version 1.0
 */
public class AutoException extends RuntimeException{
    private Integer code;

    public AutoException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
