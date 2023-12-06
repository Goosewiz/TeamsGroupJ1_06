package gusev.java23.task1;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStreamProcessorTest {

    @Test
    void zeroArray() {
        double[] input = new double[]{};
        DoubleStream ds = DoubleStreamProcessor.createDoubleStream(input);
        long answer = DoubleStreamProcessor.countZeros(ds);
        assertEquals(answer, 0, "countZeros");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        boolean answerB = DoubleStreamProcessor.hasDouble(ds);
        assertEquals(answerB, false, "hasDouble");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        DoubleStream ds2 = DoubleStreamProcessor.createDoubleStream(input);
        Double answerD = DoubleStreamProcessor.maxRange(ds, ds2);
        assertEquals(answerD, null, "maxRange");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        double[] answerDD = DoubleStreamProcessor.biggerThanLimit(ds, 0);
        assertEquals(answerDD.length, 0, "biggerThanLimit");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        Double answerS = DoubleStreamProcessor.longestString(ds);
        assertEquals(answerS, null, "longestString");
    }

    @Test
    void threeArray() {
        double[] input = new double[]{1, 1, 1};
        DoubleStream ds = DoubleStreamProcessor.createDoubleStream(input);
        long answer = DoubleStreamProcessor.countZeros(ds);
        assertEquals(answer, 0, "countZeros");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        boolean answerB = DoubleStreamProcessor.hasDouble(ds);
        assertEquals(answerB, false, "hasDouble");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        DoubleStream ds2 = DoubleStreamProcessor.createDoubleStream(input);
        Double answerD = DoubleStreamProcessor.maxRange(ds, ds2);
        assertEquals(answerD, 0, "maxRange");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        double[] answerDD = DoubleStreamProcessor.biggerThanLimit(ds, 0);
        //все значения больше limit
        assertEquals(answerDD.length, 3, "biggerThanLimit");
        assertEquals(answerDD[0], 1, "biggerThanLimit");
        assertEquals(answerDD[1], 1, "biggerThanLimit");
        assertEquals(answerDD[2], 1, "biggerThanLimit");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        Double answerS = DoubleStreamProcessor.longestString(ds);
        assertEquals(answerS, 1.0, "longestString");
    }

    @Test
    void fiveArray() {
        double[] input = new double[]{0.02, 0.4, 0.00006, 0.84, 0.99};
        DoubleStream ds = DoubleStreamProcessor.createDoubleStream(input);
        long answer = DoubleStreamProcessor.countZeros(ds);
        assertEquals(answer, 0, "countZeros");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        boolean answerB = DoubleStreamProcessor.hasDouble(ds);
        assertEquals(answerB, true, "hasDouble");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        DoubleStream ds2 = DoubleStreamProcessor.createDoubleStream(input);
        Double answerD = DoubleStreamProcessor.maxRange(ds, ds2);
        assertEquals(answerD, 0.98994, "maxRange");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        double[] answerDD = DoubleStreamProcessor.biggerThanLimit(ds, 0.5);
        //часть значений больше limit
        assertEquals(answerDD.length, 2, "biggerThanLimit");
        assertEquals(answerDD[0], 0.84, "biggerThanLimit");
        assertEquals(answerDD[1], 0.99, "biggerThanLimit");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        Double answerS = DoubleStreamProcessor.longestString(ds);
        assertEquals(answerS, 0.00006, "longestString");
    }

    @Test
    void nineteenArray() {
        double[] input = new double[] {0, 0, 0, 0, 0, 3, 4, -3, 12345.0987654321, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Random rand = new Random(1);
        for (int i = 0; i<10; i++)
            input[i+9] = rand.nextDouble();
        DoubleStream ds = DoubleStreamProcessor.createDoubleStream(input);
        long answer = DoubleStreamProcessor.countZeros(ds);
        assertEquals(answer, 5, "countZeros");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        boolean answerB = DoubleStreamProcessor.hasDouble(ds);
        assertEquals(answerB, true, "hasDouble");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        DoubleStream ds2 = DoubleStreamProcessor.createDoubleStream(input);
        Double answerD = DoubleStreamProcessor.maxRange(ds, ds2);
        assertEquals(answerD, 12348.0987654321, "maxRange");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        double[] answerDD = DoubleStreamProcessor.biggerThanLimit(ds, 12346);
        //ни одно значение не больше limit
        assertEquals(answerDD.length, 0, "biggerThanLimit");
        ds = DoubleStreamProcessor.createDoubleStream(input);
        Double answerS = DoubleStreamProcessor.longestString(ds);
        assertEquals(answerS, 0.006117182265761301, "longestString");
    }
}