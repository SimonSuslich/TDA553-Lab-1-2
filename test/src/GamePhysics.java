import java.awt.*;

public class GamePhysics {
    CarView frame;

    public GamePhysics(CarView frame) {
        this.frame = frame;
    }

    boolean checkHitWall(Car car) {
        int carWidth = car.image.getWidth();
        int carHeight = car.image.getHeight();
        Dimension windowSize = frame.drawPanel.getSize();


        if (windowSize.height < car.getyCoord()+carHeight) {
            return true;
        }

        if (windowSize.width < car.getxCoord()+carWidth) {
            return true;
        }

        if (0 > car.getyCoord()) {
            return true;
        }
        if (0 > car.getxCoord()) {
            return true;
        }
        return false;
    }

    boolean atAutoShopColide(Car car){
        int carWidth = car.image.getWidth();
        int carHeight = car.image.getHeight();
        Point autoShopSize = frame.drawPanel.volvoWorkshopPoint;
        int autoShopWidth = frame.drawPanel.volvoWorkshopImage.getWidth();
        int autoShopHeight = frame.drawPanel.volvoWorkshopImage.getHeight();





        if ((autoShopSize.y < car.getyCoord()+carHeight && autoShopSize.y +autoShopHeight > car.getyCoord()+carHeight) ||  (autoShopSize.y < car.getyCoord() && autoShopSize.y +autoShopHeight > car.getyCoord())) {
            if ((autoShopSize.x < car.getxCoord()+carWidth && autoShopSize.x +autoShopWidth > car.getxCoord()+carWidth) ||  (autoShopSize.x < car.getxCoord() && autoShopSize.x +autoShopWidth > car.getxCoord())) {
                return true;
            }
        }

        return false;
    }
}
