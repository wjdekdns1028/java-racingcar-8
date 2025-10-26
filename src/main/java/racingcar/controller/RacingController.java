package racingcar.controller;

import racingcar.domian.Cars;
import racingcar.domian.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void run() {
        // 1. 입력 처리
        List<String> carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();

        // 2. 예외 처리
        Cars cars = new Cars(carNames);

        // 3. 경주 진행
        Race race = new Race(cars, attemptCount);
        race.start();

        // 3. 출력
        OutputView.printWinners(cars.findWinners());
    }
}
