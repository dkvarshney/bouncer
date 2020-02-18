package com.dk.bouncer.validation.attribute.validator;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.dk.bouncer.exception.BouncerException;

public class CollectionValidator<T1, T2 extends Collection<T1>> extends BaseAttributeValidator<T2, CollectionValidator<T1, T2>> {
	
	public CollectionValidator(String fieldName, T2 value) {
		super(fieldName, value);
	}

	public CollectionValidator<T1, T2> isNotEmpty() {
		return this.isNotEmpty(String.format("%s should not be empty.", this.attributeName));
	}
	
	public CollectionValidator<T1, T2> isNotEmpty(String message) {
		if (this.object.isEmpty()) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public CollectionValidator<T1, T2> isNotLongerThan(int limit) {
		return this.isNotLongerThan(limit, String.format("%s should not be more than %d.", this.attributeName, limit));
	}
	
	public CollectionValidator<T1, T2> isNotLongerThan(int limit, String message) {
		if (this.object.size() > limit) {
			throw new RuntimeException(message);
		}
		return this;
	}

	public CollectionValidator<T1, T2> andEachWithIndex(BiConsumer<String, T1> consumer) {
		int index = 0;
		for (T1 ent : object) {
			String fieldSubI = String.format("%s[%s]", attributeName, index);
			consumer.accept(fieldSubI, ent);
			index++;
		}
		return this;
	}

	public CollectionValidator<T1, T2> andEach(Consumer<T1> consumer) {
		for (T1 ent : object) {
			consumer.accept(ent);
		}
		return this;
	}
}
