package search;

import java.util.*;

public class InvertedIndex {
    public static Map<String, List<Integer>> buildInvertedIndex(List<String> allPeople) {
        List<String> words = new ArrayList<>();
        allPeople.forEach(line -> words.addAll(splitStrings(line)));
        Map<String, List<Integer>> returnMap = new HashMap<>();
        words.forEach(word -> {
            List<Integer> indexList = new ArrayList<>();
            for(int i = 0; i < allPeople.size(); i++){
                if(allPeople.get(i).toLowerCase().contains(word.toLowerCase())){
                    indexList.add(i);
                }
            }
            returnMap.put(word.toLowerCase(), indexList);
        });
        return returnMap;
    }

    public static List<String> splitStrings(String str) {
        return Arrays.asList((str.split("\\s+")));
    }


}
