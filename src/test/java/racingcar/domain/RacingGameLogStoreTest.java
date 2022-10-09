package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameLogStoreTest {

    @DisplayName("자동차 경주 결과 로그에 1명 이상이 포함되는지 확인")
    @Test
    void logWithRacingCarName() {
        // given
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 10;
        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);

        // when
        game.run();

        // then
        assertAll(
                () -> assertThat(game.getGameLogs()
                                     .size()).isEqualTo(gameTurnCount),
                () -> assertTrue(game.getGameLogs()
                                     .stream()
                                     .allMatch(racingGameLog -> racingGameLog.getRacingCars()
                                                                             .getRacingCars()
                                                                             .size() == 3))
        );
    }

    @DisplayName("자동차 경주 로그에 자동차 이름이 포함되는지 확인")
    @Test
    void racingLogWithRacingCarName() {
        // given
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;
        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);

        // when
        game.run();

        // then
        boolean containAllRacingCarName = game.getGameLogs()
                                              .stream()
                                              .allMatch(log -> log.getRacingCars()
                                                                  .getRacingCars()
                                                                  .size() == 3);
        assertTrue(containAllRacingCarName);
    }

    @DisplayName("자동차 경주 로그 저장소 사이즈 확인")
    @Test
    void sizeLogs() {
        // given
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;
        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);

        // when
        game.run();

        // then
        assertThat(game.getGameLogs()
                       .size()).isEqualTo(5);
    }
}
