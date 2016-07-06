package com.example.helloworld.producerconsumer;

/**
 * Created by h128850 on 7/6/16.
 */
abstract class PlanetHanlder{

    PlanetHanlder successor;
    void setSuccessor(PlanetHanlder successor){
        this.successor=successor;
    }
    abstract void process(Planets planet);

}
enum Planets{
     JUPITER, SATURN, NEPTUNE,EARTH, MARS;
}
class EarthHandler extends PlanetHanlder{

    @Override
    void process(Planets planet) {
        if(planet==Planets.EARTH){
            System.out.println("Request is Handled by Earth Handler ");
        }else {
            System.out.println("Earth Handler passes the request ");
            if(successor!=null)
                successor.process(planet);
        }
    }
}
class MarsHandler extends PlanetHanlder{

    @Override
    void process(Planets planet) {
        if(planet==Planets.MARS){
            System.out.println("Request is Handled by Mars Handler");
        }
        else {
            System.out.println("Mars Handler passes the Request");
            if(successor!=null)
                successor.process(planet);
        }
    }
}
class JupiterHandler extends PlanetHanlder{

    @Override
    void process(Planets planet) {
        if(planet==Planets.JUPITER){
            System.out.println("Request is Handled by Jupiter Handler");
        }
        else {
            System.out.println("Jupiter Handler passes the Request");
            if(successor!=null)
                successor.process(planet);
        }
    }
}
public class COR {
    public static void main(String[] args) {
        PlanetHanlder earthHandler=new EarthHandler();
        PlanetHanlder marsHandler=new MarsHandler();
        PlanetHanlder jupiterHandler=new JupiterHandler();

        earthHandler.setSuccessor(marsHandler);
        marsHandler.setSuccessor(jupiterHandler);

        PlanetHanlder chainOfHandlers=earthHandler;

        chainOfHandlers.process(Planets.EARTH);
        chainOfHandlers.process(Planets.JUPITER);
        chainOfHandlers.process(Planets.MARS);
        chainOfHandlers.process(Planets.NEPTUNE);


    }

}
