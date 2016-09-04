/*
 planning to use vector to learn it
 */
package Server;

import java.awt.event.*;

import java.io.*;
import java.util.Vector;

/**
 *
 * @author sniper
 */
public class Queue {

    private static Vector v = new Vector(10, 1);

    public void push(String str) {
        v.addElement(str);
    }

    public void pop(String str) {
        v.remove(0);
    }
    
    public Vector getv(){
        return v;
    }
}
