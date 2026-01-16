package com.orangeHRM.test;

import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;

public class DummyClass extends BaseClass {
	@Test
	
	public void dummyTest() {
		String title= driver.getTitle();
		assert title.equals("OrangeHRM"): "Test failed - Title is not matching ";
		
		System.out.println("Test Passed - Title is Matching");
		}
	

}
