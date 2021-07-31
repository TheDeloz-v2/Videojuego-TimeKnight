import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class Jugador extends Actor
{
    
    //VARIABLES//
    int speed = 4;
    int tiempo = 0;
    int vida = 10;
    int Hcontador;
    Habilidad habilidad;
    
    //FUNCIONES//
    
    //Jugador Individual
    public Jugador(){
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    
    //Jugador sujeto a su habilidad
    public Jugador(Habilidad habilidad){
        this.habilidad = habilidad;
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 35, 70, 10);
    }
    
    //Funcion Acción
    public void act(){
        Girar();
        Mover();
        Disparar();
        //Mientras Jugador vivo el tiempo aumenta
        tiempo++;
        UsarHabilidad();
        GolpeDuende();
    }
    
    //Función Girar
    public void Girar(){
        if (Greenfoot.getMouseInfo() != null){
           //Gira en base al mouse
           turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY()); 
        }
    }
    
    //Función Moverse
    public void Mover(){
        //Derecha
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + speed, getY());
            if(choqueBloque()){
                setLocation(getX() - speed, getY());
            }
        }
        //Izquierda
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - speed, getY());
            if(choqueBloque()){
                setLocation(getX() + speed, getY());
            }
        }
        //Arriba
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX() , getY() - speed);
            if(choqueBloque()){
                setLocation(getX(), getY() + speed);
            }
        }
        //Abajo
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX() , getY() + speed);
            if(choqueBloque()){
                setLocation(getX(), getY() - speed);
            }
        }
    }
    
    //Función Disparar
    public void Disparar(){
        if(Greenfoot.mousePressed(null)){
            Disparo disparo = new Disparo();
            getWorld().addObject(disparo, getX(), getY());
            disparo.setRotation(getRotation());
        }
    }
    
    //Función Usar Habilidad
    public void UsarHabilidad(){
        if(habilidad.habilidad_contador > 99 && Hcontador <30){
            //Disparos en 6 direcciones diferentes
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
        
        //Reinicio del contador
        if(Hcontador>29){
            habilidad.habilidad_contador = 0;
            Hcontador = 0;
        }
    }
    
    public boolean choqueBloque(){
        if (this.isTouching(Bloque.class)){
            return true;
        }else{
            return false;
        }
    }
    
    //Función Golpe de Duende
    public boolean GolpeDuende(){
        Actor duende = getOneObjectAtOffset(0,0,Duende.class);
        if(duende != null){
            return true;
        } else {
            return false;
        }
    }
}
