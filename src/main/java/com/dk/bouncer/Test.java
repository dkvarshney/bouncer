package com.dk.bouncer;

import com.dk.bouncer.validation.object.annotation.NotNull;
import com.dk.bouncer.validation.object.annotation.StringAnyOf;
import com.dk.bouncer.validation.object.annotation.StringLengthRange;
import com.dk.bouncer.validation.object.annotation.StringValidUrl;

public class Test {

	public static void main(String[] args) throws Exception {
		// sample tests, change the value and verify.
		
		// example #1
		Employee emp = new Employee();
		emp.id = "28238";
		emp.name = "Jack";
		emp.department = "HR";
		emp.profileUrl = "http://abc.com/28238";

		// invoke validation on emp,
		Bouncer.validate(emp);
		
		
		// example #2
		String something = "hello";
		Bouncer.makeSure("Attribute", something)
			.isNotBlank()
			.isNotLongerThan(10)
			.isNotShorterThan(5);
		
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
