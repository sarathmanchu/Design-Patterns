package com.example.helloworld.producerconsumer;

/**
 * Created by h128850 on 7/5/16.
 */
public class TestDecorator {
    public static void main(String[] args) {
        Icecream icecream=new NuttyDecorator(new ChoclateDecorator(new BaseIcecream()));
        System.out.println(icecream.makeIcecream());
    }
}
interface Icecream{
    public String makeIcecream();
}
class BaseIcecream implements Icecream {

    @Override
    public String makeIcecream() {
        return "Icecream";
    }

}
abstract class IcecreamDecorator implements Icecream{
    protected Icecream specialIcecream;

    public IcecreamDecorator(Icecream specialIcecream) {
        this.specialIcecream = specialIcecream;
    }

    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream();
    }
}
class NuttyDecorator extends IcecreamDecorator{

    public NuttyDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }

    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream()+addNuts();
    }
    private String addNuts(){
        return " + With Nuts";
    }
}
class ChoclateDecorator extends IcecreamDecorator{

    public ChoclateDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }

    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream()+addHoney();
    }
    private String addHoney(){
        return " + with Chocalte";
    }
}