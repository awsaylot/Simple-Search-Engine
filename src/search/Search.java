package search;

import java.util.List;
import java.util.Map;

public class Search {
    private SearchMethod method;

    public void setMethod(SearchMethod method) {
        this.method = method;
    }

    public void searchPeople(Map<String, List<Integer>> invertedIndex, List<String> allPeople){
        this.method.searchPeople(invertedIndex, allPeople);
    }
}
