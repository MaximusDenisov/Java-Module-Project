package app.calc;

import java.util.ArrayList;

public class Calculator {

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private ArrayList<Product> productList;
    private int count;

    public double calculateSumForEveryone() {
        double costSum = 0.0;
        for (Product product : productList) {
            costSum = costSum + product.cost;
        }
        return costSum / count;
    }
}
