package templatemethod.case1;

public class Tesla extends Car {

    @Override
    protected void turnOn() {
        System.out.println("테슬라 시동건다");
    }

    @Override
    protected void drive() {
        System.out.println("테슬라 출발한다.");
    }

    @Override
    protected void stop() {
        System.out.println("테슬라 멈춘다.");
    }

    @Override
    protected void turnOff() {
        System.out.println("테슬라 시동끈다.");
    }
}
