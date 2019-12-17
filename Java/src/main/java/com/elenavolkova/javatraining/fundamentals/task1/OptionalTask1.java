package com.elenavolkova.javatraining.fundamentals.task1;

import java.util.*;

public class OptionalTask1
{
    private static ArrayList<String> inputNumbers = new ArrayList<>();


    private static void input()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter numbers (integer value only excluding zero). For the exit press 'q'");

        while (scanner.hasNext() && !scanner.hasNext("q"))
        {
            String str = scanner.next().replaceFirst("^[0-]*", "");
            if (!str.matches("\\d*") || str.isEmpty())
            {
                System.out.println("Input error: integer value only excluding zero. Try again.");
                continue;
            }
            inputNumbers.add(str);
        }
    }

    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public static void findShortestAndLongestNumber()
    {
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        input();
        if (!inputNumbers.isEmpty())
        {
            String max = inputNumbers.get(0);
            String min = max;
            for (String s : inputNumbers)
            {
                if (s.length() >= max.length())
                {
                    max = s;
                }
                else
                {
                    min = s;
                }
            }
            System.out.println("number = " + max + " maxLength = " + max.length());
            System.out.println("number = " + min + " minLength = " + min.length());
        }
    }
    //*2. Вывести числа в порядке возрастания (убывания) значений их длины.
    public static void findAscendingOrDescendingLength()
    {

    }

    //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
    public static void compareLengthWithAverage()
    {
        System.out.println("3. Вывести на консоль те числа," +
                              " длина которых меньше (больше) средней длины по всем числам, а также длину.");
        input();
        int totalLength = 0;
        for (String s : inputNumbers)
        {
            totalLength += s.length();
        }
        int average = totalLength / inputNumbers.size();

        System.out.println("AverageLength = " + average);
        for (String s : inputNumbers)
        {
            if (s.length() < average)
            {
                System.out.println("Number = " + s + ", (length < average: (" + s.length() + " < " + average + ")");
            }

            else if (s.length() > average)
            {
                System.out.println("Number = " + s + ", (length > average: (" + s.length() + " > " + average + ")");
            }
            else
            {
                System.out.println("Number = " + s + ", (length = average: (" + s.length() + " = " + average + ")");
            }
        }
    }

    //4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
    private static int amountOfUniqueDigits (String number)
    {
        int[] digits = new int[10];
        for (int i = 0; i < number.length(); i++)
        {
            int symbol = Character.getNumericValue(number.charAt(i));
            if (digits[symbol] == 0)
            {
                digits[symbol] = 1; //unique digit
            }
            else if (digits[symbol] == 1)
            {
                digits[symbol] = 2;
            }
        }
        int counter = 0;
        for (int i = 0; i < digits.length; i++)
        {
            if (digits[i] == 1)
            {
                counter++;
            }
        }
        return counter;
    }

    public static void findMinimumOfUniqueDigits()
    {
        System.out.println("4. Найти число, в котором количество различных цифр минимально." +
                            " Если таких чисел несколько, найти первое из них.");
        input();
        int minLength = amountOfUniqueDigits(inputNumbers.get(0));
        int numberIndex = 0;
        int currentLength = 0;
        while (numberIndex < inputNumbers.size())
        {
            String number = inputNumbers.get(numberIndex);
            currentLength = amountOfUniqueDigits(number);
            if (currentLength <= minLength)
            {
                minLength = currentLength;
            }
            numberIndex++;
        }
        if (currentLength != 0)
        {
            System.out.println("number " + inputNumbers.get(numberIndex - 1));
        }
        else
        {
            System.out.println("No numbers matching the condition" );
        }
    }

    //5.  Найти количество чисел, содержащих только четные цифры,
    // а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
    public static void findEvenOrOddDigits()
    {
        System.out.println("5. Найти количество чисел, содержащих только четные цифры," +
                            " а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");
        input();
        int evenDigit;
        int oddDigit;
        int evenNumber = 0;
        int oddNumber = 0;
        for (int i = 0; i < inputNumbers.size(); i++)
        {
            evenDigit = 0;
            oddDigit = 0;
            String str = inputNumbers.get(i);
            for (int j = 0; j < str.length(); j++)
            {
                int symbol = Character.getNumericValue(str.charAt(j));
                if (symbol % 2 == 0)
                {
                    evenDigit++;
                }
                else
                {
                    oddDigit++;
                }
            }
            if (evenDigit == str.length())
            {
                evenNumber++;
            }
            else if (evenDigit == oddDigit)
            {
                oddNumber++;
            }
        }
        System.out.println("even amount = " + evenNumber);
        System.out.println("odd=even amount = " + oddNumber);
    }

    //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public static void findDigitsInAscendingOrder()
    {
        System.out.println("6. Найти число, цифры в котором идут в строгом порядке возрастания." +
                            " Если таких чисел несколько, найти первое из них.");
        input();
        for (int i = 0; i < inputNumbers.size(); i++)
        {
            boolean res = false;
            String number = inputNumbers.get(i);
            for (int first = 0; first < number.length()-1; first+=2)
            {
                int mid;
                int last;
                if (first == number.length()-2) //для четных чисел
                {
                   mid = first;
                   if (!(number.charAt(first) < number.charAt(mid)))
                   {
                       break;
                   }
                    res = true;
                }
                else
                {
                    mid = first + 1;
                    last = mid + 1;
                    if (!(number.charAt(first) < number.charAt(mid) && number.charAt(mid) < number.charAt(last)))
                    {
                        break;
                    }
                    res = true;
                }
            }
            if (res)
            {
                System.out.println(inputNumbers.get(i));
            }
        }
    }

    //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    public static void findOnlyUniqueDigits()
    {
        System.out.println("7. Найти число, состоящее только из различных цифр." +
                            " Если таких чисел несколько, найти первое из них.");
        input();
        for (int i = 0; i < inputNumbers.size(); i++)
        {
            String num = inputNumbers.get(i);
            int uniqueDigitsAmount = amountOfUniqueDigits(num);
            if (num.length() == uniqueDigitsAmount)
            {
                System.out.println(inputNumbers.get(i));
            }
        }
    }
}

































