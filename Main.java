package ivan.hw5;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rnd = new Random();
        String[][] matrix = new String[10][10];
        int count = 0;

        //1
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //1.3
                if (count % 3 == 2) {
                    matrix[i][j] = randomDouble(rnd);
                } else {
                    //1.1
                    matrix[i][j] = randomString(rnd);
                }
                count++;
            }
        }

        //4
        System.out.println("Исходная матрица:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }

        //2
        String[] mainDiag = new String[10];
        String[] sideDiag = new String[10];
        for (int i = 0; i < 10; i++) {
            mainDiag[i] = matrix[i][i];
            sideDiag[i] = matrix[i][9 - i];
        }

        System.out.println();
        System.out.print("Главная диагональ: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(mainDiag[i] + " ");
        }
        System.out.println();

        System.out.print("Побочная диагональ: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(sideDiag[i] + " ");
        }
        System.out.println();

        boolean same = true;
        for (int i = 0; i < 10; i++) {
            if (!mainDiag[i].equals(sideDiag[i])) {
                same = false;
                break;
            }
        }
        System.out.println("Диагонали одинаковые? " + same);

        //2.1
        String[] diagArray = new String[20];
        for (int i = 0; i < 10; i++) {
            diagArray[i] = mainDiag[i];
            diagArray[i + 10] = sideDiag[i];
        }

        //3
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[20];
        int numbersCount = 0;

        for (int i = 0; i < diagArray.length; i++) {
            String s = diagArray[i];
            //3.2
            if (isDouble(s)) {
                double d = Double.parseDouble(s);
                numbers[numbersCount] = myRound(d);
                numbersCount++;
            } else {
                //3.1
                sb.append(s.substring(1, 4));
                sb.append(", ");
            }
        }

        //3.1
        System.out.println();
        System.out.println("Строки (символы 2-4):");
        String out = sb.toString();
        if (out.length() > 2) {
            out = out.substring(0, out.length() - 2);
        }
        System.out.println(out);

        //3.2
        System.out.println();
        System.out.println("Округлённые числа:");
        for (int i = 0; i < numbersCount; i++) {
            System.out.print(numbers[i]);
            if (i < numbersCount - 1) {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    //1.2
    static String randomString(Random rnd) {
        String s = "";
        s = s + (char) ('A' + rnd.nextInt(26));
        for (int i = 0; i < 6; i++) {
            s = s + (char) ('a' + rnd.nextInt(26));
        }
        return s;
    }

    //1.2 / 1.3
    static String randomDouble(Random rnd) {
        double d = rnd.nextDouble() * 2 - 1;
        String s = String.valueOf(d);
        if (s.length() > 7) {
            s = s.substring(0, 7);
        }
        while (s.length() < 7) {
            s = s + "0";
        }
        return s;
    }

    static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //3.2
    static int myRound(double d) {
        int cel = (int) d;
        double drob = d - cel;
        if (drob < 0) {
            drob = -drob;
        }
        if (drob >= 0.7) {
            if (d >= 0) {
                return cel + 1;
            } else {
                return cel;
            }
        } else {
            return cel;
        }
    }
}