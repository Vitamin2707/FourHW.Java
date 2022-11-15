package onehw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Реализовать алгоритм пирамидальной сортировки (HeapSort)
public class ohw2Tack {
    
    public ohw2Tack(List<Integer> intsInRange) {
    }

    public ohw2Tack() {
    }

    public void sort(int arr[])
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
     void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

           // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
       // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Управляющая программа 
    public static void main(String args[])
    {

//        int arr[] = {12, 11, 13, 5, 6, 7};
        int [] array = new int[10];
        int minRandom = 1;
        int maxRandom;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("введите макс элемент");
            maxRandom = scanner.nextInt();
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
            array[i] = minRandom + random.nextInt(maxRandom - minRandom + 1);
            System.out.print(array[i] + ", ");
        }

final ohw2Tack  ob = new ohw2Tack();
        ob.sort(array);

        System.out.println("Sorted array is");
        printArray(array);
    }
public static List<Integer> intsInRange(int size, int lowerBound, int upperBound)
 { 
    List<Integer> result = new ArrayList<>(); 
    for (int i = 0; i < size; i++) { 
    result.add(ThreadLocalRandom.current().nextInt(lowerBound, upperBound)); 
    } 
    return result; 
    }
public class intsInRange {
}
}