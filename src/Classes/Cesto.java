package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class Cesto extends Thread {
    private PipedReader receptor = null;
    private BufferedReader flujoE = null;

    public Cesto(PipedReader re) {
        receptor = re;
        flujoE = new BufferedReader(receptor);
    }

    public void run() {
        while (true) {
            obtenerManzanas();
        }
    }

    private synchronized void obtenerManzanas() {
        String mensaje = null;

        try {
            mensaje = flujoE.readLine();
            if(mensaje != null){
                System.out.println("En el cesto hay: " + mensaje +" manzanas");
            }
           
        } catch (IOException ioException) {
        }
    }
    protected void finalize() throws IOException {
        if (flujoE != null) {
            flujoE.close();
            flujoE = null;
        }
        if (receptor != null) {
            receptor.close();
            receptor = null;
        }
    }
}
