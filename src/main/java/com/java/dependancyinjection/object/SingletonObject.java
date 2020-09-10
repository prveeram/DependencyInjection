package com.java.dependancyinjection.object;

import com.java.dependancyinjection.inject.Injectable;

public class SingletonObject  implements Injectable{
	
	String value;

	@Override
	public void add_new_value(String valueToAdd) {
		this.value = valueToAdd;
		
	}

	@Override
	public String retreive_stored_value() {
		return this.value;
	}
	
}
