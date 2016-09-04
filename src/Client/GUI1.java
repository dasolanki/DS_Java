/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.Queue;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Server.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;

/**
 *
 * @author sniper
 */
public class GUI1 extends Client implements Runnable{

    void GUI(PrintWriter nos) {
        Client c1 = new Client();
        System.out.println("ch in GUI main is " + c1.getCh());
        JFrame f1 = new JFrame("GUI Client for Stack");
        JButton push = new JButton("push");
        JButton pop = new JButton("pop");
        JButton print = new JButton("print");
        JTextArea ta = new JTextArea(30, 40);
        JTextField tf = new JTextField(40);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JScrollPane jp = new JScrollPane(ta);
        jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(jp);
        p1.add(tf);
        p2.add(push);
        p2.add(pop);
        p2.add(print);
        f1.add(p1);
        f1.add(p2, BorderLayout.SOUTH);
        f1.setSize(600, 600);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        push psh = new push(tf, ta, nos);
        pop poop = new pop(tf, ta, nos);
        print prnt = new print(ta);
        push.addActionListener(psh);
        tf.addActionListener(psh);
        pop.addActionListener(poop);
        tf.addActionListener(poop);
        print.addActionListener(prnt);
        tf.addActionListener(prnt);
        ta.setEditable(false);


    }

    @Override
    public void run() {

        GUI(nos);
    }

}

class push implements ActionListener {

    JTextField tf;
    PrintWriter nos;
    JTextArea ta;

    push(JTextField tf, JTextArea ta, PrintWriter nos) {
        this.tf = tf;
        this.ta = ta;
        this.nos = nos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client c1 = new Client();
        if (c1.getCh() == 1) {
            String str = tf.getText();
            Stack stk = new Stack();
            if (str.equals("End")) {
                System.exit(1);
            }
            tf.setText("");
            if (stk.geti() >= 0 && stk.geti() < 10) {
                ta.append("\nString " + str + " has been added in stack");
                stk.push(str);
            } else {
                ta.append("\nOverflow Occured");
            }
        } else if (c1.getCh() == 2) {
            Queue que = new Queue();
            String str = tf.getText();
            if (str.equals("End") || str.equals("end")) {
                System.exit(1);
            } else {
                que.push(str);
                ta.append("\nString " + str + " has been added to the queue");
                tf.setText("");
            }
        }
    }
}

class pop implements ActionListener {

    JTextField tf;
    PrintWriter nos;
    JTextArea ta;

    pop(JTextField tf, JTextArea ta, PrintWriter nos) {
        this.tf = tf;
        this.ta = ta;
        this.nos = nos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client c1 = new Client();
        if (c1.getCh() == 1) {
            String str = tf.getText();
            Stack stk = new Stack();
            if (stk.geti() >= 0 && stk.geti() < 10) {
                ta.append("\nFirst Element has been removed from stack");
                stk.pop(str);
            } else {
                ta.append("\nUnderflow Occured");
            }
            tf.setText("");
        } else if (c1.getCh() == 2) {
            Queue que = new Queue();
            String str = tf.getText();
            if (que.getv().isEmpty()) {
                ta.append("\nThere are no elements to remove");
            } else {
                que.pop(str);
                ta.append("\nFirst element has been removed from the queue");
                tf.setText("");
            }

        }
    }

}

class print implements ActionListener {

    JTextArea ta;

    print(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client c1 = new Client();
        if (c1.getCh() == 1) {
            ta.append("\nString has:");
            Stack stk = new Stack();
            for (int i = 0; i < stk.geti(); i++) {
                ta.append("\n" + stk.print(i));
            }
        } else if (c1.getCh() == 2) {
            Queue que = new Queue();
            Enumeration ven = que.getv().elements();
            if (que.getv().isEmpty()) {
                ta.append("\nThere are no elements to print");
            } else {
                for (int i = 0; i < que.getv().size(); i++) {
                    ta.append("\n" + ven.nextElement());
                }
            }
        }
    }
}
