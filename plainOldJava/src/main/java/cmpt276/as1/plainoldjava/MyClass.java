package cmpt276.as1.plainoldjava;

import cmpt276.as1.plainoldjava.model.Car;

public class MyClass {
    public MyClass() {
    }

    public static void main(String[] args) {
        System.out.println("Hello Java world from Android Studio!");

        Car myCar = new Car("Some epic thing!");
        System.out.println(myCar.getModel());
    }
}