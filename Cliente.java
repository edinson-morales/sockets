import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
    public Cliente() throws IOException {
        super("cliente");
        
    }

    public void startClient() {
        try {
            // Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            // Se enviarán dos mensajes
            //for (int i = 0; i < 2; i++) {
                // Se escribe en el servidor usando su flujo de datos
                //salidaServidor.writeUTF("Este es el mensaje número " + (i + 1) + "\n");
            //}

            //cs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBalanceAccount(Account account) throws IOException {
        //salidaServidor = new DataOutputStream(cs.getOutputStream());
        salidaServidor.writeUTF(String.format("%s:%d\n", account.getAccount(), account.getBalance()));
        //cs.close();
    }

    public String getBalanceAccount(String account) throws IOException {

        return "2000";
    }
}
