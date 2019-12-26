package com.elenavolkova.javatraining.fundamentals.task1;


import java.util.*;

public class OptionalTask1
{
    private static ArrayList<Long> inputNumbers = new ArrayList();
    //private static int position = 0;
//    public static int nextDigit(long number, int position)
//    {
//        if (position == 0)
//        {
//            return (int)number % 10;
//        }
//        number = (int)(number / Math.pow(10, position));
//        return (int)(number % 10);
//    }

    private static void input()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter numbers (integer value only excluding zero). For the exit press 'q'");

        while (scanner.hasNext() && !scanner.hasNext("q"))
        {
            try
            {
                String number = scanner.next();
                if (!number.equals("0"))
                {
                    inputNumbers.add(Long.valueOf(number));
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Input error: integer value only excluding zero. Try again.");

                continue;
            }
        }
    }
    private  static int getLength (long number)
    {
        number = Math.abs(number);
        return (int) Math.log10(number) + 1;

    }
    private static int getIndexOfMaxLength(ArrayList<Long> numbers)
    {
        if (numbers.isEmpty()) return 0;
        int maxLength = getLength(numbers.get(0));
        int maxIndex = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            int length = getLength(numbers.get(i));
            if (length > maxLength)
            {
                maxLength = length;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    private static int getIndexOfMinLength(ArrayList<Long> numbers)
    {
        if (numbers.isEmpty()) return 0;
        int minLength = 0;
        int minIndex = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            int length = getLength(numbers.get(i));
            if (length < minLength)
            {
                minLength = length;
                minIndex = i;
            }
        }
        return minIndex;
    }

//    private static void radixSort(ArrayList<Integer> input, int maxLengthOfNumber)
//    {
//        if (position == maxLengthOfNumber)
//        {
//            return;
//        }
//        ArrayList<Integer>[] counters = new ArrayList[10];
//        //инициализация массива
//        for (int i = 0; i < counters.length; i++)
//        {
//            counters[i] = new ArrayList();
//        }
//        //Проход справа налево для i разряда
//        for (int i = 0; i < input.size(); i++)
//        {
//            int length = input.get(i);
//            int digit = nextDigit(length, position);
//            counters[digit].add(length);
//
//        }
//        //перенести результат
//        input.clear();
//        for (int i = 0; i < counters.length; i++)
//        {
//            for (int j = 0; j < counters[i].size(); j++)
//            {
//                input.add(counters[i].get(j));
//            }
//        }
//        //повтор
//        position++;
//        radixSort(input, maxLengthOfNumber);
//    }


    private static void findOccurrencesOfDigits (int[] arr)
    {
        int[] counters = new int[10];
        for (int i = 0; i < arr.length; i++)
        {
            counters[arr[i]]++;
        }
    }

    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    public static void findShortestAndLongestNumber()
    {
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        input();
        if (inputNumbers.isEmpty())return;
        int maxIndex = getIndexOfMaxLength(inputNumbers);
        int minIndex = getIndexOfMinLength(inputNumbers);
        int maxLength = getLength(inputNumbers.get(maxIndex));
        int minLength = getLength(inputNumbers.get(minIndex));
        System.out.println("the longest number = " + inputNumbers.get(maxIndex) + ", its length = " + maxLength);
        System.out.println("the shortest number = " + inputNumbers.get(minIndex) + ", its length = " + minLength);
    }


    //2. Вывести числа в порядке возрастания (убывания) значений их длины.
    public static void naturalOrReverseOrderbyLength()
    {
        //Сами  чмсла не упорядочены между сосбой, только их длины
        System.out.println("2. Вывести числа в порядке возрастания (убывания) значений их длины.");
        input();
        if (inputNumbers.isEmpty())return;
        int maxLength = getLength(inputNumbers.get(getIndexOfMaxLength(inputNumbers)));
        ArrayList<Long>[] buffer = new ArrayList[maxLength + 1];
        for (int i = 0; i < buffer.length; i++)
        {
            buffer[i] = new ArrayList();
        }
        for (int i = 0; i < inputNumbers.size(); i++)
        {
            long num = inputNumbers.get(i);
            int len = getLength(inputNumbers.get(i));
            buffer[len].add(num);
        }
        System.out.println("Natural length order: ");
        for (int i = 0; i < buffer.length; i++)
        {
            for (int j = 0; j < buffer[i].size(); j++)
            {
                System.out.println(buffer[i].get(j));
            }
        }
        System.out.println("Reverse length order: ");
        for (int end = buffer.length - 1; end >=0; end--)
        {
            for (int i = 0; i < buffer[end].size(); i++)
            {
                System.out.println(buffer[end].get(i));
            }
        }
    }

    //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
    public static void compareLengthWithAverage()
    {
        //Math.max/min
        System.out.println("3. Вывести на консоль те числа," +
                              " длина которых меньше (больше) средней длины по всем числам, а также длину.");
        input();
//        int totalLength = 0;
//        for (String s : inputNumbers)
//        {
//            totalLength += s.length();
//        }
//        int average = totalLength / inputNumbers.size();
//
//        System.out.println("AverageLength = " + average);
//        for (String s : inputNumbers)
//        {
//            if (s.length() < average)
//            {
//                System.out.println("Number = " + s + ", (length < average: (" + s.length() + " < " + average + ")");
//            }
//
//            else if (s.length() > average)
//            {
//                System.out.println("Number = " + s + ", (length > average: (" + s.length() + " > " + average + ")");
//            }
//            else
//            {
//                System.out.println("Number = " + s + ", (length = average: (" + s.length() + " = " + average + ")");
//            }
//        }
    }

    //4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
//    private static int amountOfUniqueDigits (String number)
//    {
//         int[] counters = new int[10];
//        for (int i = 0; i < arr.length; i++)
//        {
//            counters[arr[i]]++;
//        }
//
//        int[] digits = new int[10];
//        int counter = 0;
//        for (int i = 0; i < number.length(); i++)
//        {
//            int symbol = Character.getNumericValue(number.charAt(i));
//            if (digits[symbol] == 0)
//            {
//                digits[symbol] = 1; //unique digit
//                counter++;
//            }
//            else
//            {
//                digits[symbol] = -1;
//                counter--;
//            }
//        }
//        int counter = 0;
//        for (int i = 0; i < digits.length; i++)
//        {
//            if (digits[i] == 1)
//            {
//                counter++;
//            }
//        }
//        return counter;
//    }

    public static void findMinimumOfUniqueDigits() //не работает
    {
        System.out.println("4. Найти число, в котором количество различных цифр минимально." +
                            " Если таких чисел несколько, найти первое из них.");
        input();
//        int minLength = amountOfUniqueDigits(inputNumbers.get(0));
//        int numberIndex = 0;
//        int currentLength = 0;
//        while (numberIndex < inputNumbers.size())
//        {
//
//            currentLength = amountOfUniqueDigits(number);
//            if (currentLength <= minLength)
//            {
//                minLength = currentLength;
//            }
//            numberIndex++;
//        }
//        if (currentLength != 0)
//        {
//            System.out.println("number " + inputNumbers.get(numberIndex - 1));
//        }
//        else
//        {
//            System.out.println("No numbers matching the condition" );
//        }
    }

    //5.  Найти количество чисел, содержащих только четные цифры,
    // а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
    //****** переписать через двоичное предстваление
    public static void findEvenOrOddDigits()
    {
        System.out.println("5. Найти количество чисел, содержащих только четные цифры," +
                            " а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");
//        input();
        long l = -6656568L;
        l = Math.abs(l);
        String s = Long.toBinaryString(l);
        if (s.endsWith("0"))
        {
            System.out.println("Четное");
        }
        else
        {
            System.out.println("Нечетное");
        }
        //Распарсить на цифры
        int size = getLength(l);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            int r = (int) l % 10;
            arr[i] = r;
            l /= 10;

        }

//        int evenDigit;
//        int oddDigit;
//        int evenNumber = 0;
//        int oddNumber = 0;
//        for (int i = 0; i < inputNumbers.size(); i++)
//        {
//            evenDigit = 0;
//            oddDigit = 0;
//            String str = inputNumbers.get(i);
//            for (int j = 0; j < str.length(); j++)
//            {
//                int symbol = Character.getNumericValue(str.charAt(j));
//                if (symbol % 2 == 0)
//                {
//                    evenDigit++;
//                }
//                else
//                {
//                    oddDigit++;
//                }
//            }
//            if (evenDigit == str.length())
//            {
//                evenNumber++;
//            }
//            else if (evenDigit == oddDigit)
//            {
//                oddNumber++;
//            }
//        }
//        System.out.println("even amount = " + evenNumber);
//        System.out.println("odd=even amount = " + oddNumber);
    }

