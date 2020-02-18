# bouncer
A simple but powerful library for validations in Java.

Example 1: Attribute Validations
    String something = "hello";
		Bouncer.makeSure("Attribute", something)
			.isNotBlank()
			.isNotLongerThan(10)
			.isNotShorterThan(5)
      ... many more.
      
Example 2: Object Validations
  Employee emp = something.
  Bouncer.validate(emp);
  
  class Employee {		
		@StringLengthRange(minLength = 4)
		@NotNull
		String id;
		
		@StringLengthRange(minLength = 4, maxLength = 64)
		@NotNull
		String name;
		
		@StringAnyOf(values = {"IT", "HR", "SALES"})
		@NotNull
		String department;
		
		@StringValidUrl
		String profileUrl;
	}
