package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static Logger logger = LogManager.getLogger();
	
	public static void info(String messgae) {
		logger.info(messgae);
	}
	
	public static void error(String messgae) {
		logger.error(messgae);
	}
	
	public static void warn(String messgae) {
		logger.warn(messgae);
	}
	
	public static void debug(String messgae) {
		logger.debug(messgae);
	}


}
