import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Servidor extends Conexion // Se hereda de conexión para hacer uso de los sockets y demás
{
    private static String balancesFileName = "balances.txt";

    public Servidor() throws IOException {
        super("servidor");
    } // Se usa el constructor para servidor de Conexion

    public void startServer()// Método para iniciar el servidor
    {
        try {
            System.out.println("Esperando..."); // Esperando conexión

            cs = ss.accept(); // Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            // Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            // Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

            // Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            while ((mensajeServidor = entrada.readLine()) != null) // Mientras haya mensajes desde el cliente
            {
                // Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);

                createAccountsRepository();

                setBalances("aaaaa", 332323);
                System.out.println("Successfully wrote to the file.");
    
                System.out.println(String.format("Your total balance is %d", getBalances("aaaa")));                
            }

            System.out.println("Fin de la conexión");

            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createAccountsRepository() throws IOException {
        File balances = new File(balancesFileName);
        if (balances.createNewFile()) {
            System.out.println("Accounts repository created: " + balances.getName());
        }
    }

    public static void setBalances(String account, long balance) throws IOException {
        FileWriter fileWriter = new FileWriter(balancesFileName, true);
        fileWriter.append(String.format("%s:%d", account, balance));
        fileWriter.write("\r\n");
        fileWriter.close();
    }

    public static long getBalances(String account) throws IOException {
        String line;
        long totalBalances = 0;

        BufferedReader bufferreader = new BufferedReader(new FileReader(balancesFileName));
        while ((line = bufferreader.readLine()) != null) {
            if (account.equalsIgnoreCase(line.split(":")[0])) {
                totalBalances += Long.parseLong(line.split(":")[1]);
            }
        }
        bufferreader.close();

        return totalBalances;
    }
}