package com.derster.BatchProccessing.Selead;

public final class Rectangle implements Shap{

    private final double width;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    private final double height;


    @Override
    public double area() {
        return width * height;
    }
}
