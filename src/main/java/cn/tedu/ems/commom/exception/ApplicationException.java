package cn.tedu.ems.commom.exception;

/**
 * @Author: lulin
 * @Date: 3/7/2019 10:53 PM
 * @Version 1.0
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }
    public ApplicationException(Throwable e) {
        super(e);
    }


    public ApplicationException(String message) {
        super(message);
    }
}
