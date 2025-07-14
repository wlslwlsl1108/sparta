package Lv2;

import java.util.ArrayList;

// 연산 결과를 저장하는 컬렉션 타입 필드 가진 Calculator 클래스 생성 //
public class Calculator {

    // 컬렉션 타입 필드 //
    // 캡슐화 -> private 로 변경 //
    // private 로 변경 하면 접근 못해서 오류발생 -> 게터/세터 필요
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

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

        // 연산 결과 저장 //
        arrayList.add(result);
        return result;
    }

    //게터//
    public ArrayList<Integer> getArrayList(){
        return arrayList;
    }


}
