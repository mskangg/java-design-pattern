package templatemethod.case2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
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
    @DisplayName("PlayLevel(beginner)에 맞게 걷고 뛰고 점프하는 테스트")
    void walk_run_jump_according_to_beginner_player_level() {
        // given
        Player player = new Player();

        // when
        player.play(3);

        // then
        assertEquals("플레이어가 생성되었습니다.\n" +
                "나의 레벨은 비기너다.\n" +
                "비기너는 걷는다.\n" +
                "비기너는 뛰지 못한다.\n" +
                "비기너는 점프하지 못한다.\n" +
                "비기너는 점프하지 못한다.\n" +
                "비기너는 점프하지 못한다.\n", outContent.toString());
    }

    @Test
    @DisplayName("PlayLevel(intermediate)에 맞게 걷고 뛰고 점프하는 테스트")
    void walk_run_jump_according_to_intermediate_player_level() {
        // given
        Player player = new Player();
        player.levelUp(new IntermediatePlayerLevel());

        // when
        player.play(3);

        // then
        assertEquals("플레이어가 생성되었습니다.\n" +
                "나의 레벨은 비기너다.\n" +
                "Level Up!!\n" +
                "나의 레벨은 인터미디엇이다.\n" +
                "인터미디엇은 걷는다.\n" +
                "인터미디엇은 천천히 뛴다.\n" +
                "인터미디엇은 점프하지 못한다.\n" +
                "인터미디엇은 점프하지 못한다.\n" +
                "인터미디엇은 점프하지 못한다.\n", outContent.toString());
    }

    @Test
    @DisplayName("PlayLevel(advanced)에 맞게 걷고 뛰고 점프하는 테스트")
    void walk_run_jump_according_to_advanced_player_level() {
        // given
        Player player = new Player();
        player.levelUp(new AdvancedPlayerLevel());

        // when
        player.play(3);

        // then
        assertEquals("플레이어가 생성되었습니다.\n" +
                "나의 레벨은 비기너다.\n" +
                "Level Up!!\n" +
                "나의 레벨은 어드밴스드다.\n" +
                "어드밴스드는 빨리 걷는다.\n" +
                "어드밴스드는 빨리 뛴다.\n" +
                "어드밴스드는 보통 높이로 점프한다.\n" +
                "어드밴스드는 보통 높이로 점프한다.\n" +
                "어드밴스드는 보통 높이로 점프한다.\n", outContent.toString());
    }
}