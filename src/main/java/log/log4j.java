package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.extern.log4j.Log4j;

public class log4j {
	
	private static Logger logger=LogManager.getLogger(Log4j.class);
			
	public static void main(String[] args) {
		
		System.out.println("logcheck");
		logger.info("logcheck");
		
	}
   
	
	
	
}
