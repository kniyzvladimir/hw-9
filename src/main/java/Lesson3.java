import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lesson3 {
    public static void wordRepetitionRate (String incomingFile) {
        ArrayList<String> words = new ArrayList<>();
        Set<String> setIndicator = new HashSet<>();
        ArrayList<String> uniqueWords = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(incomingFile))){

            String line;
            while ((line = reader.readLine()) != null) {
                String [] array = line.split(" ");
                for (String word : array) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int size = 0;
        for (int i = 0; i < words.size(); i++) {
            setIndicator.add(words.get(i));
            if (setIndicator.size() > size) {
                uniqueWords.add(words.get(i));
                size++;
            }
        }

        List <WordCount> result = new ArrayList<>(size);

        for (int i = 0; i < uniqueWords.size(); i++) {
            int count = 0;
            for (String word : words) {
                if (uniqueWords.get(i).equals(word)) {
                    count++;
                }
            }
            WordCount wordCount = new WordCount(uniqueWords.get(i), count);
            result.add(wordCount);
        }

        Collections.sort(result);
        for (WordCount res : result) {
            System.out.println(res);
        }
    }
}

class WordCount implements Comparable<WordCount> {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + " " + count;
    }


    @Override
    public int compareTo(WordCount wordCount) {
        if (this.count == wordCount.count){
            return 0;
        } else if (this.count < wordCount.count) {
            return 1;
        } else {
            return -1;
        }
    }
}