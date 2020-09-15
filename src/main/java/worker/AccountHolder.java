package worker;

import model.Account;

public class AccountHolder implements Runnable {
    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawMoney(3000);
            if (account.getTotalBalance() < 0)
                System.out.println("Account does not have sufficient money");
        }
    }

    private synchronized void withdrawMoney(int amount) {
        if (account.getTotalBalance() >= amount) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " finished withdrawal of amount + " + amount);
        } else {
            System.out.println("There is no sufficient amount of money available for " + Thread.currentThread().getName() + " to withdraw. The available amount is " + account.getTotalBalance());
        }
    }
}
