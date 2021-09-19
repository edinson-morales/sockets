public class Account {

    private String account;
    private long balance;

    private Account() {
    }

    public Account(String account, long balance) {
        this.account = account;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public long getBalance() {
        return balance;
    }
}