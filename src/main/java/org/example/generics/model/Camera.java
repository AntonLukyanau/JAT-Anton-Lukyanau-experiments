package org.example.generics.model;

import java.util.Objects;

public class Camera extends Product<Camera> {
    private int pixel;
    private String brand;

    public Camera(String name, long price, int pixel, String brand) {
        super(name, price);
        this.pixel = pixel;
        this.brand = brand;
    }

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(Camera camera) {
        int cameraDiff = this.pixel - camera.pixel;
        if (cameraDiff != 0) {
            return cameraDiff;
        }
        int cameraBrandDiff = this.brand.compareTo(camera.brand);
        if (cameraBrandDiff != 0) {
            return cameraBrandDiff;
        }
        return super.compareTo(camera);
    }
}
