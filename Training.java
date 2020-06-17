import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        boolean b = false;
        if (weekday == false && vacation == false) {
            b = true;
        } else if (weekday == true && vacation == false) {
            b = false;
        } else if (weekday == false && vacation == true) {
            b = true;
        }
        return b;
    }

    public static int sumDouble(int a, int b) {
        if (a == b) {
            return (a + b) * 2;
        } else {
            return a + b;
        }
    }

    public static String altPairs(String str) {
        StringBuilder x = new StringBuilder();
        int y = 0;
        for (int i = 0; i < str.length() - 1;) {
            if (i % 2 == 0) {
                x.append(str.charAt(i));
                x.append(str.charAt(i + 1));
                i += 4;
            }
        }
        if (str.length() % 2 != 0) {
            x.append(str.charAt(str.length() - 1));
        }
        String string = new String(x);
        return string;
    }

    public static void myMethod(String string) {
        String[] array = string.split("\n"); // делим строку на подсторки
        String[] inputAction = array[0].split(" ");  // делим array[0] для действий
        int n = Integer.parseInt(inputAction[0]); // n кол-во столбцов в матрице
        int m = Integer.parseInt(inputAction[1]); // m кол-во строк в матрице
        int k = Integer.parseInt(inputAction[2]); // кол-во запросов
        int[][] matrixArray = new int [n][m]; // декларирование 2х массива
        List<String> list = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < n; i++) { // заполнение массива
            String[] tmp = list.get(i).split(" ");
            for (int j = 0; j < m; j++) {
                matrixArray[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = list.size() - k; i < list.size(); i++) {
            String[] strings = list.get(i).split(" ");
            String f = strings[0];
            int a = Integer.parseInt(strings[1]) - 1;
            int b = Integer.parseInt(strings[2]) - 1;

            switch (f) {
                case "g":
                    System.out.println(matrixArray[a][b]);
                    break;
                case "c":
                    for (int j = 0; j < n; j++) {
                        for (int l = 0; l < m; l++) {
                            int tmp = matrixArray[j][a];
                            matrixArray[j][a] = matrixArray[j][b];
                            matrixArray[j][b] = tmp;
                            continue;
                        }
                    }

                    break;
                case "r":
                    int[] arr = matrixArray[a];
                    int[] arr2 = matrixArray[b];
                    matrixArray[b] = arr;
                    matrixArray[a] = arr2;
                    break;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(sleepIn(false, true));
        System.out.println(sleepIn(true, false));
        System.out.println(sleepIn(false, true));
        System.out.println(); // разделил для читаемости вывода

        System.out.println(sumDouble(1,2));
        System.out.println(sumDouble(3, 2));
        System.out.println(sumDouble(2, 2));
        System.out.println();

        System.out.println(altPairs("kitten"));
        System.out.println(altPairs("Chocolate"));
        System.out.println(altPairs("CodingHorror"));
        System.out.println();

        String x = "3 3 5\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "7 8 9\n" +
                "g 3 2\n" +
                "r 3 2\n" +
                "c 2 3\n" +
                "g 2 2\n" +
                "g 3 2";
        myMethod(x);

        String s = "2 3 3\n" +
                "1 2 4\n" +
                "3 1 5\n" +
                "c 2 1\n" +
                "r 1 2\n" +
                "g 1 3";
        myMethod(s);
        System.out.println();

    }
}
