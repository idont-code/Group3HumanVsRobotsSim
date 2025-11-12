import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Turret extends Building {
    private GreenfootImage turret = new GreenfootImage("images/turret.png");
    private long lastShotTime = 0;
    private long cooldown = 2000;

    public Turret() {
        super(1000); // pass HP to Building
        turret.scale(100, 200);
        turret.mirrorHorizontally();
        setImage(turret);
    }

    public void act() {
        super.act(); // use Building behavior
        if (System.currentTimeMillis() - lastShotTime >= cooldown) {
            shoot();
            lastShotTime = System.currentTimeMillis();
        }
    }

    private void shoot() {
        double bulletSpeed = 4;
        int direction = -1;
        if (getX() < getWorld().getWidth() / 2) 
        {
            direction*=-1;
        }
        Projectile b = new Projectile(bulletSpeed, direction);
        getWorld().addObject(b, getX() + direction*10, getY() - 43);
    }

    protected void onDamage() {
        System.out.println("Turret HP: " + hitpoint);
    }

    protected void onDestroyed() {
        System.out.println("Turret destroyed!");
    }
}

