package BYN;

import BYN.Exception.PatternArgumentException;

public class Product {
    private final String name;
    private final Byn price;

    public String getValidName(String strName) {
        if (!strName.matches("^[a-zA-Z ]+$")) {
            throw new PatternArgumentException(strName);
        }
        return strName;
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public Product(String name, Byn price) {
        this.name = getValidName(name);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
