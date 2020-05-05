package com.dk.bouncer;

import org.junit.Assert;
import org.junit.Test;

import com.dk.bouncer.exception.BouncerException;
import com.dk.bouncer.validation.object.annotation.NotNull;
import com.dk.bouncer.validation.object.annotation.StringAnyOf;
import com.dk.bouncer.validation.object.annotation.StringLengthRange;
import com.dk.bouncer.validation.object.annotation.StringValidUrl;

public class ObjectValidatorTest {

	@Test
	public void testValidObject() {
		Employee emp = new Employee();
		emp.id = "28238";
		emp.name = "Jack";
		emp.department = "HR";
		emp.profileUrl = "http://example.com/28238";

		Bouncer.validate(emp);
	}
	
	@Test
	public void testObjectWithInvalidStringAnyOf() {
		Employee emp = new Employee();
		emp.id = "28238";
		emp.name = "Jack";
		emp.department = "INVALID";
		emp.profileUrl = "http://example.com/28238";
		
		try {
			Bouncer.validate(emp);
		} catch (BouncerException ex) {
			Assert.assertTrue(ex.getMessage().contains("department is not valid"));
		}
	}
	
	@Test
	public void testObjectWithInvalidStringLengthRange() {
		Employee emp = new Employee();
		emp.id = "28238";
		emp.name = "OK";
		emp.department = "HR";
		emp.profileUrl = "http://example.com/28238";
		
		try {
			Bouncer.validate(emp);
		} catch (BouncerException ex) {
			Assert.assertTrue(ex.getMessage().contains("name should be between 4 and 64"));
		}
	}
	
	@Test
	public void testObjectWithInvalidStringValidUrl() {
		Employee emp = new Employee();
		emp.id = "28238";
		emp.name = "Jack";
		emp.department = "HR";
		emp.profileUrl = "invalid-profile-url";
		
		try {
			Bouncer.validate(emp);
		} catch (BouncerException ex) {
			Assert.assertTrue(ex.getMessage().contains("profileUrl should be a valid ur"));
		}
	}

	static class Employee {

		@StringLengthRange(minLength = 4)
		@NotNull
		String id;

		@StringLengthRange(minLength = 4, maxLength = 64)
		@NotNull
		String name;

		@StringAnyOf(values = {"IT", "HR", "SALES"})
		@NotNull
		String department;

		@StringValidUrl
		String profileUrl;
	}
}
