package client;

import model.Account;
import worker.AccountHolder;

public class MainClient {
    public static void main(String[] args) {
        Account account = new Account();
        AccountHolder accountHolder = new AccountHolder(account);
        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder);

        t1.setName("Priya");
        t2.setName("Priyanka");

        t1.start();
        t2.start();
    }
}
