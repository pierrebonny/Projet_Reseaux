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

    private boolean error = false;
    private Scanner scanner = null;

    private String request;

    public ClientSession(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {

        try {
            scanner = new Scanner(System.in);
            System.out.println(in.readLine());

            while(!error){
                request = scanner.nextLine();
                out.println(request);
                out.flush();
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
