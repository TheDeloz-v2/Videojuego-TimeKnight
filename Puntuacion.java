import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class Puntuacion extends Actor
{
    
    //VARIABLES//
    int puntos = 0;
    
    //FUNCIONES//
    
    public Puntuacion(){
        //Se genera gráficamente el contador de puntos
        setImage(new GreenfootImage("Puntuación: " +puntos, 40, Color.BLACK, new Color (0,0,0,0)));
    }
    
    //Función Acción
    public void act() 
    {
        //Se genera gráficamente el contador de puntos
        setImage(new GreenfootImage("Puntuación: " +puntos, 40, Color.BLACK, new Color (0,0,0,0)));
    }    
}
