package templatemethod.case1;

/**
 * 템플릿 메서드를 제공해 해당 메서드의 동작 순서를 보장한다.
 */
public abstract class Car {

    protected abstract void turnOn();   // 시동 걸기

    protected abstract void drive();    // 출발

    protected abstract void stop();     // 멈춤

    protected abstract void turnOff();  // 시동 끄기

    // 템플릿 메소드(final 오버라이딩 할 수 없음)
    public final void go() {
        turnOn();
        drive();
        stop();
        turnOff();
    }
}
