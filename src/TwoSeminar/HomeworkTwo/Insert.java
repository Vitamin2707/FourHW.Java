package HomeworkTwo;

import java.util.Random;
import java.util.Scanner;

public class Insert{
    public static void insertionSort(int[] sortArr) {
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }

    public static void main(String[] args) {
//        int[] sortArr = {45, 8, 5, 1, 25, 17};
        int count = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("введите колличество элементов");
            count= scanner.nextInt();
            int [] sortArr = new int[count];
            int minRandom;
            int maxRandom;

            System.out.println("введите минимальный элемент");
            minRandom= scanner.nextInt();
            System.out.println("введите максимальный элемент");
            maxRandom = scanner.nextInt();
            Random random = new Random(System.currentTimeMillis());

            System.out.println("Список до сортировки");

            String comma="";
            for (int i = 0; i < sortArr.length; i++) {
                sortArr[i] = minRandom + random.nextInt(maxRandom - minRandom + 1);
                System.out.printf("%s%s", comma, sortArr[i]);
                // Now define comma
                comma = ",";
            }

            System.out.println("\nСписок после сортировки вставками");
            insertionSort(sortArr);
            for (int j : sortArr) {
                System.out.printf("%s ",j);
            }
        }
    }
}