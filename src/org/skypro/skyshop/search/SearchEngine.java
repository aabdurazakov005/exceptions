package org.skypro.skyshop.search;

import org.skypro.skyshop.articles.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase()
                    .contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }
}