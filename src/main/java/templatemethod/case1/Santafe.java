package templatemethod.case1;

public class Santafe extends Car {

    @Override
    protected void turnOn() {
        System.out.println("싼타페 시동건다");
    }

    @Override
    protected void drive() {
        System.out.println("싼타페 출발한다.");
    }

    @Override
    protected void stop() {
        System.out.println("싼타페 멈춘다.");
    }

    @Override
    protected void turnOff() {
        System.out.println("싼타페 시동끈다.");
    }
}
