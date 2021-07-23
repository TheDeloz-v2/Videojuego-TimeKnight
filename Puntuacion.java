import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puntuación here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntuacion extends Actor
{
    /**
     * Act - do whatever the Puntuación wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int puntos = 0;
    public Puntuacion(){
        setImage(new GreenfootImage("Puntuación: " +puntos, 40, Color.BLACK, new Color (0,0,0,0)));
    }
    public void act() 
    {
        setImage(new GreenfootImage("Puntuación: " +puntos, 40, Color.BLACK, new Color (0,0,0,0)));
    }    
}
