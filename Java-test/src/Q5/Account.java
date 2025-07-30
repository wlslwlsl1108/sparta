package Q5;

public class Account {
    String accountNumber;
    int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        // TODO: 현재 잔액(balance)에 입금액(amount)을 더하세요.
    }

    public void withdraw(int amount) {
        // TODO: 출금액이 잔액보다 작거나 같을 경우에만 잔액에서 출금액을 빼세요.
    }
}
