import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Salud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarraSalud extends Actor
{
    /**
     * Act - do whatever the Salud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int salud = 50;
    double salud2 = (double)salud;
    public BarraSalud(){
        setImage(new GreenfootImage(205, 50));
        getImage().drawRect(0,0,201,40);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,(salud*4),39);
    }
    public void act() 
    {
        setImage(new GreenfootImage(205, 50));
        getImage().drawRect(0,0,201,40);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,(salud*4),39);
        perderSalud();
    }    
    public void perderSalud(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getJugador().GolpeDuende()){
            salud--;
        }
        if(salud<=0){
            getWorld().showText("- YOU DIED -\nTiempo de vida: "+ (myWorld.getJugador().tiempo/100) + " segundos.", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
