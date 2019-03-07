package cn.tedu.ems.commom.exception;

import cn.tedu.ems.commom.web.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e){
        return new Result(e);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handleException(RuntimeException e){
        return new Result(e);
    }



}
