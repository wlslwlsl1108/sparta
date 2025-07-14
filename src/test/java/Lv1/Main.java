package Lv1;

import java.util.Scanner;

public class Main {

    // main 메서드 = 프로그램 실행 시 가장 먼저 호출
    public static void main(String[] args) {

        // Scanner 객체 생성 //
        // 입력 받기 // => Scanner 사용하려면 import 구문 필요
        // 입력 받을 수 있게 해주는 Scanner 객체 생성
        // (System.in = 입력 스트림 = 프로그램이 데이터를 받아들이는 길)
        Scanner scanner = new Scanner(System.in);

        // 입력 시작 //
        // 입력 안내문구
        System.out.println("계산을 시작하겠습니다. 종료를 원하시면 'exit'를 입력하세요.");


        // while 로 크게 한번 더 묶기 (계산기 전체 루프)
        while (true) {
            // while 상단에 변수 선언 및 초기화
            int num1;
            int num2;
            char operator;
            int result = 0;

            while (true) {
                // 첫번 째 숫자 입력받기 (0포함 양의 정수) //
                System.out.print("첫 번째 숫자(0포함 양의 정수)를 입력하세요: ");

                // input => 한 줄 전체를 문자열로 받는다 (nextLine)
                String input = scanner.nextLine();

                // exit 입력 시 계산기 정상종료
                if (input.equalsIgnoreCase("exit")){
                    System.out.println("계산기를 종료합니다.");
                    //시스템 정상종료
                    System.exit(0);
                }

                try {
                    // exit 종료문 추가하면서 삭제 => num1 = scanner.nextInt();
                    // 입력 버퍼 비우기
                    // 입력 버퍼 안비우면 연산자로 넘어갔을 때 저장된 숫자로 인해 오류메세지 뜬다.
                    // exit 종료문 추가하면서 삭제 => scanner.nextLine();
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
                    // 예외 발생시에도 nextLine()으로 버퍼를 정리해줘야 했지만 구조가 바뀌면서 필요 없어짐
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

            // 음수 입력 시 경고 메세지 후 재입력 가능 //

            while (true) {
                // 두번 째 숫자 입력받기 (0포함 양의 정수) //
                System.out.print("두 번째 숫자(0포함 양의 정수)를 입력하세요: ");

                //input => 한 줄 전체를 문자열로 받는다. (nextLine)
                String input = scanner.nextLine();

                //exit 입력 시 계산기 정상 종료
                if (input.equalsIgnoreCase("exit")){
                    System.out.println("계산기를 종료합니다.");
                    System.exit(0);  // 시스템 정상 종료
                }

                try {

                    num2 = Integer.parseInt(input); // num1과 동일하게 추가

                    // 음수 입력 시 오류 메세지 출력 후, 재입력 가능
                    if (num2 < 0) {
                        System.out.println("음수는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                        continue;
                    }

                    // 분모 0 오류 메세지 출력 후, 재입력 가능
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;

                } catch (Exception e) {
                    System.out.println("문자는 입력할 수 없습니다. 0 포함한 숫자(양의 정수)만 입력해주세요.");
                    // 입력 버퍼 비우기 삭제 => 위에서 num2 정의를 바꿨으므로
                    // scanner.nextLine();
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