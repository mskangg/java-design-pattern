package templatemethod.case2;

public class AdvancedPlayerLevel extends PlayerLevel {
    @Override
    protected void walk() {
        System.out.println("어드밴스드는 빨리 걷는다.");
    }

    @Override
    protected void run() {
        System.out.println("어드밴스드는 빨리 뛴다.");
    }

    @Override
    protected void jump() {
        System.out.println("어드밴스드는 보통 높이로 점프한다.");
    }

    @Override
    protected void showLevelInfo() {
        System.out.println("나의 레벨은 어드밴스드다.");
    }
}
