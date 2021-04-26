package singleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singleton.case1.EagerSingleton;
import singleton.case2.LazySingletonDCL;
import singleton.case3.LazySingletonEnum;
import singleton.case4.LazySingletonHolder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * getInstance 호출시 user-defined-class-loader가 EagerSingleton.class 파일을 로드하면서 생성자 호출한다.
     * 그 이후 getInstance()를 호출한다.
     */
    @Test
    @DisplayName("EagerSingleton 생성자 호출 순서 체크")
    void eager_singleton() {
        System.out.println("EagerSingleton.getInstance() 호출");
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();

        assertEquals("EagerSingleton.getInstance() 호출\n" +
                "생성자 호출\n" +
                "getInstance() 호출\n", outContent.toString());
    }

    /**
     * 클래스 로더에 의존하는 것이 아닌 volatile, synchronized 키워드를 활용하여 thread-safe 하게 객체 생성
     * getInstance() 호출하고
     * 생성자를 호출한다.
     */
    @Test
    @DisplayName("LazySingletonDCL 생성자 호출 순서 체크")
    void lazy_singleton_DCL() {
        System.out.println("LazySingletonDCL.getInstance() 호출");
        LazySingletonDCL lazySingletonDCL = LazySingletonDCL.getInstance();

        assertEquals("LazySingletonDCL.getInstance() 호출\n" +
                "getInstance() 호출\n" +
                "생성자 호출\n", outContent.toString());
    }

    /**
     * Enum 자체적으로 Thread-safe를 보장한다.
     * user-defined-class-loader 가 해당 클래스를 로드할 때 Enum 생성자를 호출한다.
     * 생성자 호출
     * getInstance() 호출
     */
    @Test
    @DisplayName("LazySingletonEnum 생성자 호출 순서 체크")
    void lazy_singleton_enum() {
        System.out.println("LazySingletonEnum.getInstance() 호출");
        LazySingletonEnum lazySingletonEnum = LazySingletonEnum.getInstance();

        assertEquals("LazySingletonEnum.getInstance() 호출\n" +
                "생성자 호출\n" +
                "getInstance() 호출\n", outContent.toString());
    }

    /**
     * 내부 static 클래스는 클래스로더가 로딩될때 로드하지 않기 때문에 생성자가 호출되지 않는 것을 활용한 방법
     * getInstance() 호출 후
     * 내부 클래스 호출
     * 생성자 호출
     */
    @Test
    @DisplayName("LazySingletonHolder 생성자 호출 순서 체크")
    void lazy_singleton_Holder() {
        System.out.println("LazySingletonHolder.getInstance() 호출");
        LazySingletonHolder lazySingletonHolder = LazySingletonHolder.getInstance();

        assertEquals("LazySingletonHolder.getInstance() 호출\n" +
                "getInstance() 호출\n" +
                "생성자 호출\n", outContent.toString());
    }

}