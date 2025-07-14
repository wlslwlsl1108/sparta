package Lv1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 입력 받기 // => Scanner 사용하려면 import 구문 필요
        Scanner scanner = new Scanner(System.in);

        // 입력 시작 //
        System.out.println("계산을 시작하겠습니다.");

        int num1;

        // 첫번 째 숫자 입력받기 (0포함 양의 정수) //
        // 음수 입력 시 경고 메세지 후 재입력 가능 //

        while (true) {

            try {
                System.out.print("첫 번째 숫자(0포함 양의 정수)를 입력하세요: ");
                num1 = scanner.nextInt();

                if (num1 < 0) {
                    System.out.println("x! 음수는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                    continue;
                }
                break;
            }
            catch ( Exception e) {
                System.out.println("문자는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                // 입력 버퍼 비우기
                scanner.nextLine();
            }

        }

        int num2;

        // 두번 째 숫자 입력받기 (0포함 양의 정수) //
        // 음수 입력 시 경고 메세지 후 재입력 가능 //

        while (true) {

            try {
                System.out.print("두 번째 숫자(0포함 양의 정수)를 입력하세요: ");
                num2 = scanner.nextInt();

                if (num2 < 0) {
                    System.out.println("x! 음수는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                    continue;
                }
                break;
            }
            catch ( Exception e) {
                System.out.println("문자는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                // 입력 버퍼 비우기
                scanner.nextLine();
            }

        }


        while (true) {

            // 연산자 입력받기 //
            System.out.print("연산자( +, -, *, /)를 입력하세요: ");

            // 사칙연산 기호 chaAt(0) 변수에 저장 //
            char operator = scanner.next().charAt(0);

            int result = 0;

            if (operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                System.out.println("x!! 잘못된 연산자입니다. 다시 연산자( +, -, * / )를 입력해주세요.");
                continue;
            }else {
                break;
            }

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

                // 나눗셈 경우, 분모에 0이 오면 경고 메세지 후, 재입력 가능 //
                case '/':
                    if (num2 == 0){
                        System.out.println("분모에는 0이 올 수 없습니다.");
                        continue;
                    }else {
                        result = num1 / num2;
                        break;
                    }
            }
            // 계산 결과 출력 //
            System.out.println("결과는: " + result);
            break;
        }

    }

}
