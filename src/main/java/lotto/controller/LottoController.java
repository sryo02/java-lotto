package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.exeptions.InputExeptions.*;

public class LottoController {
    public static int purchasingAmount = 0;
    private static List<Integer> numbers = new ArrayList<Integer>();
    public static Lotto winningNumbers = new Lotto(numbers);
    public static int bonusNumber = 0;


    public static void StartingLotto() {
        try {
            purchasingAmount = InputController.getPurchasingAmout();
            numbers = InputController.getWinningNumber();
            bonusNumber = InputController.getBonusNumber();
            WinningNumbers winningNumbers = new WinningNumbers(numbers,bonusNumber);

            validatePurchasingAmount(purchasingAmount);
            validateWinningNumber(numbers);
            validateBonusNumber(bonusNumber);
            validateBonus_LottoDuplicated(numbers,bonusNumber);


        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }



    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
