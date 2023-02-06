package com.cg.exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException {

		public AdminNotFoundException(String msg) {
		super(msg);
		}

}
