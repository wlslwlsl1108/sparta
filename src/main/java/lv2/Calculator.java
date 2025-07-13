package lv2;

import java.util.ArrayList;

// 연산 결과 저장하는 컬렉션 타입을 가진 Calculator 클래스 생성 //
public class Calculator {


    // 연산 결과 저장 // - 컬렉션
    //  => private = App 클래스에서 직접 접근 불가
    private ArrayList<Integer> arrayList = new ArrayList<Integer>(); //자바에서 제공해주는 클래스 (new 뒤에)
    // 변수의 자료형위치(클래스이름 일치) -> < > = 제네릭
    // 자바에서 제공해주는 클래스인 ArrayList를 인스턴스화 시켜서 arrayList 라는 변수에 넣어줌


    // 사칙연산 수행 후 연산처리결과값 반환하는 메서드 //
    public int calculator(int num1, int num2, char operator) {

        int result = 0;


        switch (operator) {

            case ('+'):
                result = num1 + num2;
                break;

            case ('-'):
                result = num1 - num2;
                break;

            case ('*'):
                result = num1 * num2;
                break;

            case ('/'):
                if (num2 == 0) {
                    System.out.println("분모에 0이 올 수 없습니다. 다른 숫자를 입력해주세요.");
                } else {
                    result = num1 / num2;
                }

                break;

        }

        arrayList.add(result);
        return result;

    }

    //게터//
    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    //세터//
    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    // 삭제 메서드 //
    public void removeResult() {
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
    }
}
