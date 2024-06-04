package app.calc;

import java.util.ArrayList;

public class Calculator {
    public static double calculateSumForEveryone(ArrayList<Product> productArrayList, int count) {
        double costSum = 0.0;
        for (Product product : productArrayList) {
            costSum = costSum + product.cost;
        }
        return costSum / count;
    }
}
