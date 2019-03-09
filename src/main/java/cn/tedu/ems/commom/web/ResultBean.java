package cn.tedu.ems.commom.web;

import java.io.Serializable;
import java.util.Objects;

public class ResultBean implements Serializable{

    private static int SCUESS =0;
    private static int ERROR=1;
    private  int state;
    private Object o;
    private String message;

    ResultBean(){
        state=SCUESS;
        message="OK";
    }
    ResultBean(Objects o){
        this.o=0;
    }

    public ResultBean(Throwable cause){
        this.message=cause.getMessage();
        this.state=1;
    }
    public ResultBean(int state,Throwable cause){
        this.message=cause.getMessage();
        this.state=state;

    }

    public static int getSCUESS() {
        return SCUESS;
    }

    public static void setSCUESS(int SCUESS) {
        ResultBean.SCUESS = SCUESS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static void setERROR(int ERROR) {
        ResultBean.ERROR = ERROR;
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
