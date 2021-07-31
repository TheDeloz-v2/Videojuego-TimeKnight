import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * @author: Diego Estuardo Lemus López
 * @version: 
 *          (Creación 21/07/2021)
 *          (Última modificación 24/07/2021)
 */
public class MyWorld extends World
{

    //VARIABLES//
    int count = 0;
    int velocidadAparicion = 30;
    int randomAparicion;
    Jugador main = new Jugador();
    public Puntuacion contador = new Puntuacion();
    public Salud salud = new Salud();
    public BarraSalud barraSalud = new BarraSalud();
    public Habilidad habilidad = new Habilidad();
    public Bloque bloque = new Bloque();
    
    //FUNCIONES//
    public MyWorld()
    {
        //Medidas del mundo
        super(1200, 700, 1);
        main = new Jugador(habilidad);
        //Se agregan los objetos
        addObject(main, getWidth()/2, getHeight()/2);
        addObject(contador, 130, 40);
        addObject(salud, 865, 40);
        addObject(barraSalud, 865, 90);
        
        BloqueH bh1 = new BloqueH();
        addObject(bh1, 700, 200);
        BloqueH bh2 = new BloqueH();
        addObject(bh2, 300, 200);
        BloqueH bh3 = new BloqueH();
        addObject(bh3, 700, 540);
        BloqueH bh4 = new BloqueH();
        addObject(bh4, 300, 540);
        
        BloqueV bv1 = new BloqueV();
        addObject(bv1, 810, 310);
        BloqueV bv2 = new BloqueV();
        addObject(bv2, 190, 310);
        //BloqueV bv3 = new BloqueV();
        //addObject(bv3, 810, 90);
        //BloqueV bv4 = new BloqueV();
        //addObject(bv4, 865, 90);
        
        addObject(habilidad, main.getX(), main.getY()-50);
    }
    
    public Jugador getJugador(){
        return main;
    }
    
    //Funcion Acción
    public void act(){
        count++;
        //Pausar juego presionando letra "P"
        while(Greenfoot.isKeyDown("p")){
            Greenfoot.delay(1);
        }
        aparecerDuendes();
    }
    
    //Funcion Aparecer Duendes
    public void aparecerDuendes(){
        if (count % velocidadAparicion == 0){
            randomAparicion = Greenfoot.getRandomNumber(8);
            //Aparición random en 8 puntos del mapa
            switch(randomAparicion){
                case 0: addObject(new Duende(main, contador), 0, 0); break;
                case 1: addObject(new Duende(main, contador), 0, getHeight()); break;
                case 2: addObject(new Duende(main, contador), getWidth(), 0); break;
                case 3: addObject(new Duende(main, contador), getWidth()/2, 0); break;
                case 4: addObject(new Duende(main, contador), getWidth(), getHeight()/2); break;
                case 5: addObject(new Duende(main, contador), 0, getHeight()/2); break;
                case 6: addObject(new Duende(main, contador), getWidth()/2, getHeight()); break;
                case 7: addObject(new Duende(main, contador), getWidth(), getHeight()/2); break;
            }
        }
    }
}
