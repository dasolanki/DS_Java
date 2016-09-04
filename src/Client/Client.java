/*Only Stack Works 
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class Client implements Runnable {

    private static int ch;
    PrintWriter nos;
    Socket soc;
    public static void main(String[] args) throws Exception {
        Socket soc = new Socket("127.0.0.1", 9081);
        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ), true
        );
        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                ));
        JFrame jf = new JFrame("Choose One of the options");
        JButton stak = new JButton("Stack");
        JButton que = new JButton("Queue");
        JButton LL = new JButton("Linked list");
        JPanel p1 = new JPanel();
        p1.add(stak);
        p1.add(que);
        p1.add(LL);
        jf.add(p1, BorderLayout.CENTER);
        jf.setSize(420, 220);
        jf.setVisible(true);

        stak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch = 1;
                GUI1 gui = new GUI1();
                Thread t = new Thread(gui);
                t.start();
            }
        });
        que.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch = 2;
                GUI1 gui = new GUI1();
                Thread t = new Thread(gui);
                t.start();

            }
        });
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        System.out.println("Run has nothing to do");
    }

}
