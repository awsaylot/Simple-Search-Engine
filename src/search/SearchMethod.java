package search;

import java.util.List;
import java.util.Map;

public interface SearchMethod {
    void searchPeople(Map<String, List<Integer>> invertedIndex, List<String> allPeople);
}
