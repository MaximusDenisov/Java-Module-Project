package app;

import java.util.ArrayList;

import app.calc.Calculator;
import app.calc.Product;
import app.questionnaire.Questions;
import app.utils.Namer;

public class RestaurantCalculator {

    public static void start() {

        System.out.println("\nДобро пожаловать в приложение для расчёта раздельной оплаты заказа");

        //Пользователь вводит кол-во посетителей
        int count = Questions.getCountOfPeople();

        //Объявляем "корзину" с покупками
        ArrayList<Product> products = new ArrayList<>();

        //Пользователь вводит кол-во товаров для приобретения
        Questions.getProductCart(products);

        //Высчитываем долю каждого из посетителей
        double cost = Calculator.calculateSumForEveryone(products, count);

        //Определяем склонение рубля
        String currency = Namer.getCurrency(cost);

        //Выводим пользователю значение
        System.out.println("\nКаждому необходимо заплатить: " + String.format("%.2f", cost) + " " + currency);
    }
}
