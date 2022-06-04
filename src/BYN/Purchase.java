package BYN;

import BYN.Exception.NonpositiveArgumentException;
import BYN.Exception.OutofRangeException;
import BYN.Exception.PatternArgumentException;

//milk;1.31;2
public class Purchase {
    private final Product product;
    private final int unitsNumber;

    public Purchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = getUnitsNumber(unitsNumber);
        validCost(unitsNumber, product);
    }


    public int getUnitsNumber(int unitsNumber) {
        if (unitsNumber < 0) {
            throw new NonpositiveArgumentException("units", unitsNumber);
        }
        return unitsNumber;
    }

    public int getUnitsNumber(String unitsNumber) {
        if (!unitsNumber.matches("\\d+")) {
            throw new PatternArgumentException(unitsNumber);
        }

        return Integer.parseInt(unitsNumber);
    }

    public Purchase(Product product, String str) {
        this.product = product;
        this.unitsNumber = getUnitsNumber(str);
        validCost(unitsNumber, product);
    }

    private void validCost(int unitsNumber, Product product) {
        long maxCost = (long) unitsNumber * (long) product.getPrice().getValue();
        if ((int) maxCost != maxCost) {
            throw new OutofRangeException("range", (int) maxCost);
        }
    }

    @Override
    public String toString() {
        return product + ";" + unitsNumber;
    }

}
