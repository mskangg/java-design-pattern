package singleton.case2;

/**
 * Laza Init (Doucle Checking Locking)
 * 인스턴스가 생성되지 않은 경우에만 동기화 블럭이 실행되게 구현하는 방식
 */
public class LazySingletonDCL {
    /**
     * volatile 쓰는 이유는 Thread-safe 를 보장하기 위해서다.
     * 멀티스레드 어플리케이션에서는 작업을 수행하는 동안 성능을 향상하기 위해 main memory에서 읽은 변수 값을 CPU cache에 저장하게 된다.
     * 만약에 메인메모리와 캐시 값이 다른 순간에 변수 값 불일치 문제가 발생하는다. 이때, volatile 키워드가 문제를 해결해준다.
     */
    private volatile static LazySingletonDCL uniqueInstance;

    // private 생성자
    private LazySingletonDCL() {
        System.out.println("생성자 호출");
    }

    // Lazy Initialization. DCL
    public static LazySingletonDCL getInstance() {
        if (uniqueInstance == null) {
            synchronized (LazySingletonDCL.class) { // synchronized
                if (uniqueInstance == null) {
                    System.out.println("getInstance() 호출");
                    uniqueInstance = new LazySingletonDCL();
                }
            }
        }
        return uniqueInstance;
    }
}
