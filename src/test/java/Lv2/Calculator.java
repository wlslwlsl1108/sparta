package Lv2;

public class Calculator {

    // 사칙연산 수행 후 연산처리결과값 반환하는 메서드 //
    public int calculate(int num1, int num2, char operator){

        int result = 0;

        switch (operator){

            case '+' :
                result = num1 + num2;
                break;

            case '-' :
                result = num1 - num2;
                break;

            case '*' :
                result = num1 * num2;
                break;

            case '/' :
                result = num1 / num2;
                break;
        }
        return result;
    }
}
