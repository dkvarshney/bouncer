package com.dk.bouncer.validation.attribute.validator;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.dk.bouncer.exception.BouncerException;

public abstract class BaseAttributeValidator<T, V extends BaseAttributeValidator<T, V>> {

	protected final String attributeName;
	protected final T object;

	public BaseAttributeValidator(String fieldName, T value) {
		this.attributeName = fieldName;
		this.object = value;
	}

	@SuppressWarnings("unchecked")
	public V and(Consumer<T> consumer) {
		consumer.accept(object);
		return (V) this;
	}

	public V is(Predicate<T> condition) {
		return this.is(condition, String.format("%s does not match with predicate condition.", this.attributeName));
	}

	@SuppressWarnings("unchecked")
	public V is(Predicate<T> condition, String message) {
		if (!condition.test(object)) {
			throw BouncerException.withMessage(message);
		}
		return (V) this;
	}

	public V isNotNull() {
		return this.isNotNull(String.format("%s should not be null.", this.attributeName));
	}

	@SuppressWarnings("unchecked")
	public V isNotNull(String message) {
		if (object == null) {
			throw BouncerException.withMessage(message);
		}
		return (V) this;
	}

	@SuppressWarnings("unchecked")
	public V isNull(String message) {
		if (object != null) {
			throw BouncerException.withMessage(message);
		}
		return (V) this;
	}

	@SuppressWarnings("unchecked")
	public V isAnyOf(Collection<? extends T> others, String message) {    	
		if (!others.contains(object)) {
			throw BouncerException.withMessage(message);
		}
		return (V) this;
	}

}
