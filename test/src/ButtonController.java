import java.util.ArrayList;
import java.util.Random;

public class ButtonController {

    private final int carCap = 10;
    private ArrayList<Car> cars = new ArrayList<>();

    public ButtonController(ArrayList<Car> cars) {
        this.cars = cars;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car: cars) {
            car.brake(brake);
        }
    }

    void setTurboOn() {
        for (Car car: cars) {
            if (car instanceof Saab95) {
                car.setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Car car: cars) {
            if (car instanceof Saab95) {
                car.setTurboOff();
            }
        }
    }

    void changeAngle(int deltaAngle) {
        for (Car car: cars) {
            if (car instanceof Scania) {
                ((Scania) car).changeAngle(deltaAngle);
            }
        }
    }

    void startEngine() {
        for (Car car: cars) {
            car.stopEngine();
        }
    }

    void stopEngine() {
        for (Car car: cars) {
            car.stopEngine();
        }
    }

    void addCar(String carModelName) {
        if (cars.size() < carCap) {
            Car addedCar = CarFactory.createCar(carModelName);
            Random random = new Random();
            addedCar.setCoord(0, random.nextInt( 500));
            cars.add(addedCar);
        }
    }

    void removeCar() {
        if (!cars.isEmpty()) {
           cars.removeLast();
           System.out.println(cars.size());
        }
    }
}
