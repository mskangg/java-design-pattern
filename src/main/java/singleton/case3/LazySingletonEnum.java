package singleton.case3;

/**
 * Lazy Init (Enum)
 * Enum 인스턴스의 생성은 기본적으로 Thread-safe 하다.
 * 하지만 만드려는 싱글턴이 Enum 외에 클래스를 상속해야 하는 경우에는 사용할 수 없다.
 * 또한, 안드로이드와 같이 Context 의존성이 있는 환경일 경우 싱글턴의 초기화 과정에 Context라는 의존성이 끼어들 가능성이 있다.
 */
public enum LazySingletonEnum {
    INSTANCE("Unique Instance");

    private final String type;

    LazySingletonEnum(String type) {
        System.out.println("생성자 호출");
        this.type = type;
    }

    public static LazySingletonEnum getInstance() {
        System.out.println("getInstance() 호출");
        return INSTANCE;
    }

    public String getType() {
        return type;
    }
}
