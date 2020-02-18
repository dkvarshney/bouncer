package com.dk.bouncer.validation.object;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.dk.bouncer.validation.object.annotation.NotNull;
import com.dk.bouncer.validation.object.annotation.NumberAnyOf;
import com.dk.bouncer.validation.object.annotation.NumberDivisibleBy;
import com.dk.bouncer.validation.object.annotation.NumberNoneOf;
import com.dk.bouncer.validation.object.annotation.NumberValueRange;
import com.dk.bouncer.validation.object.annotation.StringAnyOf;
import com.dk.bouncer.validation.object.annotation.StringLengthRange;
import com.dk.bouncer.validation.object.annotation.StringNoneOf;
import com.dk.bouncer.validation.object.annotation.StringPattern;
import com.dk.bouncer.validation.object.annotation.StringValidBase64;
import com.dk.bouncer.validation.object.annotation.StringValidUrl;
import com.dk.bouncer.validation.object.validator.BaseObjectValidator;

public final class ObjectValidator {

	private static Set<Class<? extends Annotation>> validAnnotations = new HashSet<Class<? extends Annotation>>();

	static {
		// common object related annotations.
		register(NotNull.class);

		// number related annotations.
		register(StringAnyOf.class);
		register(StringLengthRange.class);
		register(NumberAnyOf.class);
		register(NumberDivisibleBy.class);
		register(NumberNoneOf.class);		
		register(NumberValueRange.class);
		
		// string related annotations.
		register(StringAnyOf.class);
		register(StringLengthRange.class);
		register(StringNoneOf.class);
		register(StringPattern.class);
		register(StringValidBase64.class);		
		register(StringValidUrl.class);
	}
	
	public static void register(Class<? extends Annotation> annotation) {
		validAnnotations.add(annotation);
	}

	public static void unregister(Class<? extends Annotation> annotation) {
		validAnnotations.remove(annotation);
	}
	
	public static void validate(Object object) {
		try {
			Field fileds[] = object.getClass().getDeclaredFields();
			for (Field field : fileds) {
				boolean isFieldAccessible = field.isAccessible();
				field.setAccessible(true);
				Annotation[] list = field.getAnnotations();
				for (Annotation annotation : list) {
					Class<? extends Annotation> annotationType = annotation.annotationType();
					if (validAnnotations.contains(annotationType)) {
						@SuppressWarnings("unchecked")
						Class<? extends BaseObjectValidator> validator = (Class<? extends BaseObjectValidator>) 
						annotationType.getMethod("validator").invoke(annotation);
						validator.newInstance().validate(field.getName(), annotation, field.get(object));
					}
				}
				// restore the actual field state.
				field.setAccessible(isFieldAccessible);
			}
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
}
