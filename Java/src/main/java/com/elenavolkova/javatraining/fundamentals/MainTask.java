package com.elenavolkova.javatraining.fundamentals;
import java.time.DateTimeException;
import java.time.Month;
import java.util.Random;
import java.util.Scanner;

public class MainTask
{
    static Scanner scanner = new Scanner(System.in);

    //  1. Приветствовать любого пользователя при вводе его имени через командную строку.
    public static void greetingOutput()
    {
        System.out.println("Please, enter your name: ");
        System.out.println("Hello, " + scanner.nextLine() + "!");
    }

    //  2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
    public static void reverseOutput()
    {
        System.out.println("Please, enter some text or numbers: ");
        char[] data = scanner.nextLine().toCharArray();
        for (int i = data.length - 1; i >= 0; i--)
        {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //  3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
    public  static  void numbersOutput()
    {
        int size = 10;
        int[] intArray = new int[size];
        Random random = new Random();
        System.out.println("Print, Println: ");
        for (int i=0; i < intArray.length; i++)
        {
            intArray[i] = random.nextInt(100);
            System.out.print(intArray[i] + " " );
        }
        System.out.println("\n");
        for (int e : intArray)
        {
            System.out.println(e);
        }
    }

    // 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму
    // (произведение) и вывести результат на консоль.
    public static void sumAndProduct()
    {
        int sum = 0;
        int product = 1;
        System.out.println("Please, enter numbers (integer value only). For the total result press 'q':");
        while (scanner.hasNext())
        {
            if (scanner.hasNextInt())
            {
                int number = scanner.nextInt();
                sum += number;
                product *= number;
            }
            else
            {
                if (scanner.next().equals("q")) {break;}
                System.out.println("saveInput error");
                sumAndProduct();
                return;
            }
        }
        System.out.println("Sum of numbers = " + sum + ", product = "  + product);
    }

    //5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего
    // данному числу. Осуществить проверку корректности ввода чисел.
    public static void dayOfMonth()
    {
        System.out.println("Please, enter a number between 1-12:");
        try
        {
            if (scanner.hasNextInt())
            {
                int number = scanner.nextInt();
                System.out.println(Month.of(number));

            }
        }
        catch (DateTimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
