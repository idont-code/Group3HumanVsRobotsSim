import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile extends SuperSmoothMover
{
    private double speed;      // magnitude of speed
    private int direction;     // +1 right, -1 left
    private int timer = 0;
    GreenfootImage laser = new GreenfootImage("images/laser.png");

    public Projectile(double speed, int direction)
    {
        this.speed = speed;
        this.direction = direction;
        setImage(laser);
    }

    public void act()
    {
        if (getWorld() == null) return;

        timer++;
        move();
        if (getWorld() == null) return;

        checkCollision();
        if (getWorld() == null) return;

        checkEdge();
    }

    private void move()
    {
        // Optional: accelerate every 20 acts
        if (timer % 20 == 0) {
            speed += 1.5;
        }

        double newX = getX() + speed * direction;
        setLocation((int)Math.round(newX), getY());
    }

    private void checkCollision()
    {
        Fences buildingHit = (Fences)getOneIntersectingObject(Fences.class);
        if (buildingHit != null) {
            buildingHit.damage(500);
            if(getWorld() != null) getWorld().removeObject(this);
        }
        
        
    }

    private void checkEdge()
    {
        if (getWorld() == null) return;

        int x = getX();
        if (x <= 0 || x >= getWorld().getWidth() - 1) {
            getWorld().removeObject(this);
        }
    }
}
