package com.elenavolkova.javatraining.fundamentals;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask2
{
    private static int size;
    private static int[][] matrix;
    private static Scanner scanner = new Scanner(System.in);

    private static void input()
    {
        System.out.println("Enter matrix size");
        size = scanner.nextInt();
        while (size <= 1)
        {
            System.out.println("Enter correct size");
            size = scanner.nextInt();
        }
        matrix = new int[size][size];
        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                matrix[row][column] = getRandom(-100, 100);
            }
        }
    }
    private static int getRandom(int min, int max)
    {
        Random ran = new Random();
        int i = min + ran.nextInt(max - min + 1);
        return i;
    }
    private static void print()
    {
        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                System.out.printf("%5d", matrix[row][column]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void swapColumns(int fromColumn, int toColumn)
    {
        for (int row = 0; row < size; row++)
        {
            int temp = matrix[row][toColumn];
            matrix[row][toColumn] = matrix[row][fromColumn];
            matrix[row][fromColumn] = temp;
        }
    }

    private static void swapRows(int fromRow, int toRow)
    {
        for (int column = 0; column < size; column++)
        {
            int temp = matrix[toRow][column];
            matrix[toRow][column] = matrix[fromRow][column];
            matrix[fromRow][column] = temp;
        }
    }

    private static void SelectionSortOfRow(int[][] array, int sortRow)
    {
        for (int column = 0; column < size; column++)
        {
            int minimum = array[sortRow][column];
            for (int iterator = column + 1; iterator < size; iterator++)
            {
                if (array[sortRow][iterator] < minimum )
                {
                    minimum = array[sortRow][iterator];
                    swapColumns(iterator, column);
                }
            }
        }
    }

    private static void SelectionSortOfColumn(int[][] array, int sortColumn)
    {
        for (int row = 0; row < size; row++)
        {
            int minimum = array[row][sortColumn];
            for (int iterator = row + 1; iterator < size; iterator++)
            {
                if (array[iterator][sortColumn] < minimum )
                {
                    minimum = array[iterator][sortColumn];
                    swapRows(iterator, row);
                }
            }
        }
    }

    //1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
    public static  void sortMatrixByRow()
    {
        System.out.println("Упорядочить столбцы матрицы в порядке возрастания значений элементов k-ой строки.");
        input();
        System.out.println("Enter row number to sort (0 - " + (size - 1) + ")");
        int sortRow = scanner.nextInt();
        while (sortRow > size - 1 || sortRow < 0)
        {
            System.out.println("Enter column number to sort (0 - " + (size - 1) + ")");
            sortRow = scanner.nextInt();
        }
        System.out.println("Original: ");
        print();
        SelectionSortOfRow(matrix, sortRow);
        System.out.println("Sorted: ");
        print();
    }
    public static  void sortMatrixByColumn()
    {
        System.out.println("Упорядочить строки матрицы в порядке возрастания значений элементов k-ого столбца.");
        input();
        System.out.println("Enter column number to sort (0 - " + (size - 1) + ")");
        int sortColumn = scanner.nextInt();
        while (sortColumn > size - 1 || sortColumn < 0)
        {
            System.out.println("Enter column number to sort (0 - " + (size - 1) + ")");
            sortColumn = scanner.nextInt();
        }
        System.out.println("Original: ");
        print();
        SelectionSortOfColumn(matrix, sortColumn);
        System.out.println("Sorted: ");
        print();
    }

    //2. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
    private static int[] toOneD_Array()
    {
        int[] result = new int[size*size];
        for (int row = 0; row < size; row++)
        {
            for (int column = 0; column < size; column++)
            {
                result[(row * size) + column] = matrix[row][column];
            }
        }
        return result;
    }

    public static void ascendingElementsInOrder()
    {
        //input();
        //int[] arr = toOneD_Array();
        //int[] arr = {5,4, 1,2,3, 1};
        //int[] arr = {1,2,3,5, 4};
        //int[] arr = {1,2,3};
        //int[] arr = {5,3,2};
        int[] arr = {5,4, 1,2,3, 1,2, 1,2,3,4,5,6};
        //int[] arr = {-87,-79,53,  -95,-48,0,  -5,  -71,1};
        //int[] arr = {6, 3, 1,2 };
        for (int e : arr)
        {
            System.out.print(e + " ");
        }
        System.out.println();
        int left = 0;
        int right = left + 1;

        int startSequence = 0;
        int endSequence = startSequence + 1;

        int firstIndex = 0;
        int lastIndex = 0;

        boolean isStartSaved = false;
        int check = 1;
        int counter = 1;
        int saveStart = 0;

        //array loop
        while (right < arr.length)
        {
            // subsequence loop
            while (endSequence < arr.length && arr[startSequence] < arr[endSequence])
            {
                if (!isStartSaved)
                {
                    saveStart = startSequence;
                    isStartSaved = true;
                }
                counter++;
                startSequence++;
                endSequence++;
            }
            if (counter > check)
            {
                check = counter;
                firstIndex = saveStart;
                lastIndex = endSequence;
            }
            startSequence = endSequence;
            endSequence++;
            counter = 1;
            isStartSaved = false;
            left++;
            right++;
        }
        while (firstIndex < lastIndex)
        {
            System.out.print(arr[firstIndex] + " ");
            firstIndex++;
        }
    }
}

