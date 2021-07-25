import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class Disparo extends Actor
{
    
    //FUNCIONES//
    
    public Disparo(){
    }
    
    //Función Acción
    public void act() 
    {
        move(10);
        //En caso de chocar con borde, desaparecer
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }    
}
