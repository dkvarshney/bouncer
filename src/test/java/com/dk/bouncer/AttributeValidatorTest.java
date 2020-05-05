package com.dk.bouncer;

import org.junit.Assert;
import org.junit.Test;

import com.dk.bouncer.exception.BouncerException;

public class AttributeValidatorTest {
	
	@Test
	public void testIsNotNull() {
		try {
			String attribute = null;
			Bouncer.makeSure(attribute, "UserId").isNotNull();
		} catch (BouncerException ex) {
			Assert.assertTrue(ex.getMessage(), ex.getMessage().contains("UserId should not be null"));
		}
	}

	@Test
	public void testIsValidEmail() {
		try {
			String attribute = "invalid.email";
			Bouncer.makeSure(attribute, "Email Address").isValidEmail();
		} catch (BouncerException ex) {
			Assert.assertTrue(ex.getMessage(), ex.getMessage().contains("Email Address should be a valid email address"));
		}
	}
}
