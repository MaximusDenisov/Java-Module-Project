package app;

import app.calc.Calculator;
import app.questionnaire.Questions;
import app.utils.Formatter;

public class RestaurantCalculator {

    public void start() {

        System.out.println("\nДобро пожаловать в приложение для расчёта раздельной оплаты заказа");

        //Создаём объекты классов Calculator, Questions, Formatter -> Java.way
        Calculator calculator = new Calculator();
        Questions questions = new Questions();
        Formatter formatter = new Formatter();

        //Пользователь вводит кол-во посетителей
        calculator.setCount(questions.getCountOfPeople());

        //Пользователь вводит кол-во товаров для приобретения
        calculator.setProductList(questions.getProductCart());

        //Получаем долю которую должен оплатить каждый
        double cost = calculator.calculateSumForEveryone();

        //Определяем склонение рубля
        String currency = formatter.getCurrency(cost);

        //Выводим пользователю значение
        System.out.println("\nКаждому необходимо заплатить: " + String.format("%.2f", cost) + " " + currency);
    }
}
