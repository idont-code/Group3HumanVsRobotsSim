import greenfoot.*;
import java.util.ArrayList;

public class MeleeRobot extends Robot {
    private int cooldown = 0;
<<<<<<< HEAD:TinyRobot.java
    GreenfootImage robot = new GreenfootImage("images/robot.png");
    private static final int DELAY = 60;

    public TinyRobot(int health, double speed, int range, int damage) {
        super(health, speed, range, damage);
        robot.scale(30,50);
        setImage(robot);
=======

    public MeleeRobot(int health, double speed, int range, int damage, int delay) {
        super(health, speed, range, damage, delay);
>>>>>>> b14af75208cdbabeeddaedce29c06904fc641446:MeleeRobot.java
    }

    public void act() {
        super.act();
        attackHumans();
        if (getHealth() <= 0) getWorld().removeObject(this);
    }
}
