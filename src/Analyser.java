import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
//Fully DEVED By AbrASM1

public class Analyser {
    //verifies word if is in Language 
    private static List<String> generateWords() {
        int max_length = 12; // for performance keep low numbers 

        List<String> words = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        words.add("S");
        visited.add("S");

        for (int i = 0; i < max_length; i++) {
            List<String> new_words = new ArrayList<>();
            for (String word : words) {
                if (word.length() <= max_length) {
                    if (word.equals("S") || word.contains("A")) { // Start Terminals

                        String new_word = word.replaceFirst("S", "A");
                        if (!visited.contains(new_word)) {
                            new_words.add(new_word);
                            visited.add(new_word);
                        }
                    }
                                        /*here you add the none terminals and thier possibilities 
                     * like
                     * if (word.contains("YOUR LETTER OR WORD")) { 
                        String newWord1 = word.replaceFirst("NON TERMINAL", "THE WORD");
                        if (!visited.contains(newWord1)) {
                            newWords.add(newWord1);
                            visited.add(newWord1);
                        }
                        String newWord2 = word.replaceFirst("....", "...");
                        if (!visited.contains(newWord2)) {
                            newWords.add(newWord2);
                            visited.add(newWord2);
                        }
                        String newWord3 = word.replaceFirst(".....", "......;");
                        if (!visited.contains(newWord3)) {
                            newWords.add(newWord3);
                            visited.add(newWord3);
                        }
                        ect
                    }
                     */
                    if (word.contains("A")) {
                        String new_word_1 = word.replaceFirst("A", "aAaa");
                        if (!visited.contains(new_word_1)) {
                            new_words.add(new_word_1);
                            visited.add(new_word_1);
                        }
                        String new_word_2 = word.replaceFirst("A", "bbAb");
                        if (!visited.contains(new_word_2)) {
                            new_words.add(new_word_2);
                            visited.add(new_word_2);
                        }
                        String new_word_3 = word.replaceFirst("A", "c");
                        if (!visited.contains(new_word_3)) {
                            new_words.add(new_word_3);
                            visited.add(new_word_3);
                        }
                    }
                }
            }
            words.addAll(new_words);
        }

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.contains("A")) {
                words.set(i, word.replace("A", ""));
            }
            if (word.contains("S")) {
                words.set(i, word.replace("S", ""));
            }
        }

        List<String> non_empty_words = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                non_empty_words.add(word);
            }
        }
        return non_empty_words;
    }
    // checker
    private static boolean belongsToLanguage(String word) {
        List<String> words = generateWords();
        return words.contains(word);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check if it belongs to the language: ");
        String word = scanner.nextLine();
        scanner.close();

        if (belongsToLanguage(word)) {
            System.out.println("The word belongs to the language.");
        } else {
            System.out.println("The word does not belong to the language.");
        }
    }
}
