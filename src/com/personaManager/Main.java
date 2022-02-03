package com.personaManager;

import com.personaManager.utils.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Person jose = new Person("jose", "Soto", "79410692H");
        jose.setBirthDate(LocalDate.of(1998,01,25));
        jose.setEmail("jose@jose.com");
        jose.setDni("79410693H");

        printpersonInformation(jose);

        jose.setName("Manuel Alejandro");
        jose.setSurName("Garrido");

        System.out.println("\n");

        printpersonInformation(jose);
    }

    static void printpersonInformation(Person person){
        System.out.println("------------ INFORMACION DE USUSARIO ------------");
        System.out.println("El dni es: " + person.getDni());
        System.out.println("Tu fecha de nacimiento es: " + person.getBirthDate());
        System.out.println("Tu email es: " + person.getEmail());
        System.out.println("Tu nombre es: " + person.getName());
        System.out.println("Tu apellido es: "+person.getSurName());
        System.out.println("Tu edad es: " +person.showAge());
        System.out.println("------------ INFORMACION DE USUSARIO ------------");
    }
}
