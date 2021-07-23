import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Duende here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Duende extends Actor
{
    /**
     * Act - do whatever the Duende wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count;
    int vida = 3;
    Jugador jugador;
    Puntuacion contador;
    public Duende(Jugador main,Puntuacion contador){
        jugador = main;
        this.contador = contador;
    }
    public void act() 
    {
        count++;
        Mover();
        Impacto();
    }
    public void Mover(){
        move(1);
        turnTowards(jugador.getX(), jugador.getY());
    }
    public void Impacto(){
       Actor disparo =  getOneIntersectingObject(Disparo.class);
       if (disparo != null){
          vida--;
          getWorld().removeObject(disparo);
       }
       if (vida == 0 ){
           contador.puntos++;
           getWorld().removeObject(this);
       }
    }
}
