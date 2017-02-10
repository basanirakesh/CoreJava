package com.br.random;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Person implements Serializable, Comparable<Person> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 37127887701008861L;

	private String name;
	private BigDecimal salary;
	private Date doj;

	public Person(String name, BigDecimal salary, Date doj) {
		this.name = name;
		this.salary = salary;
		this.doj = doj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public int compareTo(Person person) {
		return this.salary.compareTo(person.getSalary());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", salary=" + salary + ".$"+ ", doj=" + doj + "]";
	}
}
