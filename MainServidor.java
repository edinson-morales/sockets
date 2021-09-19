import java.io.IOException;

public class MainServidor {

    public static void main(String[] args) throws IOException {
        Servidor serv = new Servidor();
        serv.startServer();

        System.out.println("Iniciando servidor\n");
    }
}