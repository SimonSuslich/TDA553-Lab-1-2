import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends BigCar implements HasAngle {

    private int flakAngle;

    public Scania() {
        nrDoors = 2;
        color = Color.black;
        enginePower = 90;
        modelName = "Scania";
        stopEngine();
        flakAngle = 0;
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public void changeAngle(int deltaAngle) {
        if(getCurrentSpeed() > 0){
            return;
        }

        if (deltaAngle + flakAngle > 70) {
            flakAngle = 70;
        } else if (deltaAngle + flakAngle < 0) {
            flakAngle = 0;
        } else {
            flakAngle += deltaAngle;
        }
    }

    public int getAngle() {
        return flakAngle;
    }

    @Override
    public void incrementSpeed(double amount) {
        //System.out.println(flakAngle);
        if (flakAngle == 0) {
            super.incrementSpeed(amount);
        }
    }

    @Override
    public void startEngine() {
        if (flakAngle == 0) {
            super.startEngine();
        }
    }
}
