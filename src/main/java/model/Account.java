package model;

public class Account {

    // in real scenario this will be queried from database
    private int totalBalance = 10000;

    public int getTotalBalance() {
        return totalBalance;
    }

    public void withdraw(int amount) {
        totalBalance = totalBalance - amount;
    }
}
