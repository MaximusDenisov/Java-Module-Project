package app.utils;

public class Namer {
    public static String getCurrency(double costSum) {
        String currency;
        int cost = (int) Math.floor(costSum);
        String num = String.valueOf(cost % 10);
        switch (num) {
            case "0":
                currency = "Рублей";
                break;
            case "1":
                currency = "Рубль";
                break;
            case "2":
                currency = "Рубля";
                break;
            case "3":
                currency = "Рубля";
                break;
            case "4":
                currency = "Рубля";
                break;
            default:
                currency = "Рублей";
                break;
        }
        return currency;
    }
}
