package A1s;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadOrder {
    public ArrayList<Item> OrderReader() throws Exception {
        ArrayList<Item> Items = new ArrayList<>();

        FileReader fr = new FileReader("OrderList.txt");
        BufferedReader br = new BufferedReader(fr);
        // System.out.println(br.readLine());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            String[] arr = line.split(" ", 2);

            int Quantity = Integer.parseInt(arr[0]); // Quantity
            System.out.println("Quantity : " + Quantity);

            String[] brr = arr[1].split(" at ");
            String purchasedItem = brr[0]; // purchasedItem - Name
            System.out.println("Purchased Item : " + purchasedItem);

            boolean isImported = line.contains("imported");// Imported or not
            System.out.println("Is Imported : " + isImported);
            Type type = getType(purchasedItem, isImported);

            // String[] exemptedItems = new String[] { "book", "chocolate", "pills" };

            boolean isExempted = exemptCheck(type);// exempted or not
            System.out.println("Is Exempted : " + isExempted);

            float price = Float.parseFloat(brr[1]); // Price
            System.out.println("Price : " + price);
            Item item = new Item(purchasedItem, Quantity, type, isImported, isExempted, price);
            Items.add(item);
        }
        br.close();
        return Items;

    }

    public static Type getType(String itemname, boolean isImported) {
        if (!isImported) {
            if (itemname.contains("book")) {
                return Type.BOOK;
            } else if (itemname.contains("chocolate")) {
                return Type.FOOD;
            } else if (itemname.contains("pills")) {
                return Type.MEDICAL;
            } else {
                return Type.OTHERS;
            }

        } else {
            if (itemname.contains("book")) {
                return Type.IMPORTED_BOOK;
            } else if (itemname.contains("chocolate")) {
                return Type.IMPORTED_FOOD;
            } else if (itemname.contains("pills")) {
                return Type.IMPORTED_MEDICAL;
            } else {
                return Type.IMPORTED_OTHERS;
            }
        }
    }

    public boolean exemptCheck(Type ItemType) {
        switch (ItemType) {
            case BOOK:
            case FOOD:
            case MEDICAL:
            case IMPORTED_BOOK:
            case IMPORTED_FOOD:
            case IMPORTED_MEDICAL:
                return true;

            default:
                return false;

        }
    }

}
