package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class InputController {
    private static final String GET_PURCHASING_AMOUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 입력 값이 올바르지 않습니다.";


    public static int getPurchasingAmout() {
        System.out.println(GET_PURCHASING_AMOUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(GET_WINNING_NUMBER_MESSAGE);
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}