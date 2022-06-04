package BYN;

import BYN.Exception.NegativeArgumentException;
import BYN.Exception.OutofRangeException;
import BYN.Exception.PatternArgumentException;

//Посмотреть Try catch, pricediscount дописать
public class PriceDiscountPurchase extends Purchase {
    private int discount;

    public PriceDiscountPurchase(Product product, int unitsNumber, int discount) {
        super(product, unitsNumber);
        this.discount = getDiscount(discount, product);

    }

    public PriceDiscountPurchase(Product product, String unitsnumber, String discount) {
        super(product, unitsnumber);
        this.discount = getDiscount(getDiscount(discount), product);
    }

    public int getDiscount(String discount) {
        if (!discount.matches("\\d+\\.\\d\\d")) {
            throw new PatternArgumentException("");
        }
        String[] b = discount.split("\\.");
        return Integer.parseInt(b[0]) * 100 + Integer.parseInt(b[1]);
    }

    public int getDiscount(int discount, Product product) {
        if (discount < 0) {
            throw new NegativeArgumentException("Negative", discount);
        } else if (discount > product.getPrice().getValue()) {
            throw new OutofRangeException("Range", discount);
        }
        return discount;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discount;
    }
}

