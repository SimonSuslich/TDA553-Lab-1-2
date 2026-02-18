import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        //cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           for (Car car : cars) {
                int x = (int) Math.round(car.getxCoord());
                int y = (int) Math.round(car.getyCoord());
                if (!checkHitWall(car)) {
                    car.move();
                    x = (int) Math.round(car.getxCoord());
                    y = (int) Math.round(car.getyCoord());
                    System.out.println("Yo");
                    frame.drawPanel.moveit(x, y);
               } else {
                    car.setCurrentSpeed(0);
                    System.out.println("No");
                }
                System.out.println("Coords: "+x + "," + y);
                System.out.println("Speed: "+car.getCurrentSpeed());

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
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

    boolean checkHitWall(Car car) {
        int carWidth = frame.drawPanel.volvoImage.getWidth();
        int carHeight = frame.drawPanel.volvoImage.getHeight();
        Dimension windowSize = frame.drawPanel.getSize();


        if (windowSize.height < car.getyCoord()+carHeight) {
            System.out.println(windowSize.height + "--- " + car.getyCoord() + carHeight + " Y coord over window");
            return true;
        }

        if (windowSize.width < car.getxCoord()+carWidth) {
            System.out.println(windowSize.width + "--- " + car.getxCoord() + carWidth + " X coord over window");
            return true;
        }

        if (0 > car.getyCoord()) {
            System.out.println(0 + "--- " + car.getyCoord() + " x Coord lower than 0");
            return true;
        }
        if (0 > car.getxCoord()) {
            System.out.println(0 + "--- " + car.getxCoord() + " y coord lower than 0");
            return true;
        }
        return false;
    }
//Chech hit wall fast för autoshop
    void atAutoShop(Car car){
        //int autoShopWidth =
    }
}
