import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson1 {

    public static void printValidNumber(String file) {
        Pattern pattern1 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
        Pattern pattern2 = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);
                if (matcher1.find() || matcher2.find()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
