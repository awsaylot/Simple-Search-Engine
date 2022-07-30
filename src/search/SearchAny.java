package search;

import java.util.*;

import static search.Main.getInput;

public class SearchAny implements SearchMethod {
    @Override
    public void searchPeople(Map<String, List<Integer>> invertedIndex, List<String> allPeople) {
        System.out.println("Search Any");

        System.out.println("Enter a name or email to search all suitable people.");
        List<String> searchData = List.of(getInput().toLowerCase().split("\\s+"));
        Set<String> words = invertedIndex.keySet();
        Set<Integer> foundIndices = new HashSet<>();
        searchData.forEach(word -> {
            if(words.contains(word)) {
                invertedIndex.get(word).forEach(index -> foundIndices.add(index));
            }
        });
        if(foundIndices.size() > 0) {
            foundIndices.forEach(index -> System.out.println(allPeople.get(index)));
        } else {
            System.out.println("0 people found");
        }
    }
}
