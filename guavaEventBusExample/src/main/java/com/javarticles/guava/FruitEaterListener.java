package com.javarticles.guava;
 
import com.google.common.eventbus.Subscribe;
 
public class FruitEaterListener {
    @Subscribe
    public void eat(Fruit fruit)  {
        System.out.println("eat(Fruit " + fruit +")");
    }  
     
    @Subscribe
    public void eat(Apple apple) {
        System.out.println("eat(" + apple +")");
    } 
}