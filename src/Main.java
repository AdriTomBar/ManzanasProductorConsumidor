import java.io.*;


import Classes.*;


public class Main {
    public static void main(String[] args) {
        
        try {
            PipedWriter emisor = new PipedWriter();
            PipedReader receptor = new PipedReader(emisor);

            Jardinero j = new Jardinero(emisor);
            Cesto c = new Cesto(receptor);

            j.start();
            c.start();

        } catch (IOException e) {
            
        }
    }
}
