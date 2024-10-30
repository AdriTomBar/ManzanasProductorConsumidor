package Classes;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class Jardinero extends Thread {

    private PipedWriter emisor = null;
    private PrintWriter flujoS = null;

    public Jardinero(PipedWriter emisor) {
        this.emisor = emisor;
        flujoS = new PrintWriter(emisor);
    }

    public void run() {
        while (true) {
            almacenarManzana();
            try {
                int espera = 500;
                sleep(espera);
            } catch (InterruptedException Ie) {
                Ie.printStackTrace();
            }
        }
    }

    private synchronized void almacenarManzana() {
        int numManzanas;
        String texto;

        numManzanas = (int) (Math.random() * 10+1);

        texto =  numManzanas + " manzanas";
        
        flujoS.
        flujoS.println(texto);
        
    }

    protected void finalize() throws IOException {
        if (flujoS != null) {
            flujoS.close();
            flujoS = null;
        }
        if (emisor != null) {
            emisor.close();
            emisor = null;
        }
    }

}
