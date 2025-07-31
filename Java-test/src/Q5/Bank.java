package Q5;

import java.util.List;
import java.util.ArrayList;

public class Bank {
    List<Account> accounts = new ArrayList<>();

    public Account findAccount(String accountNumber) {
        // TODO: 반복문을 사용하여 accounts 리스트에서
        // 매개변수로 받은 accountNumber와 일치하는 Account 객체를 찾아 반환하세요.
        // 만약 일치하는 계좌가 없다면 null을 반환하세요.
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

        /* 1. List<Account> accounts = new ArrayList<>();  ->" accounts 리스트 초기화 "
             - Account 클래서 생성 후 자료형으로 사용 가능 (제네릭 타입)
             - List<Account> : accounts 리스트에는 Account 객체만 저장 가능
             - new ArrayList<>() : 실제로 ArrayList 객체를 만들어 메모리에 올림 -> 초기화
             1) 객체 생성   new ArrayList<>()
             2) 변수 선언   List<Account> accounts
             3) 객체 참조값을 변수에 저장   new ArrayList<>()

           2. for (Account account : accounts)
             - List(accounts)에 담긴 Account 타입의 객체를 하나씩 account 변수에 담는다

           3. if (account.accountNumber.equals(accountNumber))
             - account 변수에 담긴 accountNumber를
               findAccount 에서 받은 accountNumber와 비교한다.
         */
