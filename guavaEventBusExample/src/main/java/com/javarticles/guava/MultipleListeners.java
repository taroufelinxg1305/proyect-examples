package com.javarticles.guava;
 
import com.google.common.eventbus.Subscribe;
 
public class MultipleListeners {
    @Subscribe
    public void task1(String s) {
        System.out.println("do task1(" + s +")");
    }
     
    @Subscribe
    public void task2(String s) {
        System.out.println("do task2(" + s +")");
    }
     
    @Subscribe
    public void intTask(Integer i) {
        System.out.println("do intTask(" + i +")");
    }
    
    @Subscribe 
    public void Tarea(String str)
    {
    	System.out.print("tarea: ");
    	if(str.equals("verdad"))
    	{
    		System.out.println("Es verdad");
    	}
    	else if (str.equals("mentira")) System.out.println("Es mentira");
    	System.out.println("");
    }
}