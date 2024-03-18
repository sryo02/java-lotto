package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bounusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bounusNumber) {
        this.winningNumbers = winningNumbers;
        this.bounusNumber = bounusNumber;
    }
}
