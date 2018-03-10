package pl.andrzejszywala.samples.lambdas;

import static java.lang.System.out;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static pl.andrzejszywala.samples.lambdas.LambdaSamples.City.Athens;
import static pl.andrzejszywala.samples.lambdas.LambdaSamples.City.London;
import static pl.andrzejszywala.samples.lambdas.LambdaSamples.City.Warsaw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.Test;

public class LambdaSamples {
	enum City {
		London, Athens, Warsaw;
	}
	
	class Person {
		private int age;
		private String name;
		private City city;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
		public Person(int age, String name, City city) {
			super();
			this.age = age;
			this.name = name;
			this.city = city;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + ", city=" + city + "]";
		}

	}
	
	private Collection<Person> persons = Arrays.asList(
			new Person(10, "Andrzej", Warsaw),
			new Person(30, "Marek", Athens),
			new Person(22, "Wojtek", London),
			new Person(22, "Przemek", Athens));

	@Test
	public void printFirstFound() {
		Stream.of("Andrzej", "Wojtek", "Marek")
		      .filter("Wojtek"::equals)
		      .findFirst()
		      .ifPresent(out::println);
	}

	@Test
	public void valueOrDefault() {
		System.out.println(Optional.ofNullable(persons.iterator().next())
			.map(Person::getName)
			.orElse("dupa"));
	}

	@Test
	public void sum() {
		BigDecimal[] vals = new BigDecimal[100];
		Arrays.setAll(vals, i -> new BigDecimal(i));
		System.out.println(Arrays.stream(vals)
				                 .reduce(BigDecimal::add).get());
		// works only with immutable collections
		System.out.println(Arrays.stream(vals)
				                 .reduce(BigDecimal.ZERO, BigDecimal::add));
	}

	@Test
	public void sortedNamesOfPersons() {
		System.out.println(
			persons.stream()
			       .map(Person::getName)
			       .collect(toCollection(TreeSet::new)));
	}

	@Test
	public void namesByAgeJoinedWithSemicolonSorted() {
		System.out.println(
			persons.stream()
			       .collect(toMap(Person::getAge, 
			    		          Person::getName, 
			    		          (a, b) -> a + ";" + b,
			    		          TreeMap::new)));
	}

	@Test
	public void namesByAgeJoinedWithSemicolon() {
		System.out.println(
			persons.stream()
			       .collect(toMap(Person::getAge, 
			    		          Person::getName, 
			    		          (a, b) -> a + ";" + b)));
	}
	
	@Test
	public void joinedNamesByAge() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge, mapping(Person::getName, joining()))));
	}

	@Test
	public void agesAsList() {
		System.out.println(
			persons.stream()
			       .collect(mapping(Person::getAge, toList())));
	}

	@Test
	public void agesAsSet() {
		System.out.println(
			persons.stream()
			       .collect(mapping(Person::getAge, toSet())));
	}

	@Test
	public void setOfPersonsGroupedByAge() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge, toSet())));
	}
	

	@Test
	public void commaSeparatedNamesOfPersons() {
		System.out.println(
			persons.stream()
			       .map(Person::getName)
			       .collect(joining(", ")));
	}

	@Test
	public void mostPopularAges() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge, counting()))
			       .entrySet().stream()
			       .collect(groupingBy(Map.Entry::getValue, 
			    		   mapping(Map.Entry::getKey, toSet()))));
	}

	@Test
	public void citiesWithMoreThenOneOccupant() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getCity, counting()))
			       .entrySet().stream()
			       .filter(e -> e.getValue() > 1)
			       .map(Map.Entry::getKey)
			       .collect(toList()));
	}

	@Test
	public void numberOfPersonsByAge() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge, counting())));
	}

	@Test
	public void namesByAge() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge, mapping(Person::getName, toList()))));
	}

	@Test
	public void peopleByAge() {
		System.out.println(
			persons.stream()
			       .collect(groupingBy(Person::getAge)));
	}

	@Test
	public void setOfPeopleAges() {
		System.out.println(
			persons.stream()
				   .map(Person::getAge)
				   .collect(toSet()));
	}

	@Test
	public void topOldest() {
		System.out.println(persons.stream()
		       .sorted(Comparator.comparingInt(Person::getAge).reversed())
		       .limit(2)
		       .collect(toList()));
	}
}
