package templatemethod.case1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
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

    @Test
    @DisplayName("테슬라 주행")
    void tesla() {
        // given
        Car car = new Tesla();

        // when
        car.go();

        // then
        assertEquals("테슬라 시동건다\n" +
                "테슬라 출발한다.\n" +
                "테슬라 멈춘다.\n" +
                "테슬라 시동끈다.\n", outContent.toString());
    }

    @Test
    @DisplayName("싼타페 주행")
    void santafe() {
        // given
        Car car = new Santafe();

        // when
        car.go();

        // then
        assertEquals("싼타페 시동건다\n" +
                "싼타페 출발한다.\n" +
                "싼타페 멈춘다.\n" +
                "싼타페 시동끈다.\n", outContent.toString());
    }
}