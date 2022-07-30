package search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static search.InvertedIndex.buildInvertedIndex;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File(args[1]);
        File file = new File("names.txt");
        Scanner scanner = new Scanner(file);
        List<String> allPeople = new ArrayList<>();
        while (scanner.hasNext()) {
            allPeople.add(scanner.nextLine());
        }
        scanner.close();
        boolean shouldContinue = true;
        while(shouldContinue) {
            shouldContinue = menu(allPeople);
        }
    }

    public static void printMenu(){
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person.");
        System.out.println("2. Print all people.");
        System.out.println("0. Exit.");
    }

    public static boolean menu(List<String> allPeople){
        printMenu();
        String choice = getInput();
        Map<String, List<Integer>> invertedIndex = buildInvertedIndex(allPeople);
        Search search = new Search();
        switch(choice){
            case "1":
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String strategyChoice = getInput();
                switch(strategyChoice){
                    case "ALL":
                        search.setMethod(new SearchAll());
                        search.searchPeople(invertedIndex, allPeople);
                        return true;
                    case "ANY":
                        search.setMethod(new SearchAny());
                        search.searchPeople(invertedIndex, allPeople);
                        return true;
                    case "NONE":
                        search.setMethod(new SearchNone());
                        search.searchPeople(invertedIndex, allPeople);
                        return true;
                    default:
                        return true;
                }
            case "2":
                printAllPeople(allPeople);
                return true;
            case "0":
                System.out.println("Bye!");
                return false;
            default:
                System.out.println("Incorrect option! Try again.");
                return true;
        }
    }


    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
//        System.out.print(">");
        return scanner.nextLine();
    }


    public static void printAllPeople(List<String> allPeople) {
        System.out.println("=== List of people ===");
        allPeople.forEach(System.out::println);
    }
}