    //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    public static void findDigitsInAscendingOrder()
    {
//        System.out.println("6. Найти число, цифры в котором идут в строгом порядке возрастания." +
//                            " Если таких чисел несколько, найти первое из них.");
//        input();
//        for (int i = 0; i < inputNumbers.size(); i++)
//        {
//            boolean res = false;
//            String number = inputNumbers.get(i);
//            for (int first = 0; first < number.length()-1; first+=2)
//            {
//                int mid;
//                int last;
//                if (first == number.length()-2) //для четных чисел
//                {
//                   mid = first;
//                   if (!(number.charAt(first) < number.charAt(mid)))
//                   {
//                       break;
//                   }
//                    res = true;
//                }
//                else
//                {
//                    mid = first + 1;
//                    last = mid + 1;
//                    if (!(number.charAt(first) < number.charAt(mid) && number.charAt(mid) < number.charAt(last)))
//                    {
//                        break;
//                    }
//                    res = true;
//                }
//            }
//            if (res)
//            {
//                System.out.println(inputNumbers.get(i));
//            }
//        }
    }

    //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    public static void findOnlyUniqueDigits()
    {
//        System.out.println("7. Найти число, состоящее только из различных цифр." +
//                            " Если таких чисел несколько, найти первое из них.");
//        input();
//        for (int i = 0; i < inputNumbers.size(); i++)
//        {
//            String num = inputNumbers.get(i);
//            int uniqueDigitsAmount = amountOfUniqueDigits(num);
//            if (num.length() == uniqueDigitsAmount)
//            {
//                System.out.println(inputNumbers.get(i));
//                break;
//            }
//        }
    }
}

































