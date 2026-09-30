import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5000);
        System.out.println("¡Conectado al servidor! Escribe 'salir' para terminar.");

        
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner(socket.getInputStream());
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            System.out.print("> ");
            String mensaje = teclado.nextLine(); 
            
            salida.println(mensaje); 

            if (mensaje.equalsIgnoreCase("salir")) {
                System.out.println("Cerrando cliente");
                break;
            }

           
            System.out.println("Servidor responde: " + entrada.nextLine());
        }

        
        socket.close();
    }
}