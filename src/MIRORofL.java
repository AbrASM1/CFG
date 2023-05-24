import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

//Fully DEVELOPED by
// AbrASM1
public class MIRORofL {
    // Inverse L
    private static List<String> generateWords(int k) {
        List<String> words = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        words.add("S");
        visited.add("S");

        for (int i = 0; i < k; i++) {
            List<String> newWords = new ArrayList<>();
            for (String word : words) {
                if (word.length() <= k) {
                    if (word.equals("S") || word.contains("A")) { // PUT your none terminals here or add another checker
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
            words.set(i, new StringBuilder(words.get(i)).reverse().toString());
        }

        List<String> nonEmptyWords = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                nonEmptyWords.add(word);
            }
        }
        return nonEmptyWords;
    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();

        displayLanguage(k);
    }
}
