import java.util.*;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert text to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation such as periods and commas
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split into words using whitespace
        String[] words = cleanedText.split("\\s+");

        // Stop-word list
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // HashMap to store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            // Skip empty words
            if (word.isEmpty()) {
                continue;
            }

            // Skip stop words
            if (stopWords.contains(word)) {
                continue;
            }

            // Increase frequency
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        entries.sort((entry1, entry2) ->
                entry2.getValue().compareTo(entry1.getValue()));

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}