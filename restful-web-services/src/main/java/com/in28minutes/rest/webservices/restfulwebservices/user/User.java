package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer id;

	// Validacion para que el nombre tenga al menos dos caracteres
	@Size(min = 2, message = "Name should have at least 2 characters")
	// Podemos cambiar el nombre de como se ve en la respuesta con @JSONProperty
	@JsonProperty("user_name")
	private String name;

	// Validacion para que la fecha sea en el pasado
	@Past(message = "Birthdate should be in the past")
	@JsonProperty("birh_date")
	private LocalDate brithDate;

	public User(Integer id, String name, LocalDate brithDate) {
		super();
		this.id = id;
		this.name = name;
		this.brithDate = brithDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(LocalDate brithDate) {
		this.brithDate = brithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", brithDate=" + brithDate + "]";
	}

}
