import greenfoot.*;

public class Builders extends Actor{
    private int fenceSpacing = 40;
    private int lastFenceY;
    private int speed = 2;
    private int fenceCount = 0;
    private int maxFences = 13;
    private SuperStatBar workProgressBar;
    private long stopUntil = 0;

    public Builders() {
        workProgressBar = new SuperStatBar(maxFences, 0, this, 50, 6, -40, Color.GREEN, Color.RED);
    }

    public void addedToWorld(World world) {
        world.addObject(workProgressBar, getX(), getY() - 40);
        lastFenceY = getY();
    }

    public void act() {
        if (getWorld() == null) return;

        if (fenceCount >= maxFences) {
            getWorld().removeObject(workProgressBar);
            // Tell fences that building is complete
            Fences.setFencesComplete(true);

            // Create the fence HP bar once building is done
            Fences.createFenceBar(getWorld());
            return;
        }

        // Move downward
        setLocation(getX(), getY() + speed);

        // Build fence every set distance
        if (getY() - lastFenceY >= fenceSpacing) {
            makeFence();
            fenceCount++;
            workProgressBar.update(fenceCount);
            lastFenceY = getY();
        }
    }

    private void makeFence() {
        getWorld().addObject(new Fences(), getX() - 50, getY());
    }
}




