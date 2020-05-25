package org.example;

import org.example.interfaces.Generator;

import java.util.concurrent.ThreadLocalRandom;

public class ShowingGenerator {

    public static void main(String[] args) {
        Generator randomNumber = () -> ThreadLocalRandom.current().nextInt();

        System.out.println(randomNumber.generate());
    }
}
