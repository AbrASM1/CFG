import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
//FULLY DEVED by AbrASM1
public class CompleteProject {

    // Generates the language words
    private static List<String> generateWords(int k) {
        List<String> words = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        words.add("S");
        visited.add("S");

        for (int i = 0; i < k; i++) {
            List<String> newWords = new ArrayList<>();
            for (String word : words) {
                if (word.length() <= k) {
                    if (word.equals("S") || word.contains("A")) {// start Non terminal
                        String newWord = word.replaceFirst("S", "A");
                        if (!visited.contains(newWord)) {
                            newWords.add(newWord);
                            visited.add(newWord);
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
                        String newWord1 = word.replaceFirst("A", "aAaa");
                        if (!visited.contains(newWord1)) {
                            newWords.add(newWord1);
                            visited.add(newWord1);
                        }
                        String newWord2 = word.replaceFirst("A", "bbAb");
                        if (!visited.contains(newWord2)) {
                            newWords.add(newWord2);
                            visited.add(newWord2);
                        }
                        String newWord3 = word.replaceFirst("A", "c");
                        if (!visited.contains(newWord3)) {
                            newWords.add(newWord3);
                            visited.add(newWord3);
                        }
                    }
                }
            }
            words.addAll(newWords);
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

        List<String> nonEmptyWords = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                nonEmptyWords.add(word);
            }
        }
        return nonEmptyWords;
    }

    // Displays the language words
    private static void displayLanguage(int k) {
        List<String> words = generateWords(k);

        System.out.println("Words of length up to " + k + ":");
        System.out.println("Epsilon");
        if (!words.isEmpty()) {
            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    // Displays the reversed language words
    private static void displayReversedLanguage(int k) {
        List<String> words = generateWords(k);
        for (int i = 0; i < words.size(); i++) {
            words.set(i, new StringBuilder(words.get(i)).reverse().toString());
        }

        System.out.println("Words of length up to " + k + " (Reversed):");
        System.out.println("Epsilon");
        if (!words.isEmpty()) {
            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    // Generates the language words to the power of n
    private static List<String> generatePowerWords(List<String> words, int n) {
        if (n == 0) {
            return words;
        }
        List<String> powerWords = new ArrayList<>(words);
        for (int i = 1; i < n; i++) {
            List<String> tempWords = new ArrayList<>(powerWords);
            for (String word : words) {
                for (String tempWord : tempWords) {
                    powerWords.add(word + tempWord);
                }
            }
        }
        return powerWords;
    }

    // Displays the language words up to the power of n
    private static void displayPowerLanguage(int k, int n) {
        List<String> words = generateWords(k);

        System.out.println("Words of length up to " + k + ":");
        System.out.println("Epsilon");
        if (!words.isEmpty()) {
            for (String word : words) {
                System.out.println(word);
            }
        }

        List<String> powerWords = generatePowerWords(words, n);

        System.out.println("Words of power " + n + ":");
        System.out.println("Epsilon");
        if (!words.isEmpty()) {
            for (String word : powerWords) {
                System.out.println(word);
            }
        }
    }

    // Checks if a word belongs to the language
    private static boolean belongsToLanguage(String word) {
        List<String> words = generateWords(10);
        return words.contains(word);
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the question number:");
        System.out.println("1. Generate the language words");
        System.out.println("2. Generate the mirrored language");
        System.out.println("3. Generate the language to the power of n");
        System.out.println("4. Syntax analyzer for a given word with respect to L(G)");
        int question = scanner.nextInt();

        switch (question) {
            case 1:
                System.out.println("Enter the value of k:");
                int k1 = scanner.nextInt();
                displayLanguage(k1);
                break;
            case 2:
                System.out.println("Enter the value of k:");
                int k2 = scanner.nextInt();
                displayReversedLanguage(k2);
                break;
            case 3:
                System.out.println("Enter the value of k:");
                int k3 = scanner.nextInt();
                System.out.println("Enter the value of n:");
                int n3 = scanner.nextInt();
                displayPowerLanguage(k3, n3);
                break;
            case 4:
                scanner.nextLine(); // Clear the newline character
                System.out.println("Enter a word to check if it belongs to the language:");
                String word = scanner.nextLine();
                if (belongsToLanguage(word)) {
                    System.out.println("The word belongs to the language.");
                } else {
                    System.out.println("The word does not belong to the language.");
                }
                break;
            default:
                System.out.println("Invalid question.");
                break;
        }

        scanner.close();
    }
}
