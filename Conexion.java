import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

<<<<<<< HEAD
public class Conexion
{
    private final int PUERTO = 1234; //Puerto para la conexión
    private final String HOST = "172.26.0.4"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
=======
public class Conexion {
    private final int PUERTO = 1234;
    private final String HOST = "192.168.56.1";
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor, salidaCliente;
>>>>>>> 34710fcaa8d09e405a05de0b7dc1bebb371f16fd

    public Conexion(String tipo) throws IOException // Constructor
    {
        if (tipo.equalsIgnoreCase("servidor")) {
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
        } else {
            cs = new Socket(HOST, PUERTO);
        }
    }
}