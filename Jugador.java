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
    public Jugador(){
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    public void act(){
        Girar();
        Mover();
        Disparar();
        Muerte();
        tiempo++;
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
    public void Muerte(){
        if(isTouching(Duende.class)){
            getWorld().showText("- YOU DIED -\nTiempo de vida: "+ (tiempo/100), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
