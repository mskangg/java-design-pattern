package templatemethod.case2;

public abstract class PlayerLevel {
    protected abstract void walk();

    protected abstract void run();

    protected abstract void jump();

    protected abstract void showLevelInfo();

    // 템플릿 메소드 (final 오버라이딩 할 수 없음)
    public final void go(int count) {
        walk();
        run();
        for (int i = 0; i < count; i++) {
            jump();
        }
    }
}
