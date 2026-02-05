import java.util.ArrayList;

public class AutoShop<CarBrand extends Car> {
    private final int workShopCapacity;
    private ArrayList<CarBrand> carsStorage = new ArrayList<>();

    public AutoShop(int workShopCapacity) {
        this.workShopCapacity = workShopCapacity;
    }

    public void loadCar(CarBrand car) {
        if (carsStorage.size() < workShopCapacity) carsStorage.add(car);
    }

    public Car offLoadCar() {
        if (!carsStorage.isEmpty()) {
            CarBrand repairedCar = carsStorage.getLast();
            carsStorage.removeLast();
            return repairedCar;
        }
        return null;
    }
}
