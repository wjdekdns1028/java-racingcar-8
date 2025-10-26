package racingcar.domian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> findWinners(){
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
