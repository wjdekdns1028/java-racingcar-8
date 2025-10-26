package racingcar.domian;

import racingcar.view.OutputView;

public class Race {
    private final Cars cars;
    private final int attemptCount;

    public Race(Cars cars, int attemptCount) {
        validateAttemptCount(attemptCount);
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    private void validateAttemptCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void start() {
        OutputView.printResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            cars.moveAll();
            OutputView.printRoundResult(cars.getCars());
        }
    }
}
