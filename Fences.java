import greenfoot.*;  
import java.util.List;

public class Fences extends Building {
    public static SuperStatBar fenceHPBar;
    private static boolean fencesComplete = false;
    private static int hpBarY = 400;

    private GreenfootImage fence = new GreenfootImage("images/fence.png");

    public Fences() {
        super(5000); // pass HP to Building
        fence.scale(30, 60);
        setImage(fence);
    }

    public void act() {
        super.act(); // keeps Building behavior
        if (getWorld() == null) return;

        if (fenceHPBar != null) {
            fenceHPBar.setLocation(getWorld().getWidth() / 2 - 50, hpBarY);
        }
    }

    public static void createFenceBar(World world) {
        if (fenceHPBar == null) {
            fenceHPBar = new SuperStatBar(5000, 0, null, 50, 6, -40, Color.GREEN, Color.RED);
            world.addObject(fenceHPBar, world.getWidth() / 2, hpBarY);
        }
    }

    @Override
    protected void onDamage() {
        if (fencesComplete && fenceHPBar != null) {
            fenceHPBar.update(hitpoint);
        }
    }

    @Override
    protected void onDestroyed() {
        if (fenceHPBar != null && getWorld() != null) {
            getWorld().removeObject(fenceHPBar);
        }
        removeAllFences();
    }

    private void removeAllFences() {
        if (getWorld() == null) return;
        List<Fences> all = getWorld().getObjects(Fences.class);
        for (Fences f : all) {
            if (f.getWorld() != null) f.getWorld().removeObject(f);
        }
    }

    public static void setFencesComplete(boolean value) {
        fencesComplete = value;
    }
}


