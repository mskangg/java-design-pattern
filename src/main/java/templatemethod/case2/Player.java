package templatemethod.case2;

/**
 * - 게임에서 Player가 가지는 레벨에 따라 walk(), run(), jump() 세 가지 기능을 할 수 있다.
 * - Beginner 레벨: 천천히 걷는 walk()만 가능, run(), jump() 불가
 * - Intermediate 레벨: 보통 속도로 걷는 walk(), 천천히 달리는 run() 가능, jump() 불가
 * - advanced 레벨: 빨리 걷는 walk(), 보통 속도로 달리는 run(), 보통 높이로 점프하는 jum() 가능
 * - Player의 play()를 통해 위 세 가지 기능을 수행하고 횟수를 매개변수로 받아 횟수 만큼 jump() 한다.
 */
public class Player {
    private PlayerLevel level;

    public Player() {
        level = new BeginnerPlayerLevel();
        System.out.println("플레이어가 생성되었습니다.");
        level.showLevelInfo();
    }

    public void play(int count) {
        level.go(count);
    }

    public void levelUp(PlayerLevel level) {
        this.level = level;
        System.out.println("Level Up!!");
        this.level.showLevelInfo();
    }
}

