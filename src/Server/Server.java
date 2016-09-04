
/*Stack using GUI using normal OOP and keeping stack as seperate file in Server
*/
package Server;

import Client.Client;
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {
        System.out.println("Server Signing ON");
        ServerSocket ss = new ServerSocket(9081);
        Socket soc = ss.accept();
        System.out.println("Server says Connection Established");
        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );
        Client c1=new Client();
        Thread t=new Thread(c1);
        t.start();
        System.out.println("Connection terminated");

    }

}
