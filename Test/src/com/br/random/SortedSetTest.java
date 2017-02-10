package com.br.random;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	public static void main(String[] args) {
		SortedSet<Person> personSet = new TreeSet<>();

		personSet.add(new Person("Rakesh", new BigDecimal("1234"), new Date()));
		personSet.add(new Person("Rakesh", new BigDecimal("3214"), new Date()));
		personSet.add(new Person("Rakesh", new BigDecimal("2314"), new Date()));

		int count = 1;
		// Iterator
		System.out.println("=============== Iterator Logic - Start==================");
		for (Iterator<Person> iterator = personSet.iterator(); iterator.hasNext();) {
			Person person = iterator.next();
			System.out.println("Person " + count++ + " - " + person);
			iterator.remove();
			if (count == 3) {
				personSet.add(new Person("Rakesh", new BigDecimal("333"), new Date()));
				iterator = personSet.iterator();
			}
		}
		System.out.println("=============== Iterator Logic - End ==================");

		SortedSet<Person> personSet1 = new TreeSet<>();

		personSet1.add(new Person("Rakesh", new BigDecimal("1234"), new Date()));
		personSet1.add(new Person("Rakesh", new BigDecimal("3214"), new Date()));
		personSet1.add(new Person("Rakesh", new BigDecimal("2314"), new Date()));

		count = 1;
		// Iterator
		System.out.println("=============== First element logic - Start==================");
		while (personSet1.isEmpty() == false) {
			Person person = personSet1.first();
			System.out.println("Person " + count++ + " - " + person);
			personSet1.remove(person);
			if (count == 3) {
				personSet1.add(new Person("Rakesh", new BigDecimal("3333"), new Date()));
			}
		}
		System.out.println("=============== First element logic - End ==================");
	}
}
