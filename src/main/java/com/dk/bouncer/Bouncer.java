/*******************************************************************************
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.dk.bouncer;

import java.io.File;
import java.sql.Timestamp;
import java.util.Collection;

import com.dk.bouncer.validation.attribute.AttributeValidator;
import com.dk.bouncer.validation.attribute.validator.CollectionValidator;
import com.dk.bouncer.validation.attribute.validator.FileValidator;
import com.dk.bouncer.validation.attribute.validator.NumericValidator;
import com.dk.bouncer.validation.attribute.validator.ObjectValidator;
import com.dk.bouncer.validation.attribute.validator.StringValidator;
import com.dk.bouncer.validation.attribute.validator.TimestampValidator;

public class Bouncer {
	
	// StringValidator
    public static <T extends String> StringValidator makeSure(T object, String fieldName) {
        return AttributeValidator.validate(fieldName, object);
    }

    
    // NumericValidator
	public static <T extends Number> NumericValidator<T> makeSure(T object, String fieldName) {
		return AttributeValidator.validate(fieldName, object);
    }
	
	
	// TimestampValidator
    public static <T extends Timestamp> TimestampValidator makeSure(T object, String fieldName) {
        return AttributeValidator.validate(fieldName, object);
    }

    // FileValidator
    public static <T extends String> FileValidator makeSure(File fileName, String fieldName) {
        return AttributeValidator.validate(fieldName, fileName);
    }

    // Object Validator
    public static <T extends Object> ObjectValidator<Object> makeSure(Object object, String fieldName) {
        return AttributeValidator.validate(fieldName, object);
    }
   
    // CollectionValidator
    public static <T1, T2 extends Collection<T1>> CollectionValidator<T1, T2> makeSure(T2 object, String fieldName) {
        return AttributeValidator.validate(fieldName, object);
    }
    
    public static void validate(Object object) {
    	com.dk.bouncer.validation.object.ObjectValidator.validate(object);
    }
}
