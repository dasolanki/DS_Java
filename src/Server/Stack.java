package Server;

//import Client.Client;
/**
 *
 * @author sniper
 */
public class Stack {

    private static String[] str = new String[10];
    private static String n;
    private static int i = 0;


    public String push(String st) {
        n = st;
        if (i >= 0 ) {
            str[i] = n;
            i++;
            return str[i];
        }else{
            return "0";
        }
       
    }

    public String pop(String st) {
        n = st;
        if (i >= 0 && i < 10) {
            str[i] = null;
            i--;
            return n;
        } else {
            return "0";
        }
    }

    public String print(int i) {

        return str[i];
    }

    public int geti() {
        return i;
    }
}
