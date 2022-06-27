package study;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello java");
        String status = "good";
        switch (status){
            case "good"-> System.out.println("good");
            case "bad"-> System.out.println("bad");
        }

        NewPoint newPoint = new NewPoint(2,3);
        System.out.println("newPoint "+newPoint.x());

        OldPoint oldPoint = new OldPoint(2,3);

    }

    static class OldPoint {
        public final int x;
        public final int y;

        public OldPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    record NewPoint(int x, int y){

    }
}
