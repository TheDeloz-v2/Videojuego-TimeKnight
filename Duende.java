import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class Duende extends Actor
{
    /**
     * Act - do whatever the Duende wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //VARIABLES//
    int count;
    int vida = 3;
    int speed = 1;
    Jugador jugador;
    Puntuacion contador;
    
    //FUNCIONES//
    
    public Duende(Jugador main,Puntuacion contador){
        jugador = main;
        this.contador = contador;
    }
    
    //Función Acción
    public void act() 
    {
        count++;
        Mover();
        Impacto();
    }
    
    public boolean choqueBloque(){
        if (this.isTouching(Bloque.class)){
            return true;
        }else{
            return false;
        }
    }
    
    //Función Mover
    public void Mover(){
        move(1);
        //Se mueve hacia el jugador
        turnTowards(jugador.getX(), jugador.getY());
        if(choqueBloque()){
                setLocation(getX(), getY() + speed);
            }
    }
    
    //Función Impacto de Disparo
    public void Impacto(){
       Actor disparo =  getOneIntersectingObject(Disparo.class);
       if (disparo != null){
          //Cada disparo resta 1 de vida
          vida--;
          getWorld().removeObject(disparo);
       }
       //Si pierde toda la vida, se elimina
       if (vida == 0 ){
           contador.puntos++;
           getWorld().removeObject(this);
       }
    }
}
