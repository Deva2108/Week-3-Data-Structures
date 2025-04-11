class Vehicle {
    String type = "Vehicle";

    public void displayType() {
        System.out.println("This is a " + type);
    }
}

class Car extends Vehicle {
    String type = "Car";  // Hiding the parent class field

    public void displayType() {
        super.displayType();  // Calls the parent class's method
        System.out.println("This is a " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.displayType();
    }
}
