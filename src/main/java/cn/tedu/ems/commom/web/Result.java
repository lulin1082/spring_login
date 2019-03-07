package cn.tedu.ems.commom.web;

import java.io.Serializable;
import java.util.Objects;

public class Result implements Serializable{

    private static int SCUESS =0;
    private static int ERROR=1;
    private  int state;
    private Object o;
    private String message;

    Result(){
        state=SCUESS;
        message="OK";
    }
    Result(Objects o){
        this.o=0;
    }

    public Result(Throwable cause){
        this.message=cause.getMessage();
        this.state=1;
    }

    public static int getSCUESS() {
        return SCUESS;
    }

    public static void setSCUESS(int SCUESS) {
        Result.SCUESS = SCUESS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static void setERROR(int ERROR) {
        Result.ERROR = ERROR;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
