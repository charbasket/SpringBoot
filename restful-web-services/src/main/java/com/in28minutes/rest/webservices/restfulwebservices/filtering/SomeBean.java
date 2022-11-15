package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Podemos ignorar algunos campos en la respuesta con @JsonIgnoreProperties. Si hay varios campos se pasa com array
@JsonIgnoreProperties({ "field1", "field4" })
public class SomeBean {

	private String field1;
	// Podemos ignorar algunos campos en la respuesta con @JsonIgnore
	@JsonIgnore
	private String field2;
	private String field3;
	private String field4;

	public SomeBean(String field1, String field2, String field3, String field4) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	public String getField4() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4=" + field4 + "]";
	}

}
