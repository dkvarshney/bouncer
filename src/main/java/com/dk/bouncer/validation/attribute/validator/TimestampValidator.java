package com.dk.bouncer.validation.attribute.validator;

import java.sql.Timestamp;

import com.dk.bouncer.exception.BouncerException;

public class TimestampValidator extends BaseAttributeValidator<Timestamp, TimestampValidator> {

    public TimestampValidator(String fieldName, Timestamp value) {
        super(fieldName, value);
    }

    public TimestampValidator isBefore(Timestamp timestamp) {
    	return this.isBefore(timestamp, String.format("%s should be before %s", this.attributeName, timestamp));
    }
    
    public TimestampValidator isBefore(Timestamp timestamp, String message) {
        if (this.object.after(timestamp)) {
            throw BouncerException.withMessage(message);
        }
        return this;
    }

    public TimestampValidator isAfter(Timestamp timestamp) {
    	return this.isAfter(timestamp, String.format("%s should be after %s", this.attributeName, timestamp));
    }
    
    public TimestampValidator isAfter(Timestamp timestamp, String message) {
        if (this.object.before(timestamp)) {
        	throw BouncerException.withMessage(message);
        }
        return this;
    }
}