package lv2;

import java.util.Scanner;

//ArrayList 게터 설정을 위해 필요
import java.util.ArrayList;

public class App {

    // 입력 받아 양의 정수 확인  -> 아니면 재입력 받음 (매서드 추가)
    // 반복기능 메서드로 정리 (중복 제거위해)
    public static int getPositiveInteger(Scanner scanner, String message, Calculator calculator) {
        while (true) {

            // 메세지를 보여주고, 단어를 받아와 입력받는다 (저장 = String 타입)
            System.out.print(message);
            String input = scanner.next();
            // 문자열 입력받는 메서드
            // -> 문자열을 정수(int)로 바꾸려면 Integer.parseInt(input)과 같은 코드 필요

            // exit 입력했을 경우 계산기 정상 종료 //
            // => 모두 다 적용해야 할 중복 기능 위 메서드(getPositiveInteger)로 정의
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                System.exit(0);  // 프로그램 정상 종료
            }

            // 초기화(reset) 신호 //
            if (input.equalsIgnoreCase("reset")) {
                return -1;
            }

            // 데이터 삭제(delete) //
            if (input.equalsIgnoreCase("delete")) {
                calculator.removeResult();
                System.out.println("가장 오래된 결과가 삭제되었습니다.");
                continue;
            }

            // 숫자 외 입력 => 경고 알림메세지 후 재입력 가능(continue) //
            if (!input.matches("\\d+")) {  // 1개이상 연속되는 숫자만! (문자 포함시 false)
                System.out.println("0을 포함한 숫자(양의 정수)만 입력해주세요!");
                continue;
            }

            // 문자열을 숫자(정수형)으로 형변환 //
            // 우리가 입력하는 값은 모두 문자열! => 계산하려면 숫자(정수형)으로 형변환 필요!
            int num = Integer.parseInt(input);

            // 음수 입력 => 경고 알림메세지 후 재입력 가능(continue) //
            if (num < 0) {
                System.out.println("0을 포함한 숫자(양의 정수)만 입력해주세요!");
                continue;

            }

            return num;

        }
    }


    public static void main(String[] args) {
        // 사용자 입력도구 생성 //
        Scanner scanner = new Scanner(System.in);

        // Calculator 클래스의 생성자 호출 => 객체 생성 //
        // main 밖에 넣으면 오류 발생
        Calculator calculator = new Calculator();

        // 계산 시작 안내문구 -> 시작할 때 한번만 사용 //
        System.out.println("계산을 시작합니다. 종료를 원하시면 exit, 초기화를 원하시면 reset을 입력해주세요.");

        // reset 입력 시 첫번째 숫자 입력으로 돌아가기 //
        // while로 전체 감싸고, continue outerLoop 활용
        outerLoop:
        while (true) {

            // 반복실행- 계산시작
            while (true) {

                // n1, n2 숫자 입력 + 연산자 입력  => 한꺼번에 정리 //

                // 메세지를 보여주고, 입력값을 받아 양의 정수인지 확인 후 => getPositiveInteger(메서드)가 역할
                // 확인되면 그 값은 n1 에 저장
                int num1 = getPositiveInteger(scanner, "첫 번째 숫자를 입력하세요: ", calculator);

                // n1 초기화 //
                if (num1 == -1) {
                    System.out.println("초기화합니다.");
                    continue outerLoop;
                }

                char operator;  // operator 변수 선언

                while (true) {


                    System.out.print("연산자를 입력하세요 ( +, -, *, / ): ");

                    // 사용자가 입력한 문자열(공백 이전 한단어)을 string 타입으로 읽어 opInput(변수)에 저장
                    String opInput = scanner.next();

                    // exit 기능 => 정상종료 //
                    if (opInput.equalsIgnoreCase("exit")) {
                        System.out.println("계산기를 종료합니다.");
                        System.exit(0);
                    }

                    // 연산자 초기화 //
                    if (opInput.equalsIgnoreCase("reset")) {
                        System.out.println("초기화합니다.");
                        continue outerLoop;
                    }

                    // 연산자 길이 체크 //
                    // => 사칙연산 반복해서 입력 시 강제종료 오류 해결
                    if (opInput.length() != 1) {
                        System.out.println("잘못입력하였습니다! 연산자( +, -, *, / )를 입력해주세요. ");
                        continue;
                    }

                    // .charAt(0) -> 문자열에서 첫 글자(연산자 중 하나)를 꺼내 operator에 저장
                    // 위에서 변수 선언 했으므로 앞에 변수형 삭제
                    operator = opInput.charAt(0);

                    // 연산자 유효성 //
                    // => **이런식으로 연산자 반복 입력 시에도 경고 알림메시지 뜸
                    if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                        break;
                    } else {
                        System.out.println("잘못입력하였습니다! 연산자( +, -, *, / )를 입력해주세요. ");
                    }
                }


                int num2;
                // [ / + 0 ] 입력 시, 경고 알림메세지 후 다시 두번째 문자 재입력 //
                while (true) {
                    num2 = getPositiveInteger(scanner, "두 번째 숫자를 입력하세요: ",  calculator);

                    // n2 초기화 //
                    if (num2 == -1) {
                        System.out.println("초기화합니다.");
                        continue outerLoop;
                    }

                    // 나눗셈(/) 할 때 분모에 0 => 경고 알림메세지 후 다시 두번째 문자 재입력 //
                    if (operator == '/' && num2 == 0) {
                        System.out.println("x!! 나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    } else {
                        break; // 올바른 값 입력 시 반복 종료!
                    }

                }


                //게터 => 위 calculator를 정의하고 나서 생성해야함
                ArrayList<Integer> arrayList = calculator.getArrayList();


                //세터
                calculator.setArrayList(arrayList);
                ArrayList<Integer> arrayList2 = calculator.getArrayList();


                // 메서드 호출 //
               int result = calculator.calculator(num1, num2, operator);

                // 결과 출력 //
                System.out.println("결과: " + result);
                System.out.println("저장된 결과 목록: " + calculator.getArrayList());
            }
        }
    }
}