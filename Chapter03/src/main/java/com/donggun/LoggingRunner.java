package com.donggun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner{

	private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.trace("TRACE log Message");
		logger.debug("DEBUG log Message");
		logger.info("INFO log Message");
		logger.warn("WARN log Message");
		logger.error("ERROR log Message");
	}
	
}
