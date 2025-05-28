package org.skypro.skyshop.search;

import org.skypro.skyshop.articles.Searchable;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentSize;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (currentSize < searchables.length) {
            searchables[currentSize++] = searchable;
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < currentSize; i++) {
            Searchable item = searchables[i];
            if (item != null) {
                int count = countSubstringOccurrences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }
}