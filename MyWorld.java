import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World
{
    GreenfootImage background = new GreenfootImage("images/background.png");
    public static int topEdge = 275;
    public static int areaHeight = 750;
    public MyWorld()
    {    
        super(1240,700, 1); 
        setBackground(background);
        testPrepare();

    }
        private void testPrepare() {
<<<<<<< HEAD
        /*for (int i = 0; i < 5; i++) {
            RockThrower rt = new RockThrower(100, 1.5, 200, 10);
            addObject(rt, Greenfoot.getRandomNumber(getWidth() / 2) + getWidth()/2, Greenfoot.getRandomNumber(getHeight()));
=======
        for (int i = 0; i < 5; i++) {
            RangedHuman rockThrower = new RangedHuman(100, 1.5, 200, 10, 100);
            addObject(rockThrower, Greenfoot.getRandomNumber(getWidth() / 2) + getWidth()/2, Greenfoot.getRandomNumber(getHeight()));
>>>>>>> b14af75208cdbabeeddaedce29c06904fc641446
        }

        for (int i = 0; i < 5; i++) {
            ExplodingRobot er = new ExplodingRobot(80, 1.2, 150, 50);
            addObject(er, Greenfoot.getRandomNumber(getWidth() / 2), Greenfoot.getRandomNumber(getHeight()));
        }

        for (int i = 0; i < 3; i++) {
            MeleeHuman rockSmasher = new MeleeHuman(150, 1.0, 75, 20, 10);
            addObject(rockSmasher, Greenfoot.getRandomNumber(getWidth() / 2) + getWidth()/2, Greenfoot.getRandomNumber(getHeight()));
        }
        */
        for (int i = 0; i < 3; i++) {
<<<<<<< HEAD
            TinyRobot tr = new TinyRobot(150, 1.0, 75, 20);
            addObject(tr, Greenfoot.getRandomNumber(getWidth() / 2), Greenfoot.getRandomNumber(areaHeight) + topEdge);
=======
            MeleeRobot tinyRobot = new MeleeRobot(150, 1.0, 75, 20, 50);
            addObject(tinyRobot, Greenfoot.getRandomNumber(getWidth() / 2), Greenfoot.getRandomNumber(getHeight()));
>>>>>>> b14af75208cdbabeeddaedce29c06904fc641446
        }
    
    
        Builders men = new Builders();
        addObject(men, getWidth()/2, getHeight()/4);
        
        Turret turret = new Turret();
        addObject(turret, 100 , getHeight()/2+100);
        
        //Turret turret1 = new Turret();
        //addObject(turret1, 920 , getHeight()/2+100);
    }
}
