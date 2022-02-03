package com.personaManager.utils;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.LocalDate;


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
        if (dni.length()!= 9 ){
            throw new RuntimeException("The DNI length is neither too short or too big");
        }else{
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
        if (dni.length() != 9){
            throw new RuntimeException("The DNI length is neither too short or too big");
        }else{
            if (validateDni(dni)){
               this.dni = dni;
            }else{
                throw new RuntimeException("The dni is invalid please insert a valid one");
            }
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
        if (dni.length() > 9 || dni.length()<9){
            throw new RuntimeException("The DNI length is neither too short or too big");
        }else{
            int passedDniToInt = Integer.parseInt(dni.substring(0,8));
            String dniLetter = getDniLetter(passedDniToInt);
            return dniLetter.equals(dni.substring(8,9))? true: false;
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
