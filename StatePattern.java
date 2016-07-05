package com.example.helloworld.producerconsumer;

/**
 * Created by h128850 on 7/5/16.
 */
public class StatePattern {
    public static void main(String[] args) {
        RingStateContext ringContext=new RingStateContext();
        ringContext.ring();
        ringContext.setCurrState(new Vibrate());
        ringContext.ring();
        ringContext.setCurrState(new Silent());
        ringContext.ring();
    }
}
interface State{
    public void ring();
}
class Silent implements State{

    @Override
    public void ring() {
        System.out.println("In Silent Mode");
    }
}
class Sound implements State{

    @Override
    public void ring() {
        System.out.println("In General Mode");
    }
}
class Vibrate implements State{

    @Override
    public void ring() {
        System.out.println("In Vibration");
    }
}

class RingStateContext{
    private State currState;

    public RingStateContext() {
        this.currState = new Sound();
    }

    public void setCurrState(State currState) {
        this.currState = currState;
    }
    public void ring(){
        this.currState.ring();
    }
}

