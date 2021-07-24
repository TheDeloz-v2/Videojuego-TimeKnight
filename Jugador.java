import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 4;
    int tiempo = 0;
    int vida = 10;
    Habilidad habilidad;
    public Jugador(){
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    public Jugador(Habilidad habilidad){
        
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    public void act(){
        Girar();
        Mover();
        Disparar();
        tiempo++;
        GolpeDuende();
    }
    public void Girar(){
    if (Greenfoot.getMouseInfo() != null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY()); 
    }
    public void Mover(){
        if(Greenfoot.isKeyDown("d")){
        setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("a")){
        setLocation(getX() - speed, getY()); 
        }
        if(Greenfoot.isKeyDown("w")){
        setLocation(getX() , getY() - speed); 
        }
        if(Greenfoot.isKeyDown("s")){
        setLocation(getX() , getY() + speed); 
        }
    }
    public void Disparar(){
        if(Greenfoot.mousePressed(null)){
            Disparo disparo = new Disparo();
            getWorld().addObject(disparo, getX(), getY());
            disparo.setRotation(getRotation());
    }
    }
    public boolean GolpeDuende(){
        Actor duende = getOneObjectAtOffset(0,0,Duende.class);
        if(duende != null){
            return true;
        } else {
            return false;
        }
    }
}
