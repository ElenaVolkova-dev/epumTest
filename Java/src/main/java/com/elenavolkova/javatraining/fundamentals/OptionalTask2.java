package com.elenavolkova.javatraining.fundamentals;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class IndexPair
{
    public int row;
    public int column;
    IndexPair(int r, int c)
    {
        row = r;
        column = c;
    }


//    public void setRow(int r) { row = r; }
//    public void setColumn(int c) { column = c; }
//    public int getRow() { return row; }
//    public int getColumn() { return column; }
}

//class MaxValue
//{
//    int value;
//    int occurence;
//}

public class OptionalTask2
{
    private static int size;
    private static int[][] matrix;
    private static Scanner scanner = new Scanner(System.in);
    private static final int check = -500;

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
    private static void print(int[][]arr)
    {
        System.out.print("\t" + "  ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.printf("%-5s", "[" + i + "]");
        }
        System.out.println();
        for (int row = 0; row < arr.length; row++)
        {
            System.out.print("[" + row + "]");
            for (int column = 0; column < arr.length; column++)
            {
                System.out.printf("%5d", arr[row][column]);
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
        print(matrix);
        SelectionSortOfRow(matrix, sortRow);
        System.out.println("Sorted: ");
        print(matrix);
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
        print(matrix);
        SelectionSortOfColumn(matrix, sortColumn);
        System.out.println("Sorted: ");
        print(matrix);
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
    public static void findSubsequence()
    {
        input();
        int[] arr = toOneD_Array();
        //int[] arr = {5,4, 1,2,3, 1};
        //int[] arr = {1,2,3,5, 4};
        //int[] arr = {1,2,3};
        //int[] arr = {5,3,2};
        //int[] arr = {5,4, 1,2,3, 1,2, 1,2,3,4,5,6, 6,5,4,1};
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
            //сhange change comparison operator
            //if ascending order: arr[startSequence] < arr[endSequence]
            //if descending order: arr[startSequence] > arr[endSequence]
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

    //3. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
    public static void sumOfMatrixElements()
    {
        input();
        print(matrix);
        int totalSum = 0;
        int rowSum = 0;
        int occurrence = 0;

        for (int row = 0; row < size; row++)
        {
            occurrence = 0;
            rowSum = 0;
            for (int column = 0; column < size; column++)
            {
                if (matrix[row][column] > 0)
                {
                    occurrence++;
                }
                if (occurrence == 2) break;
                if (occurrence == 1 && matrix[row][column] < 0)
                {
                    rowSum += matrix[row][column];
                }
            }
            if (occurrence == 1) rowSum = 0;
            totalSum += rowSum;
        }
        System.out.println(totalSum);
    }

    //4. Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
    private static ArrayList<IndexPair> getMaxMatchList(int[][] arr)
    {
        ArrayList<IndexPair> matchList = new ArrayList<>();
        int max = arr[0][0];
        //MaxValue max = new MaxValue();
        //max.value = arr[0][0];
        //max.occurence = 1;
        for (int row = 0; row < arr.length; row++)
        {
            int column = 0;
            if (row == 0) column = 1;
            for (; column < arr.length; column++)
            {
                if (arr[row][column] > max)
                {
                    max = arr[row][column];
                    //max.occurence = 1;
                }
                if (arr[row][column] == max)
                {
                    matchList.add(new IndexPair(row, column));
                }
            }
        }
        return matchList;
    }
//    private static int[][] replaceRowAndColumns(int[][] inputMatrix, int row, int column)
//    {
//        int newSize = inputMatrix.length - 1;
//        int[][] newMatrix = new int[newSize][newSize];
//        int fromRow = 0;
//        int fromColumn = 0;
//        for (int r = 0; r <  newSize; r++)
//        {
//            if (fromRow == row) fromRow++;
//            if (fromRow == inputMatrix.length)break;
//            for (int c = 0; c < newSize; c++)
//            {
//                if (fromColumn == column) fromColumn++;
//                if (fromColumn == inputMatrix.length)break;
//                newMatrix[r][c] = inputMatrix[fromRow][fromColumn];
//                fromColumn++;
//            }
//            fromRow++;
//            fromColumn = 0;
//        }
//        return newMatrix;
//    }
    private static int[][] deleteElements (int[][] arr, ArrayList<IndexPair> matchList)
    {
        //найти вхождение элемента
        for (int row = 0; row < arr.length; row++)
        {
            
        }
        return arr;
    }

    public static void deleteMaxElement()
    {
        //input();
        //if (matrix.length == 2) return;
        int[][]test = new int[3][3];
        test[0][0] = 5;
        test[0][1] = 2;
        test[0][2] = 3;
        test[1][0] = 4;
        test[1][1] = 6;
        test[1][2] = 3;
        test[2][0] = 6;
        test[2][1] = 4;
        test[2][2] = 1;



        print(test);
        ArrayList<IndexPair> list = getMaxMatchList(test);
        //System.out.println(max.value + " " +  max.occurence + " time(s)");
        //int[][] m = deleteElements(max, test);
//        print(m);
//        for (int i = 0; i < m.length; i++)
//        {
//            for (int j = 0; j < m.length; j++)
//            {
//                if (m[i][j] != -500)
//                {
//                    System.out.printf("%5d", m[i][j]);
//                }
//            }
//            System.out.println();
//        }
    }
}

