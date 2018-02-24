package com.yixiaolabs.admin.utils.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 记录操作日志切面类
 * @author fk
 * @version v1.0
 * @since v6.2
 * 2016年12月7日 下午1:19:46
 */
@Component
@Aspect
public class LogAspect {

	/**
	 * 切面方法
	 * @param point 切点
	 * @param log 注解log对象
	 * @throws Exception
	 */
	@AfterReturning("@annotation(log)")
	public void doAfter(JoinPoint point, Log log) throws Exception{
		String type = log.type();//类型标识
		String detail = log.detail();//操作描述
		// jms 方式存储日志
	}
	
	
	
}
