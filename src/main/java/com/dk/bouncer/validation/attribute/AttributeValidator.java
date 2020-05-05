package com.dk.bouncer.validation.attribute;

import java.io.File;
import java.sql.Timestamp;
import java.util.Collection;

import com.dk.bouncer.validation.attribute.validator.CollectionValidator;
import com.dk.bouncer.validation.attribute.validator.FileValidator;
import com.dk.bouncer.validation.attribute.validator.NumericValidator;
import com.dk.bouncer.validation.attribute.validator.ObjectValidator;
import com.dk.bouncer.validation.attribute.validator.StringValidator;
import com.dk.bouncer.validation.attribute.validator.TimestampValidator;

public final class AttributeValidator {
	
	// StringValidator
    public static <T extends String> StringValidator validate(String fieldName, T object) {
        return new StringValidator(fieldName, object);
    }

    
    // NumericValidator
	public static <T extends Number> NumericValidator<T> validate(String fieldName, T object) {
        return new NumericValidator<T>(fieldName, object);
    }
	
	
	// TimestampValidator
    public static <T extends Timestamp> TimestampValidator validate(String fieldName, T object) {
        return new TimestampValidator(fieldName, object);
    }

    // FileValidator
    public static <T extends String> FileValidator validate(String fieldName, File fileName) {
        return new FileValidator(fieldName, fileName);
    }

    public static <T extends Object> ObjectValidator<Object> validate(String fieldName, Object object) {
        return new ObjectValidator<Object>(fieldName, object);
    }
   
    // CollectionValidator
    public static <T1, T2 extends Collection<T1>> CollectionValidator<T1, T2> validate(String fieldName, T2 object) {
        return new CollectionValidator<T1, T2>(fieldName, object);
    }
}
