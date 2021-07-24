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
    int Hcontador;
    Habilidad habilidad;
    public Jugador(){
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    public Jugador(Habilidad habilidad){
        this.habilidad = habilidad;
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    public void act(){
        Girar();
        Mover();
        Disparar();
        tiempo++;
        UsarHabilidad();
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
    public void UsarHabilidad(){
        if(habilidad.habilidad_contador > 99 && Hcontador <30){
            Disparo disparo = new Disparo();
            getWorld().addObject(disparo, getX(), getY());
            disparo.setRotation(getRotation()-60);
            disparo.move(1);
            Disparo disparo2 = new Disparo();
            getWorld().addObject(disparo2, getX(), getY());
            disparo2.setRotation(getRotation()+60);
            disparo2.move(1);
            Disparo disparo3 = new Disparo();
            getWorld().addObject(disparo3, getX(), getY());
            disparo3.setRotation(getRotation());
            disparo3.move(1);
            
            Disparo disparo4 = new Disparo();
            getWorld().addObject(disparo4, getX(), getY());
            disparo4.setRotation(getRotation()-180);
            disparo4.move(1);
            Disparo disparo5 = new Disparo();
            getWorld().addObject(disparo5, getX(), getY());
            disparo5.setRotation(getRotation()+120);
            disparo5.move(1);
            Disparo disparo6 = new Disparo();
            getWorld().addObject(disparo6, getX(), getY());
            disparo6.setRotation(getRotation()-120);
            disparo6.move(1);
            
            Hcontador++;
        }
        if(Hcontador>29){
            habilidad.habilidad_contador = 0;
            Hcontador = 0;
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
