package com.TFL_Tube.utilities;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Created by Disha
 */
public class TestUtils {
    public static String getRandomValue() {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }

    public static String getRandomName() {
        String saltChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder name = new StringBuilder();
        Random random = new Random();
        while (name.length() < 10) {
            int index = (int) (random.nextFloat() * saltChars.length());
            name.append(saltChars.charAt(index));
        }
        String saltStr = (name.toString());
        return saltStr;
    }

    public static String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(generateFirstName());
    }

    public static String generateName() {
        Faker faker = new Faker();
        return faker.name().name();
    }
}
