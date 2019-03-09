package cn.tedu.ems.commom.handler;

import cn.tedu.ems.commom.aspect.HttpAspect;
import cn.tedu.ems.commom.exception.AutoException;
import cn.tedu.ems.commom.web.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception e){
        return new ResultBean(e);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultBean handleException(RuntimeException e){

        if(e instanceof AutoException){
            AutoException autoException=(AutoException) e;
            return new ResultBean(autoException.getCode(),e);
//            return new ResultBean(e):
        }

        return new ResultBean(e);
    }



}
