package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사용자 입력도구 생성
        Scanner scanner = new Scanner(System.in);

        // 반복실행- 계산시작
        while (true) {
            System.out.println("계산을 시작합니다. 종료를 원하시면 exit 입력해주세요.");

            // 첫번째 숫자 입력받기 - exit 입력 가능하도록 String 으로 변경
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String input1 = scanner.next();
            //exit 입력했을 경우
            if (input1.equalsIgnoreCase("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }

            // 첫번째 숫자 음수 입력시 경고
            int n1 = Integer.parseInt(input1);
            if (n1 < 0) {
                System.out.println("0을 포함한 양의 정수를 입력해주세요!");
                continue; // return 안해주면 그냥 두번째 숫자 입력받기로 넘어감
            }

            // 두번째 숫자 입력받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = scanner.nextInt();

            if (n2 < 0) {
                System.out.println("0을 포함한 양의 정수를 입력해주세요!");
                return;
            }


            // 사칙연산 //
            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            // 문자열로 입력받은 값에서 첫 글자만 꺼내서 char 타입으로 저장


            // 계산 //
            int result = 0;
            boolean val = true;

            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;

                case '-':
                    result = n1 - n2;
                    break;

                case '*':
                    result = n1 * n2;
                    break;

                case '/':
                    if (n2 == 0) {
                        System.out.println("x!! 나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        val = false;
                    } else {
                        result = n1 / n2;
                    }
                    break;

                default:
                    System.out.println("잘못입력하였습니다! 연산자(+, -, *, /)를 입력해주세요. ");

            }
            if (val)
                System.out.println("결과: " + result);

        }
    }
}
