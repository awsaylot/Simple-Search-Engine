package search;

import java.util.*;

import static search.Main.getInput;

public class SearchAll implements SearchMethod {

    @Override
    public void searchPeople(Map<String, List<Integer>> invertedIndex, List<String> allPeople) {
        System.out.println("Enter a name or email to search all suitable people.");
        List<String> searchData = List.of(getInput().toLowerCase().split("\\s+"));
        Set<String> words = invertedIndex.keySet();
        Set<Integer> foundIndices = new HashSet<>();
        if(!words.containsAll(searchData)) {
            System.out.println("0 persons found.");
            return;
        } else if(searchData.size() == 1) {
            invertedIndex.get(searchData.get(0)).forEach(index -> System.out.println(allPeople.get(index)));
        } else {
            foundIndices.addAll(invertedIndex.get(searchData.get(0)));
            for(int i = 1; i < searchData.size(); i++) {
                foundIndices.retainAll(invertedIndex.get(searchData.get(i)));
            }
        }
        if(foundIndices.size() > 0) {
            foundIndices.forEach(index -> System.out.println(allPeople.get(index)));
        }
        System.out.println("0 persons found");
    }
}
