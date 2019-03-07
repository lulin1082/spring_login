package cn.tedu.ems.system.service;

/**
 * 	自定义异常类
 *
 */
public class ApplicationException
	extends RuntimeException {

	public ApplicationException() {
		
	}

	public ApplicationException(String message) {
		super(message);
	}
	
}



