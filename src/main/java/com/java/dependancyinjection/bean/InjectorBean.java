package com.java.dependancyinjection.bean;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.java.dependancyinjection.exception.InvalidInputException;
import com.java.dependancyinjection.exception.NoObjectInjected;
import com.java.dependancyinjection.inject.DependancyInjector;
import com.java.dependancyinjection.inject.Injectable;
import com.java.dependancyinjection.object.PrototypeObject;

public class InjectorBean {

	private static final Logger LOGGER = LogManager.getLogger(InjectorBean.class);  
	
	private HashMap<String, DependancyInjector> injectedObjects =  new HashMap<String, DependancyInjector>();
	
	public void do_the_injection(Injectable objectInput, String keyIdentifier) throws InvalidInputException  {
		if(objectInput == null) {
			LOGGER.error("Invalid objectInput");
			throw new InvalidInputException("Please pass a valid input");
		}
			if (PrototypeObject.class.isInstance(objectInput)) {
				do_a_prototype_injection((PrototypeObject) objectInput, keyIdentifier);
			} else {
				do_a_singleton_injection(objectInput, keyIdentifier);
			}

	}
	
	private void do_a_singleton_injection(Injectable objectInput,String keyIdentifier ) {
		LOGGER.info("Doing a Singletion Injection");
		DependancyInjector di = new DependancyInjector();
		di.setInjectedClass(objectInput);
		this.injectedObjects.put(keyIdentifier, di);
	}
	
	private void do_a_prototype_injection(PrototypeObject objectInput, String keyIdentifier)  {
		LOGGER.info("Doing a Prototype Injection");
		DependancyInjector di = new DependancyInjector(objectInput);
		this.injectedObjects.put(keyIdentifier, di);
	}
	
	public DependancyInjector getInjectedObject(String keyIdentifier) throws NoObjectInjected, InvalidInputException {
		if(this.injectedObjects.size() == 0) {
			LOGGER.error("injectedObjects hashmap is empty");
			throw new NoObjectInjected("Injection list is empty");
		}
		if(!this.injectedObjects.containsKey(keyIdentifier)) {
			LOGGER.error("Invalid keyIdentifier");
			throw new InvalidInputException("Given keyIdentifier not found");
		}
		
		return this.injectedObjects.get(keyIdentifier);
	}
	

}
