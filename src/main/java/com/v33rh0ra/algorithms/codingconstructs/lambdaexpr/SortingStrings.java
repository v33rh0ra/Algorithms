package com.v33rh0ra.algorithms.codingconstructs.lambdaexpr;

import java.util.*;

public class SortingStrings {
    public static class Person{
        String firstName;
        String lastName;

        Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return this.lastName+", "+this.firstName;
        }
    }
    public void printStrings(List<String> list){

        list.forEach(System.out::print);
        System.out.println("");
    }

    public List<String> sortStrings7(List<String> list){
        System.out.println("Java 7");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();// asc
//                return o2.length() - o1.length();//desc
            }
        });
        printStrings(list);
        return list;
    }

    public List<String> sortStrings8(List<String> list){
        return sortStrings8(list, false);
    }
    public List<String> sortStrings8(List<String> list, boolean desc){
        System.out.println("Java 8");
        if (desc){
            list.sort(Comparator.comparingInt(String::length).reversed());
        }else{
            list.sort(Comparator.comparingInt(String::length));
        }

        printStrings(list);
        return list;
    }

    public List<Person> sortPeople(List<Person> people ){
        return sortPeople(people, false);
    }
    public List<Person> sortPeople(List<Person> people, boolean desc ){
        Comparator<Person> comparator = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);
        if(desc){
            comparator = comparator.reversed();

        }
        people.sort(comparator);

        people.forEach(System.out::println);
        return people;
    }
    public static void main(String[] args) {
        SortingStrings ss = new SortingStrings();
        List<String> list = Arrays.asList("Apple", "Mango", "Peach", "Banana", "Kiwi", "Pineapple",
                "Strawberry", "Raspberry", "Plum", "Orange");
        ss.sortStrings7(list);
        List<String> list2 = Arrays.asList("Apple", "Mango", "Peach", "Banana", "Kiwi", "Pineapple",
                "Strawberry", "Raspberry", "Plum", "Orange");
        ss.sortStrings8(list2,true);
        Person[] peopleArr = {
                new Person("Nelson", "Mandela"),
                new Person("Mahatma", "Gandhi"),
                new Person("Abraham", "Lincoln"),
                new Person("Martin Luther", "King Jr"),
                new Person("Mother","Teresa"),
                new Person("George", "Washington"),
                new Person("Karamchand", "Gandhi"),
                new Person("Indira","Gandhi"),
                new Person("Alexander", "Lincoln")
        };
        ss.sortPeople(Arrays.asList(peopleArr),true);

    }

}
