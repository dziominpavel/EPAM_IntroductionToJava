package Task3;

import java.util.Random;

import static Task3.MatrixProperties.*;

public class Main {
    public static void main(String[] args) {
        //инициализация матрицы
        double[][] matrix = new double[COUNTROWS][COUNTCOLUMNS];
        matrixInitialize(matrix, MINVALUE, MAXVALUE);

        System.out.println("Сгенерированная матрица:");
        matrixPrint(matrix);
        System.out.printf("\nМинимальный элемент матрицы:\t%.2f\n", findExtremumMatrixValues(matrix)[0]);
        System.out.printf("Максимальный элемент матрицы:\t%.2f\n", findExtremumMatrixValues(matrix)[1]);
        System.out.printf("\nСреднее арифметическое элементов матрицы:\t%.2f\n", findAveragesMatrixValues(matrix)[0]);

        double geometricAverage = findAveragesMatrixValues(matrix)[1];
        if (!Double.isNaN(geometricAverage)) {
            System.out.printf("Среднее геометрическое элементов матрицы:\t%.2f\n\n", geometricAverage);
        } else {
            System.out.println("Среднее геометрическое высчитать невозможно\n");
        }
        String[] extremums = writeLocalExtremumsToString(matrix);

        if (Integer.parseInt(extremums[1]) != -1) {
            System.out.printf("Локальный минимум %.2f  ", Double.parseDouble(extremums[0]));
            System.out.println("находится на позиции:[" + extremums[1] + "][" + extremums[2] + "]");
        } else {
            System.out.print("Локальный минимум вычислить не удалось\n");
        }
        if (Integer.parseInt(extremums[4]) != -1) {
            System.out.printf("Локальный максимум %.2f  ", Double.parseDouble(extremums[3]));
            System.out.println("находится на позиции:[" + extremums[4] + "][" + extremums[5] + "]\n");
        } else {
            System.out.print("Локальный максимум вычислить не удалось\n\n");
        }
        System.out.println("Транспонированная матрица:");
        matrixPrint(transposeMatrix(matrix));
    }

