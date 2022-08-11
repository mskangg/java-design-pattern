package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * 이른 초기화 (eager initialization)에서 Exception이 발생할 경우를 대비한 방법
 * Static Block Initialization
 */
public class Settings6 {
    private static Settings6 instance;

    private Settings6() {
    }

    static {
        try {
            instance = new Settings6();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Settings6 getInstance() {
        return instance;
    }
}
