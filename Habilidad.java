import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Habilidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Habilidad extends Actor
{
    /**
     * Act - do whatever the Habilidad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int habilidad_limite = 100;
    int habilidad_contador = 0;
    int contador;
    Habilidad habilidad;
    public Habilidad() 
    {
        setImage(new GreenfootImage(habilidad_limite + 2, 12));
        getImage().drawRect(0,0,habilidad_limite + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,habilidad_contador, 10);
    }
    public void act() 
    {
        setImage(new GreenfootImage(habilidad_limite + 2, 12));
        getImage().drawRect(0,0,habilidad_limite + 1,11);
        getImage().setColor(Color.CYAN);
        getImage().fillRect(1,1,habilidad_contador, 10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getJugador().getX() - 5, myWorld.getJugador().getY() - 50);
        UsarHabilidad();
    }
    public void super_habilidad(){
        
    }
    public void UsarHabilidad(){
        contador++;
        if(contador % 5==0){    
            habilidad_contador++;
        }
    }
}
