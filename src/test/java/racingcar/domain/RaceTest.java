package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.Cars;
import racingcar.domian.Race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다.")
    void 시도횟수_예외_테스트() {
        Cars cars = new Cars(java.util.List.of("pobi", "woni"));

        assertThatThrownBy(() -> new Race(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
