package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        return Arrays.asList(input.split(","));
    }

    public static int readAttemptCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int count = Integer.parseInt(input.trim());
            if(count < 1){
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
