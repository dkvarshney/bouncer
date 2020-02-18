package com.dk.bouncer.validation.attribute.validator;

import java.io.File;

import com.dk.bouncer.exception.BouncerException;

public class FileValidator extends BaseAttributeValidator<File, FileValidator> {
	
	public FileValidator(String fieldName, File filePath) {
		super(fieldName, filePath);
	}

	public FileValidator exists() {		
		return this.exists(String.format("%s does not exist at %s.", this.attributeName, this.object));
	}
	
	public FileValidator exists(String message) {
		if (!object.exists()) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}

	public FileValidator isFile() {
		return this.isFile(String.format("%s is not a valid file.", this.attributeName));
	}
	
	public FileValidator isFile(String message) {
		if (!object.isFile()) {
			throw BouncerException.withMessage(message);
		}
		return this;
	}
}