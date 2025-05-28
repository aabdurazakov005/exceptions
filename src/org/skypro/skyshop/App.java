package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        // Демонстрация проверок
        try {
            new SimpleProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Чай", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Создание корректных продуктов
        SearchEngine engine = new SearchEngine(10);
        engine.add(new SimpleProduct("Молоко молоко молоко", 80));
        engine.add(new SimpleProduct("Молоко", 90));
        engine.add(new Article("О молоке", "Молоко полезно"));

        // Демонстрация успешного поиска
        try {
            Searchable best = engine.findBestMatch("Молоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Демонстрация исключения при поиске
        try {
            engine.findBestMatch("Несуществующий");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}