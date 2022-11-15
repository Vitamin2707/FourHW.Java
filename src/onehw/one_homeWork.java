// Написать программу вычисления n-ого треугольного числа.
package onehw;

import java.util.Scanner;
public class one_homeWork{
    public static void main(String[] args){
        try (Scanner number = new Scanner(System.in)) {
            System.out.println("Введите число n, для вычисления n-ого треугольного числа:");

            int n = number.nextInt();

            if (n < 0) {
                System.out.println("Для отрицательных чисел треугольное число посчитать не получится.");
            } else {
                System.out.println("Для n = " + n + " треугольное число = " + triangularNumber(n));
            }
        }
    }

    public static int triangularNumber(int n) {

        return ((n * (n + 1)) / 2);
    }
}