package Task3.Test;

import Task3.Main;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestTask3 {

    private double[][] testMatrix1 = {{1.0, -2.0, 3.5}, {4.2, 5.0, -6.9}};
    private double[][] testMatrix2 = {{0, 2, -3.5}, {4, 128.333, 10}, {-12, 14, 555.555}};
    private double[][] testMatrix3 = {{-2, 14.5}, {12.8, 0}, {-6.2, -9.8}, {15, 14.2}};

    @Test()
    public void testExtremum1() {
        double[] result = Main.findExtremumMatrixValues(testMatrix1);
        double min = result[0];
        double max = result[1];
        assertEquals(-6.9, min, 0.001);
        assertEquals(5, max, 0.001);
    }

    @Test()
    public void testExtremum2() {
        double[] result = Main.findExtremumMatrixValues(testMatrix2);
        double min = result[0];
        double max = result[1];
        assertEquals(-12, min, 0.001);
        assertEquals(555.555, max, 0.001);
    }

    @Test()
    public void testExtremum3() {
        double[] result = Main.findExtremumMatrixValues(testMatrix3);
        double min = result[0];
        double max = result[1];
        assertEquals(-9.8, min, 0.001);
        assertEquals(15, max, 0.001);
    }

    @Test()
    public void testAverages1() {
        double[] result = Main.findAveragesMatrixValues(testMatrix1);
        double arithmetic = result[0];
        double geometric = result[1];
        assertEquals(1.20, arithmetic, 0.01);
        assertEquals(5.64, geometric, 0.01);
    }

    @Test()
    public void testAverages2() {
        double[] result = Main.findAveragesMatrixValues(testMatrix2);
        double arithmetic = result[0];
        double geometric = result[1];
        assertEquals(77.60, arithmetic, 0.01);
        assertEquals(0.00, geometric, 0.01);
    }

    @Test()
    public void testAverages3() {
        double[] result = Main.findAveragesMatrixValues(testMatrix3);
        double arithmetic = result[0];
        double geometric = result[1];
        assertEquals(2.41, arithmetic, 0.01);
        assertEquals(0.00, geometric, 0.01);
    }

    @Test()
    public void testLocalExtremum1() {
        String[] extremums = Main.writeLocalExtremumsToString(testMatrix1);
        double min = Double.parseDouble(extremums[0]);
        double max = Double.parseDouble(extremums[3]);
        assertEquals(-2, min, 0.01);
        assertEquals(5, max, 0.01);
    }

    @Test()
    public void testLocalExtremum2() {
        String[] extremums = Main.writeLocalExtremumsToString(testMatrix2);
        double max = Double.parseDouble(extremums[3]);
        if (Double.parseDouble(extremums[1]) == -1) {
            assertEquals(-1, Double.parseDouble(extremums[1]), 0.01);
        }
        assertEquals(2, max, 0.01);
    }

    @Test()
    public void testLocalExtremum3() {
        String[] extremums = Main.writeLocalExtremumsToString(testMatrix3);
        if (Double.parseDouble(extremums[1]) == -1) {
            assertEquals(-1, Double.parseDouble(extremums[1]), 0.01);
        } else {
            assertEquals(0, Double.parseDouble(extremums[0]), 0.01);
        }
        if (Double.parseDouble(extremums[4]) == -1) {
            assertEquals(-1, Double.parseDouble(extremums[4]), 0.01);
        } else {
            assertEquals(0, Double.parseDouble(extremums[0]), 0.01);
        }
    }

    @Test()
    public void testTransposeMatrix1() {
        double[][] result = {{1.0, 4.20}, {-2, 5}, {3.5, -6.9}};
        assert (Arrays.deepEquals(result, Main.transposeMatrix(testMatrix1)));
    }

    @Test()
    public void testTransposeMatrix2() {
        double[][] result = {{0, 4, -12}, {2, 128.333, 14.00}, {-3.5, 10, 555.555}};
        assert (Arrays.deepEquals(result, Main.transposeMatrix(testMatrix2)));
    }

    @Test()
    public void testTransposeMatrix3() {
        double[][] result = {{-2.0, 12.80, -6.2, 15}, {14.50, 0.0, -9.8, 14.20}};
        assert (Arrays.deepEquals(result, Main.transposeMatrix(testMatrix3)));
    }
}
