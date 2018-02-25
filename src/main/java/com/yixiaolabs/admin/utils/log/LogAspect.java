package com.yixiaolabs.admin.utils.log;

import com.yixiaolabs.admin.model.AdminLog;
import com.yixiaolabs.admin.utils.AuthUtil;
import com.yixiaolabs.admin.utils.jms.Producer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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

	@Autowired
	private Producer producer;

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
		AdminLog adminLog = new AdminLog();
		adminLog.setType(log.type());
		adminLog.setAdminId(AuthUtil.currentId());
		adminLog.setAdminName(AuthUtil.currentName());
		adminLog.setCreateTime(new Date());
		adminLog.setDetail(log.detail());
		producer.sendLog(adminLog);
	}
}
