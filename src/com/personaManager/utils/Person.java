package com.personaManager.utils;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Person {
    private String name;
    private String surName;
    private String dni;
    private LocalDate birthDate;
    private String email;
    private String[] letterDniArray = {
            "T", "R", "W", "A", "G", "M", "Y", "F","P", "D","X","B",
            "N", "J", "Z", "S", "Q,", "V", "H",	"L", "C", "K","E"
    };

    public Person(String name, String surName, String dni) {
        this.name = name;
        this.surName = surName;
        if (validateDni(dni)){
            this.dni = dni;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        boolean validateValue = validateDni(dni);
        if (validateValue){
            this.dni = dni;
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long showAge(){
        return calculateAge();
    }

    private long calculateAge(){
        LocalDate actualTime = LocalDate.now();
        return ChronoUnit.YEARS.between(this.birthDate, actualTime);
    }

    private boolean validateDni(String dni){
        Pattern validateDniPatter = Pattern.compile("^[0-9]{8,8}[a-zA-Z]$");
        Matcher validateDniMatcher = validateDniPatter.matcher(dni);
        boolean validateDniBoolean = validateDniMatcher.find();
        System.out.println(validateDniBoolean);
        if(!validateDniBoolean){
            throw new RuntimeException("The DNI length is neither too short or too big, or has a invalid format");
        }
            int passedDniToInt = Integer.parseInt(dni.substring(0,8));
            String dniLetter = getDniLetter(passedDniToInt);
           if(dniLetter.equals(dni.substring(8,9))){
               return true;
           }else {
               throw new RuntimeException("Please insert a valid DNI");
           }

    }

    private String getDniLetter(int dniNumber){
        int modulusRest =  dniNumber % 23;
        return this.letterDniArray[modulusRest];
    }

    @Override
    public String toString() {
        return "Person: " +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dni='" + dni + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ';';
    }
}
