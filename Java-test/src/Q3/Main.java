package Q3;

public class Main {
    public static void main(String[] args) {
        // TODO: 하위(자식) 클래스인 Circle과 Rectangle의 인스턴스를 상위(부모) 클래스인 Shape 타입의 참조 변수로 참조할 수 있도록 수정해주세요.
        Circle circle = new Circle(10);       // 반지름 10
        Rectangle rectangle = new Rectangle(5, 8); // 가로 5, 세로 8

        System.out.println("원의 넓이: " + circle.getArea()); // 예상 결과: 314.0
        System.out.println("사각형의 넓이: " + rectangle.getArea()); // 예상 결과: 40.0
    }
}