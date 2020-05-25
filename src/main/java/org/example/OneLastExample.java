package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneLastExample {

    static List<Person> people = Arrays.asList(
            new Person("Erik", LocalDate.parse("1976-09-11")),
            new Person("Nisse", LocalDate.parse("1983-03-03")),
            new Person("Ole", LocalDate.parse("1939-12-24")),
            new Person("Linda", LocalDate.parse("1993-06-29"))
    );



    public static void main(String[] args) {

        Converter<Person, String> converter = person -> "Name: " + person.getName() + ", age: " + Period.between(person.getBirthDate(),LocalDate.now()).getYears();

        List<String> strings = convertPeople(people, converter);
        for(String s : strings){
            System.out.println(s);
        }
    }

    public static List<String> convertPeople(List<Person> people, Converter<Person, String> converter){
        List<String> result = new ArrayList<>();
        for(Person p : people){
            result.add(converter.convert(p));
        }
        return result;
    }
}



interface Converter<T,R>{
     R convert(T t);
}

class Person{
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
