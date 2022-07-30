package search;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static search.Main.getInput;

public class SearchNone implements SearchMethod {
    @Override
    public void searchPeople(Map<String, List<Integer>> invertedIndex, List<String> allPeople) {
        System.out.println("Enter a name or email to search all suitable people.");
        List<String> searchData = List.of(getInput().toLowerCase().split("\\s+"));
        Set<String> words = invertedIndex.keySet();
        Set<Integer> foundIndices = new HashSet<>();
        if(!words.containsAll(searchData)) {
            allPeople.forEach(line -> System.out.println(line));
            return;
        }
        searchData.forEach(word -> {
            if(words.contains(word)) {
                invertedIndex.get(word).forEach(index -> foundIndices.add(index));
            }
        });
        if(foundIndices.size() == allPeople.size()) {
            System.out.println("0 people found");
        }
        for(int i = 0; i < allPeople.size(); i++) {
            if(foundIndices.contains(i)){
                continue;
            }
            System.out.println(allPeople.get(i));
        }
    }
}
