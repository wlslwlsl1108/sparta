package Q5;

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.accounts.add(new Account("111-222", 10000));
        bank.accounts.add(new Account("333-444", 50000));

        Account foundAccount = bank.findAccount("111-222");

        if (foundAccount != null) {
            foundAccount.deposit(5000);
            foundAccount.withdraw(3000);
            System.out.println("계좌 " + foundAccount.accountNumber + "의 최종 잔액: " + foundAccount.balance); // 예상 결과: 12000
        }
    }
}
