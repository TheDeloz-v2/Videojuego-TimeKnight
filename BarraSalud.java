import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class BarraSalud extends Actor
{
    
    //VARIABLES//
    int salud = 50;
    double salud2 = (double)salud;
    
    //FUNCIONES//
    public BarraSalud(){
        //Se genera gráficamente la barra de salud
        setImage(new GreenfootImage(205, 50));
        getImage().drawRect(0,0,201,40);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,(salud*4),39);
    }
    
    //Función Acción
    public void act() 
    {
        //Se genera gráficamente la barra de salud
        setImage(new GreenfootImage(205, 50));
        getImage().drawRect(0,0,201,40);
        getImage().setColor(Color.RED);
        //Se rellena en base a variable salud
        getImage().fillRect(1,1,(salud*4),39);
        perderSalud();
    }
    
    //Función Perder Salud
    public void perderSalud(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        //Cuando Golpe de Duende suceda
        if(myWorld.getJugador().GolpeDuende()){
            salud--;
        }
        //En caso de perder toda la salud
        if(salud<=0){
            getWorld().showText("- YOU DIED -\nTiempo de vida: "+ (myWorld.getJugador().tiempo/100) + " segundos.", getWorld().getWidth()/2, getWorld().getHeight()/2);
            //Finaliza el juego
            Greenfoot.stop();
        }
    }
}
