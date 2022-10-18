/*
 * Created by dotrinh on 10/18/22, 9:08 PM
 * Copyright (c) 2022. dotr Inc. All rights reserved.
 */

package com.dotrinh.software_design_pattern.creational_patterns;

import androidx.annotation.NonNull;

/**
 * avoid too many params in constructor
 */
public class Builder_User_2 {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private Builder_User_2(UserBuilder builder) { //pass builder object
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @NonNull
    @Override
    public String toString() {
        return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", " + this.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {//required
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        //Return the finally constructed User object
        public Builder_User_2 build() {
            Builder_User_2 builderUser2 = new Builder_User_2(this);
            validateUserObject(builderUser2);
            return builderUser2;
        }

        private void validateUserObject(Builder_User_2 builderUser2) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}