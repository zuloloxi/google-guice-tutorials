package com.mvpjava.guicetutorial.singleImpl;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class MainImplTest {

    	//static MainImplTest m = new MainImplTest();
	@BeforeClass 
	public static void initialize() {
		System.out.println("This is printed only once at the MainImplTest at beginning @BeforeClass");
	}
	@AfterClass 
	public static void destroy() {
		System.out.println("@AfterClass MainImplTest - last thing printed");
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before MainImplTest - for before thing printed");
	}

	@Test
	public void test() {
/*
		fail(" fail ok ");*/
		try {
		  MainImplTest.main(new String[] {"arg1", "arg2", "arg3"});
	    } catch (Exception exception) {
	    exception.printStackTrace();
	    }
		System.out.println("######### PROGRAM FINISHED ###############");
	}	
	public static void main(String[] args) {
        Injector guice = Guice.createInjector(new DiscountGuiceModule());
        CheckoutService service = guice.getInstance(CheckoutService.class);
        
        service.checkout(100.00D);
    }
}
