package lambdasinaction.chap3;

/**
 * 함수형 인터페이스란 추상메서드가 오직 하나만 있는 인터페이스를 말한다.
 * ex) Runnable
 * */
public class 함수형인터페이스 {
    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("Hello World 1"); // 람다 사용

        Runnable r2 = new Runnable() { // 익명클래스사용
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };

        process(r1);
        process(r2);
        process(()-> System.out.println("Hello World3")); /** 함수형 인터페이스 + 람다식의 사용법*/
    }

    public static void process(Runnable r){
        r.run();
    }
}
