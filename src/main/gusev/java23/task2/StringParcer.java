package gusev.java23.task2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParcer {
    public static String getNewString(String oldString) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < oldString.length(); i++) {
            String temp = oldString.substring(i, i+1);
            if (temp.matches("[a-zA-Zа-яА-Я]"))
                newString.append(temp);
            else
                newString.append(" ");
        }
        String temp = new String(newString);
        //String[] output = oldString.split("( +)|(,)|(\\()|(\\))|(;)|(!)|(-)|(\\.)");
        String[] output = temp.split(" +");
        Stream<String> stringStream = Arrays.stream(output);
        String answer = stringStream.filter(i -> i.length()>2)
                .map(i -> i.toUpperCase())
                .sorted()
                .distinct()
                .collect(Collectors.joining(" "));
        return answer;
    }
}
