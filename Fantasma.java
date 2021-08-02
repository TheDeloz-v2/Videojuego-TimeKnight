import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fantasma extends Actor
{
    //VARIABLES//
    int count;
    int vida = 1;
    int speed = 1;
    Jugador jugador;
    Puntuacion contador;
    
    //FUNCIONES//
    
    public Fantasma(Jugador main,Puntuacion contador){
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

    //Función Mover
    public void Mover(){
        move(1);
        //Se mueve hacia el jugador
        turnTowards(jugador.getX(), jugador.getY());
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
