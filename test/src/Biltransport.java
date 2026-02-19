import java.util.ArrayList;
import java.awt.Point;

public class Biltransport extends BigCar implements Loadable, HasAngle{

    private int rampAngle;
    private ArrayList<Car> carsStorage = new ArrayList<Car>();
    private final int flakCapacity;

    public Biltransport(int flakCapacity) {
        this.flakCapacity = flakCapacity;
        rampAngle = 0;
    }

    public void changeAngle(int deltaAngle) {
        if(getCurrentSpeed() > 0){
            return;
        }

        if (deltaAngle + rampAngle > 1) {
            rampAngle = 1;
        } else if (deltaAngle + rampAngle < 0) {
            rampAngle = 0;
        } else {
            rampAngle += deltaAngle;
        }
    }

    public int getAngle() {
        return rampAngle;
    }



    public void loadCar(Car car) {
        //Checks if ramp is down
        if (rampAngle==0) {
            //Checks if distance is 5 or less
            if (Point.distance(car.coord.x, car.coord.y, this.coord.x, this.coord.y) <= 5) {
                //Checks if there is storage for car
                if (carsStorage.size() < flakCapacity) {
                    //Checks if car is instance of biltransport
                    if (!(car instanceof BigCar)) {
                        carsStorage.add(car);
                        car.coord.x = this.coord.x;
                        car.coord.y = this.coord.y;
                        car.setCarLoaded(true);
                    }
                }
            }
        }
    }

    public Car offLoadCar() {
        //Checks if ramp is down
        if (rampAngle==0) {
            if (!carsStorage.isEmpty()) {
                Car car = carsStorage.getLast();
                carsStorage.removeLast();
                car.coord.x = this.coord.x + 5;
                car.coord.y = this.coord.y;
                car.setCarLoaded(false);
                return car;
            }
        }
        return null;
    }

    @Override
    public void move()  {
        super.move();
        for (Car car: carsStorage) {
            car.coord.x = this.coord.x;
            car.coord.y = this.coord.y;
        }
    }

    public ArrayList<Car> getCarsStorage() {
        return carsStorage;
    }
}
