import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class for all building-type objects (e.g., Fences, Turrets).
 * Contains shared properties like hitpoints and basic damage/removal logic.
 */
public abstract class Building extends SuperSmoothMover {
    protected int hitpoint;  // shared HP field

    public Building(int hp) {
        this.hitpoint = hp;
    }

    public void act() {
        checkDestroyed();
    }

    /**
     * Damages the building by a given amount.
     */
    public void damage(int amount) {
        hitpoint -= amount;
        if (hitpoint < 0) hitpoint = 0;
        onDamage(); // allows subclasses to respond to damage (e.g., update HP bar)
    }

    /**
     * Checks if the building should be removed when HP reaches 0.
     */
    protected void checkDestroyed() {
        if (hitpoint <= 0) {
            onDestroyed();
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Hook methods for subclasses to customize behavior.
     */
    protected abstract void onDamage();
    protected abstract void onDestroyed();
}
