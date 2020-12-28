package cn.hbzd.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02LoggingApplicationTests {
	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
//		System.out.println();
		//日志的级别
		//由低到高 trace < debug < info < warn < error
		//可以调整输出的日志级别 日志就只会在这个级别以后的高级别生效
		logger.trace("这是");
		logger.debug("这是debug信息");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}
