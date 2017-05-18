package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author : thomas
 * @version : 09/05/17
 */
public class ClientSession implements Runnable {


    private PrintWriter out = null;
    private BufferedReader in = null;

    public ClientSession(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(in.readLine());

            while(true){
                String request = scanner.nextLine();
                out.println(request);
                out.flush();
                String line;
                while ( (line = in.readLine())!=null){
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
