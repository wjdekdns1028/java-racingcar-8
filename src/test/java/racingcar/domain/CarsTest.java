package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("모든 자동차가 moveAll() 호출 시 이동 기회를 갖는다.")
    void 전체_이동_테스트() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        cars.moveAll();

        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자로 계산된다.")
    void 우승자_계산_테스트() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        cars.getCars().get(0).move();
        cars.getCars().get(0).move();
        cars.getCars().get(1).move();

        List<String> winners = cars.findWinners();
        assertThat(winners).contains("pobi");
    }
}
