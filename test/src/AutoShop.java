import java.awt.*;
import java.util.ArrayList;

public class AutoShop<CarBrand extends Car> {
    private final int workShopCapacity;
    private ArrayList<CarBrand> carsStorage = new ArrayList<CarBrand>();

    public AutoShop(int workShopCapacity) {
        this.workShopCapacity = workShopCapacity;
    }

    public void loadCar(CarBrand car) {
        if (carsStorage.size() < workShopCapacity){
            if (!carsStorage.contains(car)) {
                carsStorage.add(car);
                car.setCarLoaded(true);
            }
        }
    }

    public Car offLoadCar(Car car) {
        if (!carsStorage.isEmpty()) {
            int index = carsStorage.indexOf(car);
            if (index == -1) {
                throw new IndexOutOfBoundsException("Car is not in Autoshop");
            }
            Car repairedCar = carsStorage.get(index);
            carsStorage.remove(car);
            car.setCarLoaded(false);
            return repairedCar;
        }
        throw new IllegalArgumentException("Workshop is empty");
    }

    public ArrayList getCarsStorage() {
        return  carsStorage;
    }
}
