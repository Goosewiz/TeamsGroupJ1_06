package gusev.java23.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class DoubleStreamProcessor {
    public static DoubleStream createDoubleStream(double[] array) {
        DoubleStream ds = Arrays.stream(array);
        return ds;
    }

    public static long countZeros(DoubleStream ds) {
        long answer = ds.filter(i -> i == 0.0)
                .count();
        return answer;
    }

    public static boolean hasDouble(DoubleStream ds) {
        boolean answer = ds.anyMatch(i -> i != (int) i);
        return answer;
    }

    public static Double maxRange(DoubleStream ds, DoubleStream ds2) {
        Double answer = null;
        OptionalDouble answerMax = ds.max();
        OptionalDouble answerMin = ds2.min();
        if (answerMax.isPresent() && answerMin.isPresent())
            answer = Math.abs(answerMax.getAsDouble() - answerMin.getAsDouble());
        return answer;
    }

    public static double[] biggerThanLimit(DoubleStream ds, double limit) {
        double[] answer = ds.filter(i -> i > limit)
                .toArray();
        return answer;
    }
    public static Double longestString(DoubleStream ds) {
        double[] temp = ds.toArray();
        if (temp.length == 0)
            return null;
        String[] answer = new String[temp.length];
        for (int i = 0; i<temp.length; i++)
            answer[i] = Double.toString(temp[i]);
        Stream<String> stringStream = Arrays.stream(answer);
        String result = stringStream.max(Comparator.comparingInt(String::length))
                .get();
        return Double.parseDouble(result);
    }
}
