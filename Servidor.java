import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(5000);
    

        
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado");

      
        Scanner entrada = new Scanner(cliente.getInputStream());
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

    
        while (entrada.hasNextLine()) {
            String mensaje = entrada.nextLine();
            System.out.println("Cliente : " + mensaje);

            if (mensaje.equalsIgnoreCase("salir")) {
                System.out.println("Conexión finalizada.");
                break;
            }

            salida.println("Mensaje recibido: " + mensaje);
        }

   
        cliente.close();
        servidor.close();
    }
}