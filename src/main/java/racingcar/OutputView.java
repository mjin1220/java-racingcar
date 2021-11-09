package racingcar;

import java.util.List;

public interface OutputView {
    void showOutputMessage();
    void showStartOfRound(int round);
    void showEndOfRound(int round);
    void showRacing(List<Integer> progressOfCars);
}