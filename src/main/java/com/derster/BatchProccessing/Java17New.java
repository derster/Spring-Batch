package com.derster.BatchProccessing;

import com.derster.BatchProccessing.Selead.*;

import java.util.Random;

public class Java17New {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Generate a random number between 0 and 99
        System.out.println("Random Number: " + randomNumber);

        Shape circle = new Circle(5); // Utilisation d'un cercle
        System.out.println("Circle Area: " + circle.area());

        Shape square = new Square(3); // Utilisation d'un carré
        System.out.println("Square Area: " + square.area());

        Shape triangle = new Triangle(4, 5); // Utilisation d'un triangle
        System.out.println("Triangle Area: " + triangle.area());


        Shap rectangle = new Rectangle(3, 8);
        System.out.println("Reactangle area: "+ rectangle.area());
    }
}


