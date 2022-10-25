package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;
import ru.netology.web.page.DashboardPage;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;

@Value
public class DataHelper {

    private static Faker fake = new Faker(new Locale("ru"));

    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static CardInfo getCardNumber1() {
        return new CardInfo("5559000000000001");
    }

    public static CardInfo getCardNumber2() {
        return new CardInfo("5559000000000002");
    }


    public static int getPossibleAmount(int balance) {

        return new Random().nextInt(balance) + 1;
    }

    public static int getImpossibleAmount(int balance) {

        return Math.abs(balance) + new Random().nextInt(1000);
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
    }

}