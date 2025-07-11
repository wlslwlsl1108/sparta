package lv2;

public class Calculator {
 int calculate(int num1, int num2, char operator){

     int result = 0;


     switch (operator){

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
             result = num1 / num2;
             break;

     }

     return result;
 }

}
