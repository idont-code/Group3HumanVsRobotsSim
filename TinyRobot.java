import greenfoot.*;
import java.util.ArrayList;

public class TinyRobot extends Robot {
    private int cooldown = 0;
    GreenfootImage robot = new GreenfootImage("images/robot.png");
    private static final int DELAY = 60;

    public TinyRobot(int health, double speed, int range, int damage) {
        super(health, speed, range, damage);
        robot.scale(30,50);
        setImage(robot);
    }

    public void act() {
        super.act();
        attackHumans();
        if (getHealth() <= 0) getWorld().removeObject(this);
    }
}
