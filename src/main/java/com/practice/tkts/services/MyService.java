package com.practice.tkts.services;

import org.apache.log4j.Logger;

import com.practice.tkts.exception.MyException;

public class MyService {

	Logger logger = Logger.getLogger(MyService.class);
	
	public String myMethod() throws Exception
	{
		
		logger.debug("In my method");
		String message = null;
		try{
			try{
				
				throw new MyException("404","NMy nmessahl");
			}catch(MyException myException){
				logger.error("First catch");
				throw myException;
			}
		}catch(MyException exception){
			logger.error("Second catch");
			throw exception;
		}
		
	}
}
