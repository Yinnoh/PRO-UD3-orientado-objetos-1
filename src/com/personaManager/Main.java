package com.personaManager;

import com.personaManager.utils.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Person jose = new Person("jose", "Soto", "79410692H");
        jose.setBirthDate(LocalDate.of(1998,03,16));
        jose.setEmail("jose@jose.com");
        jose.setDni("79410692H");
        System.out.println("------------ INFORMACION DE USUSARIO ------------");
        System.out.println("El dni es: " + jose.getDni());
        System.out.println("Tu fecha de nacimiento es: " + jose.getBirthDate());
        System.out.println("Tu email es: " + jose.getEmail());
        System.out.println("Tu nombre es:" + jose.getName());
        System.out.println("Tu apellido es: "+jose.getSurName());
        System.out.println("Tu edad es: " +jose.calculateAge());
        System.out.println("------------ INFORMACION DE USUSARIO ------------");

    }
}
