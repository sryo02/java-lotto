package lotto.exeptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputExeptions {
    private static final String PURCHASING_ERROR_MESSAGE = "[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 로또의 번호는 1~45 사이의 숫자여야 합니다.";
    private static final String NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String BONUS_LOTTO_DUPLICATED_ERROR_MESSAGE = "[ERROR] 보너스 번호와 당첨 번호는 같을 수 없습니다.";
    private static final int STARTING_POINT_OF_RANGE = 1;
    private static final int ENDING_POINT_OF_RANGE = 45;

    private static boolean isInLottoRange(int number){
        if(STARTING_POINT_OF_RANGE<=number && number<=ENDING_POINT_OF_RANGE){
            return true;
        }
        return false;
    }
    private static boolean isNumbersInLottoRange(List<Integer> numbers){
        for(int number : numbers){
            if(!isInLottoRange(number)){
                return false;
            }
        }
        return true;
    }
    private static boolean isNumbersUnduplicated(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size()==numberSet.size())
            return true;
        return false;
    }

    public static void validatePurchasingAmount(int amount){
        if(amount%100 != 0 || amount<=0) {
            throw new IllegalArgumentException(PURCHASING_ERROR_MESSAGE);
        }
    }
    public static void validateWinningNumber(List<Integer> numbers){
        if(!isNumbersInLottoRange(numbers)){
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        if(!isNumbersUnduplicated(numbers)){
            throw new IllegalArgumentException(NUMBER_DUPLICATED_ERROR_MESSAGE);
        }
    }
    public static void validateBonusNumber(int number){
        if(!isInLottoRange(number)){
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
    public static void validateBonus_LottoDuplicated(List<Integer> numbers, int number){
        if(numbers.contains(number)){
            throw new IllegalArgumentException(BONUS_LOTTO_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
