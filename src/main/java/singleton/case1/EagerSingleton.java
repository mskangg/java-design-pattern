package singleton.case1;

/**
 * Eager Init
 * static 생성자를 통해 컴파일 로더가 클래스를 로딩할 때 인스턴스를 메모리에 등록하게 하여 Thread-safe를 보장하는 방법
 */
public class EagerSingleton {
    // Eager Initialization
    private static final EagerSingleton uniqueInstance = new EagerSingleton();

    // private 생성자
    private EagerSingleton() {
        System.out.println("생성자 호출");
    }

    public static EagerSingleton getInstance() {
        System.out.println("getInstance() 호출");
        return uniqueInstance;
    }
}
