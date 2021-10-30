import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson2 {
    public static void fromTxtToJason(String incoming, String outgoing) {
        Pattern pattern = Pattern.compile("(^\\d\\d$)|(^\\d$)");
        List<User> usersArrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(incoming));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outgoing)))
        {
            String line;
            String [] lineInArray;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                User user = new User();
                lineInArray = line.split(" ");
                if (lineInArray.length < 2) {
                    continue;
                }
                Matcher matcher = pattern.matcher(lineInArray[1]);
                if (matcher.find() == false) {
                    continue;
                }
                user.setName(lineInArray[0]);
                user.setAge(Integer.valueOf(lineInArray[1]));

                if (counter == 0) {
                    writer.write("[\n");
                    writer.write(user.toString());
                } else {
                    writer.write(",\n" + user.toString());
                }
                counter++;
            }
            writer.write("\n]");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\t{\n" +
                "\t\t\"name\": " + "\"" + name + "\",\n" +
                "\t\t\"age\":" + "" + age + "\n" +
                "\t}";
    }
}
