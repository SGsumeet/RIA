package A1s;

public class Item {
    // properties of items
    public String name;
    public int quantity;
    public Type type;
    public float price;
    private boolean isExempted;
    private boolean isImported;

    public Item(String name, int quantity, Type type, boolean isImoprted, boolean isExempted, float price) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.isImported = isImoprted;
        this.isExempted = isExempted;

    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempted() {
        return isExempted;
    }
}
