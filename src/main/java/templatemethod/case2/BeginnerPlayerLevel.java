package templatemethod.case2;

public class BeginnerPlayerLevel extends PlayerLevel {
    @Override
    protected void walk() {
        System.out.println("비기너는 걷는다.");
    }

    @Override
    protected void run() {
        System.out.println("비기너는 뛰지 못한다.");
    }

    @Override
    protected void jump() {
        System.out.println("비기너는 점프하지 못한다.");
    }

    @Override
    protected void showLevelInfo() {
        System.out.println("나의 레벨은 비기너다.");
    }
}
