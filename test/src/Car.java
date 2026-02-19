
import java.awt.*;
import java.awt.image.BufferedImage;


public class Car implements Movable {

    protected boolean turboOn; // Turbo on/off
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected Point coord = new Point();
    protected int carAngle = 0; // Car angle in degrees

    protected BufferedImage image;

    protected boolean isLoaded = false;

    public int getNrDoors(){
        // Getter for nrDoors
        return nrDoors;
    }
    public double getEnginePower(){
        // Getter for enginePower
        return enginePower;
    }

    public double getCurrentSpeed(){
        // Getter for currentSpeed
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public Color getColor(){
        // Getter for color
        return color;
    }

    public void setColor(Color clr){
        // Setter for color
        // @param clr - car color
        color = clr;
    }

    public void startEngine(){
        // Sets current speed to 0.1
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        // Sets currentSpeed to 0
        currentSpeed = 0;
    }

    public void setTurboOn(){
        // Sets turbo to true
        turboOn = true;
    }

    public void setTurboOff(){
        // Sets turbo to false
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if ((amount < 0) || (amount > 1)){
            return;
        }

        double v0 = getCurrentSpeed();
        incrementSpeed(amount);

        if (getCurrentSpeed() < v0){
            decrementSpeed(amount);
            return;
        }

        if (getCurrentSpeed() > getEnginePower()) {
            currentSpeed = getEnginePower();
            return;
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if ((amount < 0) || (amount > 1)){
            return;
        }

        double v0 = getCurrentSpeed();
        decrementSpeed(amount);

        if (getCurrentSpeed() > v0){
            incrementSpeed(amount);
            return;
        }

        if (getCurrentSpeed() < 0) {
            currentSpeed = 0;
            return;
        }
    }


    public void move() {

        double angle = Math.PI*carAngle/180;
        coord.x += Math.cos(angle)*currentSpeed;
        coord.y += Math.sin(angle)*currentSpeed;
    }

    public void turnLeft() {
        carAngle = (carAngle + 90)%360;
    }

    public void turnRight() {
        carAngle = (carAngle - 90)%360;
    }

    public double getxCoord() { return coord.x; }

    public double getyCoord() {return coord.y;}

    public void setCoord(int x, int y) {
        coord.x = x;
        coord.y = y;
    }

    public void setCarLoaded(boolean bool) {isLoaded = bool;}
    public boolean getIsLoaded() {return isLoaded;}
}
