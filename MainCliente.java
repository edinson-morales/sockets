import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainCliente {
    private static final String[] CONTINUE = new String[] { "yes", "y" };
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Cliente client;

    public static void main(String[] args) throws IOException {
        // client = new Cliente();

        System.out.println("Welcome to Poli Bank");

        String next = "y";
        while (Arrays.asList(CONTINUE).contains(next.toLowerCase())) {
            System.out.println("Please, select one option");
            System.out.println("1. Add Balances to yours accounts. ");
            System.out.println("2. Get Balances from your accounts.");
            next = reader.readLine();
            
            if ("1".equals(next))
                addBalances();
            if ("2".equals(next))
                getBalances();

            System.out.println("Press yes/y to continue, other key to leave");
            next = reader.readLine();
        }

        // cli.startClient(); //Se inicia el cliente
    }

    private static void addBalances() throws IOException {
        String next = "y";
        while (Arrays.asList(CONTINUE).contains(next.toLowerCase())) {

            System.out.println("Please, write your account");
            String account = reader.readLine();
            System.out.println("Write a balance value, numbers only");
            long balance = Long.parseLong(reader.readLine());

            String result = "OK";
            try {
                // client.updateBalanceAccount(new Account(account, balance));
            } catch (Exception e) {
                result = "NO_OK";
            }
            System.out.println(result);

            System.out.println("Press yes/y to continue, other key to leave");
            next = reader.readLine();
        }
    }

    private static void getBalances() throws IOException {
        String next = "y";
        while (Arrays.asList(CONTINUE).contains(next.toLowerCase())) {
            System.out.println("Please, write your account");
            String account = reader.readLine();

            String result = "OK";
            try {
                // client.updateBalanceAccount(new Account(account, balance));
            } catch (Exception e) {
                result = "NO_OK";
            }
            System.out.println(result);

            System.out.println("Press yes/y to continue, other key to leave");
            next = reader.readLine();
        }
    }
}