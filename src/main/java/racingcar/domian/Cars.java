package racingcar.domian;

import java.util.ArrayList;
import java.util.List;

// 여러 대의 자동차를 관리
public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name)); // Car 내부에서 이름 검증 수행
        }
    }

    public void moveAll(){
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
