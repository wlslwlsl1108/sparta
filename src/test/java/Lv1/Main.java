package Lv1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 입력 받기 => Scanner 사용하려면 import 구문 필요
        Scanner scanner = new Scanner(System.in);

        // 입력 시작
        System.out.println("계산을 시작하겠습니다.");


        int num1;

        // 첫번 째 숫자 입력받기 (0포함 양의 정수)

        while (true) {
            System.out.print("첫 번째 숫자(0포함 양의 정수)를 입력하세요: ");
            num1 = scanner.nextInt();

            if (num1 >= 0){
                break;
            } else {
                System.out.println("잘못입력하였습니다. 0을 포함한 숫자(양의 정수)만 입력하세요.");
            }

        }

        int num2;

        // 두번 째 숫자 입력받기 (0포함 양의 정수)

        while (true) {
            System.out.print("두 번째 숫자(0포함 양의 정수)를 입력하세요: ");
            num2 = scanner.nextInt();

            if (num2 >= 0){
                break;
            } else {
                System.out.println("잘못입력하였습니다. 0을 포함한 숫자(양의 정수)만 입력하세요.");
            }

        }


        // 연산자 입력받기
        System.out.print("연산자( +, -, *, /)를 입력하세요: ");
        char operator = scanner.next().charAt(0);

        int result = 0;

        switch (operator){
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0){
                    System.out.println("분모에는 0이 올 수 없습니다.");
                }else {
                    result = num1 / num2;
                    break;
                }
        }
        System.out.println("결과는: " + result);
    }

}
