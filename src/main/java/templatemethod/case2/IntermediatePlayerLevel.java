package templatemethod.case2;

public class IntermediatePlayerLevel extends PlayerLevel {
    @Override
    protected void walk() {
        System.out.println("인터미디엇은 걷는다.");
    }

    @Override
    protected void run() {
        System.out.println("인터미디엇은 천천히 뛴다.");
    }

    @Override
    protected void jump() {
        System.out.println("인터미디엇은 점프하지 못한다.");
    }

    @Override
    protected void showLevelInfo() {
        System.out.println("나의 레벨은 인터미디엇이다.");
    }
}
