package com.dk.bouncer.validation.object.validator;

import java.lang.annotation.Annotation;

import com.dk.bouncer.exception.BouncerException;

public class NumberDivisibleValidator implements BaseObjectValidator {

	@Override
	public void validate(String fieldName, Annotation annotation, Object object) {
		throw BouncerException.withMessage("not implemented yet.");
//		if (object != null && object instanceof Number) {
//			NumberDivisibleBy ann = (NumberDivisibleBy) annotation;
//			if (object instanceof Integer) {
//				if (((Integer) object % ann.value()) != 0) {
//					throw BouncerException.withMessage(String.format(ann.message(), fieldName, fieldName, ann.value()));
//				}	
//			} else if (object instanceof Float) {
//				if (((Float) object % ann.value()) != 0) {
//					throw BouncerException.withMessage(String.format(ann.message(), fieldName, ann.value()));
//				}
//			} else if (object instanceof Double) {
//				if (((Double) object % ann.value()) != 0) {
//					throw BouncerException.withMessage(String.format(ann.message(), fieldName, fieldName, ann.value()));
//				}
//			} else if (object instanceof Long) {
//				if (((Long) object % ann.value()) != 0) {
//					throw BouncerException.withMessage(String.format(ann.message(), fieldName, fieldName, ann.value()));
//				}
//			}
//		}
	}
}
