package Lv1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 입력 받기 // => Scanner 사용하려면 import 구문 필요
        Scanner scanner = new Scanner(System.in);

        // 입력 시작 //
        System.out.println("계산을 시작하겠습니다.");


        // while 로 크게 한번 더 묶기
        while (true) {
            // while 상단에 변수 정리
            int num1;
            int num2;
            char operator;
            int result = 0;

            while (true) {
                // 첫번 째 숫자 입력받기 (0포함 양의 정수) //
                System.out.print("첫 번째 숫자(0포함 양의 정수)를 입력하세요: ");
                String input = scanner.nextLine();

                // exit 입력 시 계산기 정상종료
                if (input.equalsIgnoreCase("exit")){
                    System.out.println("계산기를 종료합니다.");
                    //시스템 정상종료
                    System.exit(0);
                }

                try {
                    // exit 종료문 추가하면서 수정 필요 num1 = scanner.nextInt();
                    // 입력 버퍼 비우기
                    // 입력 버퍼 안비우면 연산자로 넘어갔을 때 저장된 숫자로 인해 오류메세지 뜬다.
                    // exit 종료문 추가하면서 수정 필요 scanner.nextLine();
                    num1 = Integer.parseInt(input); //수정완료

                    // 음수 입력 시 오류 메시지 후 재입력
                    if (num1 < 0) {
                        System.out.println("음수는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                        continue;
                    }
                    break;

                } catch (Exception e) {
                    System.out.println("문자는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                    // 입력 버퍼 비우기
                    // 입력 버퍼 안비우면 무한루프 생성됨
                    // scanner.nextLine(); =>종료문 추가하면서 삭제
                }

            }

            while (true) {
                // 연산자 입력받기 //
                System.out.print("연산자( +, -, *, /)를 입력하세요: ");

                // input 정의//
                // 연산자 길이 체크를 위해 필요 (연산자 반복입력 오류 해결)
                String input = scanner.nextLine();


                // 연산자 길이 체크 //
                if (input.length() != 1) {
                    System.out.println("잘못입력하였습니다! 연산자( +, -, *, /)를 한 글자만 입력하세요. ");
                    continue;
                }

                // 사칙연산 기호 chaAt(0) 변수에 저장 //
                // char operator = scanner.next().charAt(0);
                operator = input.charAt(0);

                // while 문 삭제
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("x!! 잘못된 연산자입니다. 다시 연산자( +, -, * / )를 입력해주세요.");
                    continue;
                }

                break;

            }


            // 두번 째 숫자 입력받기 (0포함 양의 정수) //
            // 음수 입력 시 경고 메세지 후 재입력 가능 //

            while (true) {

                try {
                    System.out.print("두 번째 숫자(0포함 양의 정수)를 입력하세요: ");
                    num2 = scanner.nextInt();

                    if (num2 < 0) {
                        System.out.println("음수는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                        continue;
                    }

                    // 분모 0 오류 추가
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("문자는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                    // 입력 버퍼 비우기
                    scanner.nextLine();
                }

            }

            switch (operator) {

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
                    result = num1 / num2;
                    break;

            }
            // 계산 결과 출력 //
            System.out.println("결과는: " + result);
            continue;

        }
    }
}