package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;
    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        try {
            SimpleProduct invalidPriceProduct = new SimpleProduct("Молоко", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
        }

        try {
            SimpleProduct negativePriceProduct = new SimpleProduct("Хлеб", 15);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания SimpleProduct: " + e.getMessage());
        }
    }

    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}