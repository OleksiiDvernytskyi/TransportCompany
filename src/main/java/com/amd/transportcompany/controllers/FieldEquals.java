package com.amd.transportcompany.controllers;


import java.lang.annotation.*;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amd
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = FieldEqualsValidator.class)
public @interface FieldEquals {
	public static final String MESSAGE = "fields.notMatches";

	String message() default MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target(TYPE)
	@Retention(RUNTIME)
	@interface List {
		FieldEquals[] value();
	}

	String field();

	String equalsTo();
}