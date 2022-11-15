package HomeworkTwo;

// Написать программу, показывающую последовательность действий для игры “Ханойская башня”
// Реализовать алгоритм сортировки вставками
import java.util.Scanner;

public class HanoiTower {
    static int count=0;
    /**
     * метод рекурсивное решения
     * */
    private static void hanoi(int n, int from, int to) {
        int tmp;
        if (n==1) {
            count++;
            System.out.println("перейти от "+from+" к "+to);
        }
        else {
            tmp=foo(from,to);
            hanoi(n-1,from,tmp);
            System.out.println("перейти от "+from+" к "+to);
            count++;
            hanoi(n-1,tmp,to);
        }
    }
    private static int foo(int a, int b) {
        return (10-(a+b));
    }
    public static void main(String [] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n,from,to;
            System.out.print("Введите количество колец = ");
            n=in.nextInt();
            System.out.print("от = ");
            from=in.nextInt();
            System.out.print("к = ");
            to=in.nextInt();
            hanoi(n,from,to);
        }
        System.out.println("считать количество шагов = "+count);
    }
}