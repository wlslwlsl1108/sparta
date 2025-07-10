package lv1;

import java.util.Scanner;

public class Main {

    // 입력 받아 양의 정수 확인  -> 아니면 재입력 받음 (매서드 추가)
    // 반복기능 메서드로 정리 (중복 제거위해)
    public static int getpositiveInteger(Scanner scanner, String message) {
        while (true) {

            // 메세지를 보여주고, 단어를 받아와 입력받는다 (저장 = String타입)
            System.out.print(message);
            String input = scanner.next();
                            // 문자열 입력받는 메서드 -> int로 바꾸려면 Interger.parseInt(input)과 같은 코드 필요

            // exit 입력했을 경우  => 모두 다 적용해야 할 중복 기능 위 메서드로 정의
            if(input.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                System.exit(0);  // 프로그램 정상 종료
            }

            // 숫자아니면 경고메세지 알림
            if (!input.matches("\\d+")) {  // 1개이상 연속되는 숫자만! (문자 포함시 false)
                System.out.println("0을 포함한 양의 숫자만 입력해주세요!");
                continue;
            }

            // 우리가 입력하는 값은 모두 문자열! => 계산하려면 숫자(정수형)으로 형변환 필요!
            int num = Integer.parseInt(input);

            // 음수 입력 => 경고메세지 알림
            if (num < 0 ){
                System.out.println("0을 포함한 양의 정수만 입력해주세요!");
                continue;

            }

            return num;

        }
    }


    public static void main(String[] args) {
        // 사용자 입력도구 생성
        Scanner scanner = new Scanner(System.in);

        // 계산 시작 안내문구 -> 시작할 때 한번만 사용
        System.out.println("계산을 시작합니다. 종료를 원하시면 exit 입력해주세요.");

        // 반복실행- 계산시작
        while (true) {

            // n1, n2 숫자 입력 + 연산자 입력  => 한꺼번에 정리 //

            // 메세지를 보여주고, 입력값을 받아 양의 정수인지 확인 후 = getpoInteger(메서드)가 역할
            // 확인되면 그 값은 n1 에 저장
            int n1 = getpositiveInteger(scanner, "첫 번째 숫자를 입력하세요: ");

            char operator;  // operator 변수 선언

            while (true) {

                System.out.println("연산자를 입력하세요 (+, -, *. /): ");

                // 사용자가 입력한 문자열(공백 이전 한단어)을 string 타입으로 읽어 opInput(변수)에 저장
                String opInput = scanner.next();

                // exit 기능 추가
                if (opInput.equalsIgnoreCase("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    System.exit(0);
                }

                // 연산자 길이 체크 => 사칙연산 반복해서 입력 시 강제종료 오류 해결
                if (opInput.length() != 1) {
                    System.out.println("연산자는 한 글자만 입력해주세요!");
                    continue;
                }

                // .charAt(0) -> 문자열에서 첫 글자(연산자 중 하나)를 꺼내 operator에 저장
                // 위에서 변수 선언 했으므로 앞에 변수형 삭제
                operator = opInput.charAt(0);

                // 연산자 유효성 추가 => **이런식으로 입력 시에도 경고메시지 떠야함
                if(operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("잘못입력하였습니다! 연산자(+, -, *, /)를 입력해주세요. ");
                }
            }


            int n2;
            // [ / + 0 ] 입력 시, 다시 두번째 문자 재입력 기능 추가
            while (true){
                n2 = getpositiveInteger(scanner, "두 번째 숫자를 입력하세요: ");

                if(operator == '/' && n2 == 0) {
                    System.out.println("x!! 나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }else {
                    break; // 올바른 값 입력 시 반복 종료!
                }

            }


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
                    result = n1 / n2;
                    break;

                // default  => 연산자 잘못돼도 출력될 수 있어서 수정 (val값 추가)
                default:
                    System.out.println("잘못입력하였습니다! 연산자(+, -, *, /)를 입력해주세요. ");
                    val = false;
            }

            System.out.println("결과: " + result);

        }
    }
}
