package app.questionnaire;

import java.util.ArrayList;
import java.util.Scanner;

import app.calc.Product;

public class Questions {

    // Домучил себя заюзать делимитер, можете присваивать названия продуктам через пробел. Пример: Пиво "Жигулёвское" или Йогурт "Скелетон".
    static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    // Метод для получения кол-ва человек от пользователя
    public static int getCountOfPeople() {
        while (true) {
            System.out.print("\nВведите количество человек для разделения счёта: ");
            try {
                int count = Integer.parseInt(scanner.next());
                if (count == 1) {
                    System.err.println("\nЗачем разделять счёт для одного человека?\n(Введите корректное количество человек для разделения счёта)");
                } else if (count < 1) {
                    System.err.println("\nВведено некорректное значение для подсчёта!\n(Введите корректное количество человек для разделения счёта)");
                } else {
                    return count;
                }
            } catch (NumberFormatException exc) {
                System.err.println("Недопустимое значение кол-ва людей, введите целое число!");
            }
        }
    }

    // Метод для создания товаров и помещения их в корзину
    public static ArrayList<Product> getProductCart(ArrayList<Product> products) {
        boolean needMore = true;
        while (needMore) {
            try {
                // Получаем название товара
                System.out.print("\nУкажите название товара: ");
                String name = scanner.next();

                // Получаем цену товара
                double cost = getCostOfProduct();

                // Создаём товар и помещаем его в "корзину"
                Product product = new Product(name, cost);
                products.add(product);

                System.out.println("Товар добавлен!");

                // Спрашиваем клиента, достаточно ли ему, если достаточно, то цикл завершится.
                needMore = isNeedMore();
            } catch (NumberFormatException exc) {
                System.err.println("\nВы ввели некорректное значение стоимости.\nВведите целое положительное число, либо значение через точку");
            }
        }

        System.out.println("\nДобавленные товары:\n______________________");
        for (Product product : products) {
            System.out.println("Название: " + product.name + "\nЦена: " + String.format("%.2f", product.cost) + "\n______________________");
        }
        return products;
    }

    // Метод для определения, необходимо ли клиенту указать ещё товар
    public static boolean isNeedMore() {
        System.out.print("Нужно ли добавить ещё товар? (Введите 'Завершить' для того, чтобы посчитать стоимость, либо любое другое значение для продолжения): ");
        String answer = scanner.next();
        return !answer.toLowerCase().equals("завершить");
    }

    // Метод для указывания стоимости товара
    private static double getCostOfProduct() {
        // Получаем цену товара
        double cost = 0.0;
        while (cost <= 0) {
            try {
                System.out.print("\nУкажите стоимость товара: ");
                cost = Double.parseDouble(scanner.next());
                if (cost <= 0) {
                    System.err.println("Цена не может быть меньше или равна 0.\nВведите корректное значение.");
                }
            } catch (NumberFormatException exc) {
                System.err.println("\nВы ввели некорректное значение стоимости.\nВведите целое положительное число, либо значение через точку");
            }
        }
        return cost;
    }
}
