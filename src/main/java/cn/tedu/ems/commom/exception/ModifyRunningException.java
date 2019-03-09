package cn.tedu.ems.commom.exception;

/**
 * @Author: lulin
 * @Date: 3/7/2019 2:56 PM
 * @Version 1.0
 */

/**
 * Spring只对RunntimeException作事务回滚
 */
public class ModifyRunningException extends RuntimeException {
    public ModifyRunningException(String message) {
        super(message);
    }
}
