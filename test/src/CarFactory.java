import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CarFactory {

    private static final ArrayList<Class<? extends Car>> allSmallCarModels = new ArrayList<>(Arrays.asList(Volvo240.class, Saab95.class));

     static public Car createCar(String carModelName) {
        if (carModelName == null) {
            //Random random = new Random();
            //int randomIndex = random.nextInt(allSmallCarModels.size() - 1);
            //return allSmallCarModels.get(randomIndex)

            carModelName = "Volvo240";
        }

        for (Class<? extends Car> carClass : allSmallCarModels) {
            try {
                Car car = carClass.getDeclaredConstructor().newInstance();
                if (car.modelName.equals(carModelName)) {
                    return car;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         //if input incorrect
        return new Volvo240();
    }
}
