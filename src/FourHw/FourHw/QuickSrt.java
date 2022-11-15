package FourHw;



import java.util.Random;
import java.util.Scanner;

public class QuickSrt {
    public static void main(String[] args) {
        try (Scanner scanners = new Scanner(System.in)) {
            System.out.println("введите макс колличечтво элементов");
            int arrays = scanners.nextInt();
            System.out.println();
            int[] array = new int[arrays];
            int minRandom = 1;
            int maxRandom;

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("введите макс элемент");
                maxRandom = scanner.nextInt();
                System.out.println();
            }
            System.out.println("Сгенерированый массив");
            Random random = new Random(System.currentTimeMillis());
            String comma = "";
            for (int i = 0; i < array.length; i++) {
                array[i] = minRandom + random.nextInt(maxRandom - minRandom + 1);
                System.out.printf("%s%s", comma, array[i]);
                // Now define comma
                comma = ", ";

            }
            System.out.println();
            System.out.println("Отсортированный массив");
            printArray(array);
        }

    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int[] arr) {
        String comma = "";
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s%s", comma, arr[i]);
            // Now define comma
            comma = ", ";
        }
    }

    public static void quickSort(int[] sortArr, int low, int high) {
        // завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high)
            return;

        // выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        // разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border)
                i++;
            while (sortArr[j] > border)
                j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        // рекурсия для сортировки левой и правой части
        if (low < j)
            quickSort(sortArr, low, j);
        if (high > i)
            quickSort(sortArr, i, high);
    }
}