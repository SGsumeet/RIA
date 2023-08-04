package A1s; // assignment 1 solution

import java.util.ArrayList;

public class TaxCalculator {

    public ArrayList<Item> items;

    TaxCalculator() {
        getOrders();
    }

    public static void main(String[] args) throws Exception {

        float totalPrice = 0.0f;
        float totalTax = 0.0f;
        TaxCalculator oj = new TaxCalculator();
        int length = oj.items.size();
        System.out.println("------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Item item = oj.items.get(i);
            float item_tax = getRoundedOffValue(calculateTax(item));
            float item_price = Round((item.price + item_tax) * item.quantity);
            totalTax += item_tax * item.quantity;
            totalPrice += item_price;

            System.out.println(item.quantity + " " + item.name + " at " + item_price);
        }
        System.out.println("Sales Tax : " + getRoundedOffValue(totalTax));
        System.out.println("total : " + Round(totalPrice));
        System.out.println("------------------------------------------------");

    }

    public void getOrders() {
        try {
            ReadOrder orders = new ReadOrder();
            items = orders.OrderReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float calculateTax(Item item) {
        float tax = 0.0f;
        if (item.isExempted()) { // if exempted item - book , medicine, food
            if (item.isImported()) { // if exempted but imported - 5% tax
                return item.price * 0.05f;
            } else // else exempted - 0 tax
                return tax;

        } else {
            if (item.isImported()) { // if not exempted and also imported - 10% as well as 5 %
                return (item.price * 0.1f + item.price * 0.05f);
            } else { // if not exempted and not imported - 10% local tax
                return (item.price * 0.1f);
            }
        }
    }

    public static float Round(float value) // simple round off function
    {
        value = (float) (Math.ceil((double) value * 100)) / 100;
        return value;
    }

    public static float getRoundedOffValue(float value) {// function ro round of to 0.05 amounts
        value = (float) Math.ceil((double) (value * 20));
        value /= 20;
        return value;
    }
}