package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new DiscountedProduct("Молоко", 100, 20));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new SimpleProduct("Хлеб", 50)); // Дубликат

        System.out.println("= Удаление 'Хлеб' =");
        List<Product> removed = basket.removeProductsByName("Хлеб");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            removed.forEach(p -> System.out.println(p.getName() + " удален."));
        }
        basket.printBasketContents();

        System.out.println("= Удаление несуществующего продукта =");
        List<Product> notFound = basket.removeProductsByName("Мясо");
        System.out.println(notFound.isEmpty() ? "Список пуст." : "Продукты найдены.");
        basket.printBasketContents();

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Молоко", 80));
        engine.add(new Article("О молоке", "Польза молока"));
        engine.add(new SimpleProduct("Хлеб", 50));

        System.out.println("= Результаты поиска 'молоко' =");
        List<Searchable> results = engine.search("молоко");
        results.forEach(r -> System.out.println(r.getStringRepresentation()));
    }
}