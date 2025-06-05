package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();
    private int count = 0;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        return removed;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products.get(i).getPrice();
        }
        return total;
    }

    public void printBasketContents() {
        if (count == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(products.get(i).toString());
            if (products.get(i).isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products.get(i).getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products.set(i, null);
        }
        count = 0;
    }
}