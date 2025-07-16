package Tt;

import java.util.ArrayList;

public class Ab

{
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public int ab(int num1, int num2, char operator){

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
                result = num1 / num2;
                break;
        }
        arrayList.add(result);
        return result;
    }

    //게터
    public ArrayList<Integer> getArrayList(){
        return arrayList;
    }

    //세터
    public void setArrayList(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    public void removeResult(){
        if (!arrayList.isEmpty()){
            arrayList.remove(0);
        }
    }
}

