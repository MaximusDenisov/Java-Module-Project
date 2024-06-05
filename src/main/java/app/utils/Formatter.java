package app.utils;

public class Formatter {
    public String getCurrency(double costSum) {
        String currency;
        int cost = (int) Math.floor(costSum);
        int num = cost % 100;

        if (num >= 11 && num <= 19) {
            currency = "Рублей";
        } else {
            num = num % 10;
            currency = switch (num) {
                case 1 -> "Рубль";
                case 2, 3, 4 -> "Рубля";
                default -> "Рублей";
            };
        }
        return currency;
    }
}
