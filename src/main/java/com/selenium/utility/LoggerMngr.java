package com.selenium.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerMngr {
	
	public Logger logger;
	
	public LoggerMngr(String className) {
    	  
    	// Here we need to create logger instance so we need to pass Class name for 
    	//which  we want to create log file in my case Google is classname
    	  logger= Logger.getLogger(className);
    	       

    	      // configure log4j properties file
    	  PropertyConfigurator.configure(System.getProperty("user.dir")+"//Resources//Log4j.properties");
    	  
      }
}
