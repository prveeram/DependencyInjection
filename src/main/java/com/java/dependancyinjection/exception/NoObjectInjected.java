package com.java.dependancyinjection.exception;

public class NoObjectInjected extends Exception {
	public NoObjectInjected(String errorMessage) {
		super(errorMessage);
	}
}