    /**
     * method initializes elements of matrix
     */
    private static void matrixInitialize(double[][] matrix, double minValue, double maxValue) {
        int countRows = matrix.length;
        int countColumns = matrix[0].length;
        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < countColumns; j++) {
                matrix[i][j] = generateValue(minValue, maxValue);
            }
        }
    }

    /**
     * method prints elements of matrix
     */
    private static void matrixPrint(double[][] matrix) {
        for (double[] rows : matrix) {
            for (double element : rows) {
                System.out.printf("%.2f\t", element);
            }
            System.out.println();
        }
    }

    /**
     * method generates random double from the specified range
     *
     * @param minValue bottom line of range
     * @param maxValue upper line of range
     * @return random number
     */
    private static double generateValue(double minValue, double maxValue) {
        if (maxValue >= minValue) {
            return new Random().nextDouble() * ((maxValue - minValue)) + minValue;
        } else {
            System.out.println("Введен не корректный диапазон для генерации чисел");
            return 0;
        }
    }

    /**
     * method finds exremums of the matrix
     *
     * @param matrix matrix where we need to find the extremum
     * @return array with length = 2; extremum[0] = min; extremum[1] = max
     */
    public static double[] findExtremumMatrixValues(double[][] matrix) {
        int countColumns = matrix[0].length;
        double min = matrix[0][0];
        double max = matrix[0][0];

        for (double[] row : matrix) {
            for (int j = 0; j < countColumns; j++) {
                if (row[j] < min) {
                    min = row[j];
                } else if (row[j] > max) {
                    max = row[j];
                }
            }
        }

        double[] extremum = new double[2];
        extremum[0] = min;
        extremum[1] = max;
        return extremum;
    }

    /**
     * method finds arithmetic and geometric averages of the matrix
     *
     * @param matrix matrix where we need to find the averages
     * @return array with length = 2; average[0] = arithmetic average; average[1] = geometric average;
     */
    public static double[] findAveragesMatrixValues(double[][] matrix) {
        int countRows = matrix.length;
        int countColumns = matrix[0].length;
        double sumElements = 0;
        double multiplicateElements = 1;

        for (double[] row : matrix) {
            for (int j = 0; j < countColumns; j++) {
                sumElements += row[j];
                multiplicateElements *= row[j];
            }
        }

        int countElements = countRows * countRows;
        double[] averages = new double[2];
        averages[0] = sumElements / countElements;
        averages[1] = Math.pow(multiplicateElements, 1.0 / countElements);
        return averages;
    }

    /**
     * method writes values and indexes of local minimum and local maximum of the matrix and return to String array
     *
     * @param matrix matrix where we need to find the local minimum and the local maximum
     * @return string array with values and indexes of the local extremums which write in format:
     * 1. localMinimumValue
     * 2. localMinimumFirstIndex
     * 3. localMinimumSecondIndex
     * 4. localMaximumValue
     * 5. localMaximumFirstIndex
     * 6. localMaximumSecondIndex
     */
    public static String[] writeLocalExtremumsToString(double[][] matrix) {
        int countRows = matrix.length;
        int countColumns = matrix[0].length - 1;
        double localMinimumValue = matrix[0][0];
        double localMaximumValue = matrix[0][0];
        int localMinimumFirstIndex = -1;
        int localMinimumSecondIndex = -1;
        int localMaximumFirstIndex = -1;
        int localMaximumSecondIndex = -1;
        boolean isFindMinimum = false;
        boolean isFindMaximum = false;

        for (int i = 0; i < countRows; i++) {
            for (int j = 1; j < countColumns; j++) {
                if (!isFindMinimum) {
                    if (isLocalMinimum(matrix[i][j - 1], matrix[i][j], matrix[i][j + 1])) {
                        localMinimumValue = matrix[i][j];
                        localMinimumFirstIndex = i;
                        localMinimumSecondIndex = j;
                        isFindMinimum = true;
                    }
                }

                if (!isFindMaximum) {
                    if (isLocalMaximum(matrix[i][j - 1], matrix[i][j], matrix[i][j + 1])) {
                        localMaximumValue = matrix[i][j];
                        localMaximumFirstIndex = i;
                        localMaximumSecondIndex = j;
                        isFindMaximum = true;
                    }
                }
            }
        }
        String[] extremums = new String[6];
        extremums[0] = String.valueOf(localMinimumValue);
        extremums[1] = String.valueOf(localMinimumFirstIndex);
        extremums[2] = String.valueOf(localMinimumSecondIndex);
        extremums[3] = String.valueOf(localMaximumValue);
        extremums[4] = String.valueOf(localMaximumFirstIndex);
        extremums[5] = String.valueOf(localMaximumSecondIndex);
        return extremums;
    }

    /**
     * method returns true if second element lower than first and third
     *
     * @param first  first element
     * @param second second element
     * @param third  third element
     * @return true if second < first && second < third
     */
    private static boolean isLocalMinimum(double first, double second, double third) {
        return second < first && second < third;
    }

    /**
     * method returns true if second element bigger than first and third
     *
     * @param first  first element
     * @param second second element
     * @param third  third element
     * @return true if second > first && second > third
     */
    private static boolean isLocalMaximum(double first, double second, double third) {
        return second > first && second > third;
    }

    /**
     * method returns transposed matrix
     *
     * @param matrix matrix which we need to transpose
     * @return transposed matrix
     */
    public static double[][] transposeMatrix(double[][] matrix) {
        int countRows = matrix.length;
        int countColumns = matrix[0].length;

        if (countRows == countColumns) {
            for (int i = 0; i < countRows; i++) {
                for (int j = i + 1; j < countColumns; j++) {
                    matrix[i][j] = matrix[i][j] - matrix[j][i];
                    matrix[j][i] = matrix[i][j] + matrix[j][i];
                    matrix[i][j] = matrix[j][i] - matrix[i][j];
                }
            }
        } else {
            double[][] newMatrix = new double[countColumns][countRows];
            for (int i = 0; i < countRows; i++) {
                for (int j = 0; j < countColumns; j++) {
                    newMatrix[j][i] = matrix[i][j];
                }
            }
            return newMatrix;
        }
        return matrix;
    }

}
