package Q2;

public class Book {
    // 필드 (속성)
    String title;
    String author;
    int price;

    // 생성자
    public Book(/* TODO: 올바른 매개변수를 선언하세요 */String title, String author, int price) {
        // TODO: 매개변수로 받은 값들을 사용해 클래스의 필드를 초기화하세요.
        // 'this' 키워드를 사용해야 합니다.
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 메서드
    public void printInfo() {
        // TODO: "제목: [title], 저자: [author], 가격: [price]원" 형식으로 출력하세요.
        System.out.println("제목: [" + title + "], 저자: [" + author + "], 가격: [" + price + "]원");
    }

    public static void main(String[] args) {
        // TODO: 여기에 Book 객체를 생성하고 printInfo() 메서드를 호출하는 코드를 작성하세요.
        // 예: Book myBook = new Book("자바의 정석", "남궁성", 30000);
        Book myBook = new Book("자바의 정석", "남궁성", 30000);
        myBook.printInfo();
    }
}