package com.java.dependancyinjection.inject;

public class DependancyInjector {
	
	private Injectable injectedClass;
	
	public DependancyInjector(Injectable injectedObject) {
		this.injectedClass=injectedObject;
	}
	
	public DependancyInjector() {
		
	}

	public void setInjectedClass(Injectable injectedObject) {
		this.injectedClass=injectedObject;
	}
	
	public Injectable getInjectedClass() {
		return this.injectedClass;
	}

}
