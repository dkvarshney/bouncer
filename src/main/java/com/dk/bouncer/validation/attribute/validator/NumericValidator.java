package com.dk.bouncer.validation.attribute.validator;

import com.dk.bouncer.exception.BouncerException;

public class NumericValidator<T extends Number> extends BaseAttributeValidator<T, NumericValidator<T>> {

	public NumericValidator(String fieldName, T value) {
		super(fieldName, value);
	}
	
	public NumericValidator<T> isGreaterThan(T other) {
		return this.isGreaterThan(other, String.format("%s should be greater than " + other, this.attributeName));
	}

	public NumericValidator<T> isGreaterThan(T other, String message) {
		if (this.object == null) {
			return this;
		}

		int cmp = compare(this.object, other);
		if (cmp < 0) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public NumericValidator<T> isLessThan(T other) {
		return this.isLessThan(other, String.format("%s should be less than " + other, this.attributeName));
	}

	public NumericValidator<T> isLessThan(T other, String message) {
		if (this.object == null) {
			return this;
		}
		int cmp = compare(this.object, other);
		if (cmp > 0) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public NumericValidator<T> isDivisibleBy(int other) {
		return this.isDivisibleBy(other, String.format("%s should be less than " + other, this.attributeName));
	}

	public NumericValidator<T> isDivisibleBy(int other, String message) {
		if (this.object == null) {
			return this;
		}

		if (compare(modulo(this.object, other), 0) != 0) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	private <N extends Number> int compare(N n1, N n2) {
		if (n1 instanceof Integer) {
			return ((Integer) n1).compareTo((Integer) n2);
		}
		if (n1 instanceof Long) {
			return ((Long) n1).compareTo((Long) n2);
		}
		if (n1 instanceof Float) {
			return ((Float) n1).compareTo((Float) n2);
		}
		throw BouncerException.withMessage("Unsupported type: " + n1.getClass());
	}

	@SuppressWarnings("unchecked")
	private <N extends Number> N modulo(N dividend, int divisor) {
		if (dividend instanceof Integer) {
			return (N) Integer.valueOf(dividend.intValue() % divisor);
		}
		if (dividend instanceof Long) {
			return (N) Long.valueOf(dividend.longValue() % divisor);
		}
		throw BouncerException.withMessage("Unsupported type: " + dividend.getClass());
	}
}