import greenfoot.*;
import java.util.ArrayList;

public class MeleeRobot extends Robot {
    private int cooldown = 0;

    GreenfootImage robot = new GreenfootImage("images/robot.png");
    private static final int DELAY = 60;


    public MeleeRobot(int health, double speed, int range, int damage, int delay) {
        super(health, speed, range, damage, delay);
        robot.scale(20,50);
        setImage(robot);
    }

    public void act() {
        super.act();
        attackHumans();
        if (getHealth() <= 0) getWorld().removeObject(this);
    }
}
