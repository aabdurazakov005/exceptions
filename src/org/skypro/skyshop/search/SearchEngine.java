package org.skypro.skyshop.search;

import org.skypro.skyshop.articles.Searchable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        return searchables.stream()
                .filter(item -> item != null &&
                        item.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .sorted(Comparator.comparing(Searchable::getName))
                .collect(Collectors.toMap(
                        Searchable::getName,
                        item -> item,
                        (existing, replacement) -> existing
                ));
    }

}