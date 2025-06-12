package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Молоко", 100, 20));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new SimpleProduct("Хлеб", 50));

        System.out.println("=== Содержимое корзины ===");
        basket.printBasketContents();

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Молоко", 80));
        engine.add(new Article("О молоке", "Польза молока"));
        engine.add(new SimpleProduct("Хлеб", 50));
        engine.add(new SimpleProduct("Яблоки", 120));

        System.out.println("= Результаты поиска 'молоко' =");
        Map<String, Searchable> results = engine.search("молоко");
        results.forEach((name, item) ->
                System.out.println(name + " - " + item.getContentType())
        );

        System.out.println("Осталось в корзине:");
        basket.printBasketContents();
    }
}