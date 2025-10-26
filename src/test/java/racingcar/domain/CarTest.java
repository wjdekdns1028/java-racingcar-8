package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void 자동차_이름_길이_예외_테스트() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 비어 있으면 예외가 발생한다.")
    void 자동차_이름_공백_예외_테스트() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("랜덤값이 4 이상일 때 전진한다.")
    void 전진_테스트() {
        Car car = new Car("pobi");

        for (int i = 0; i < 5; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값이 4 미만일 대 멈춤다 (move() 호출해도 위치 변화 없음)")
    void 멈춤_테스트() {
        Car car = new Car("pobi");
        int initial = car.getPosition();

        car.move();
        assertThat(car.getPosition()).isEqualTo(initial);
    }
}
