package racingcar.domian;

import racingcar.util.RandomUtils;

// 자동차 1대를 관리
public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.trim().length() < 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move() {
        int randomNumber = RandomUtils.pickNumberInRange(0, 9);
        if (randomNumber < MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionBar(){
        return "-".repeat(position);
    }

}
