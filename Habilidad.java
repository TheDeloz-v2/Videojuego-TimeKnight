import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class Habilidad extends Actor
{
    
    //VARIABLES//
    final int habilidad_limite = 100;
    int habilidad_contador = 0;
    int contador;
    Habilidad habilidad;
    
    //FUNCIONES//
    
    public Habilidad(){
        //Se genera gráficamente la barra de carga
        setImage(new GreenfootImage(habilidad_limite + 2, 12));
        getImage().drawRect(0,0,habilidad_limite + 1,11);
        getImage().setColor(Color.BLUE);
        //Se rellena en base a variable habilidad_contador
        getImage().fillRect(1,1,habilidad_contador, 10);
    }
    
    //Función Acción
    public void act() 
    {
        //Se genera gráficamente la barra de carga
        setImage(new GreenfootImage(habilidad_limite + 2, 12));
        getImage().drawRect(0,0,habilidad_limite + 1,11);
        getImage().setColor(Color.CYAN);
        getImage().fillRect(1,1,habilidad_contador, 10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        //Se coloca arriba del Jugador
        setLocation(myWorld.getJugador().getX(), myWorld.getJugador().getY() - 50);
        UsarHabilidad();
    }
    public void super_habilidad(){  
    }
    
    //Función Usar Habilidad
    public void UsarHabilidad(){
        //Contador
        contador++;
        //Tiempo de recarga de la Habilidad
        if(contador % 5==0){    
            habilidad_contador++;
        }
    }
}
