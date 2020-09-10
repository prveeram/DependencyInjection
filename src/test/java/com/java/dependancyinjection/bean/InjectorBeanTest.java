package com.java.dependancyinjection.bean;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import com.java.dependancyinjection.exception.InvalidInputException;
import com.java.dependancyinjection.exception.NoObjectInjected;
import com.java.dependancyinjection.object.PrototypeObject;
import com.java.dependancyinjection.object.SingletonObject;

public class InjectorBeanTest {

	private static InjectorBean beanToInject = new InjectorBean();
	
	public final static String PROTOTYPE_INJECTION = "this is a prototype injection";

	public final static String SINGLETON_INJECTION = "this is a singleton injection";
	
	@After
	public void afterEachTest() {
		System.out.println("TEST SUCCEEDED");
	}

	@Test
	public void testSingletonObjectInjection() throws InvalidInputException, NoObjectInjected  {
		System.out.println("Testing testSingletonObjectInjection");
		String keyIdentifier = "some_key_for_singleton";
		SingletonObject object = new SingletonObject();
		
		object.add_new_value(SINGLETON_INJECTION);
		beanToInject.do_the_injection(object, keyIdentifier);
		assertEquals(SINGLETON_INJECTION, beanToInject.getInjectedObject(keyIdentifier).getInjectedClass().retreive_stored_value());
	}

	@Test
	public void testPrototypeObjectInjection() throws InvalidInputException, NoObjectInjected  {
		System.out.println("Testing testPrototypeObjectInjection");
		String keyIdentifier = "some_key_for_prototype";
		PrototypeObject object = new PrototypeObject();
		
		object.add_new_value(PROTOTYPE_INJECTION);
		beanToInject.do_the_injection(object, keyIdentifier);
		assertEquals(PROTOTYPE_INJECTION, beanToInject.getInjectedObject(keyIdentifier).getInjectedClass().retreive_stored_value());
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInvalidInputException() throws Exception{
		System.out.println("Testing testInvalidInput Exception");
		beanToInject.do_the_injection(null, null);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInvalidInputExceptionWithDummyKey() throws NoObjectInjected, InvalidInputException {
		System.out.println("Testing testInvalidInputExceptionWithDummyKey");
			beanToInject.getInjectedObject("dummy_key");
	}


}
