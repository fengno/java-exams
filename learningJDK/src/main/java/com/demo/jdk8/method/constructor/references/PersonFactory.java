package com.demo.jdk8.method.constructor.references;

interface PersonFactory<P extends Person> {

	P create(String firstName, String lastName);

}