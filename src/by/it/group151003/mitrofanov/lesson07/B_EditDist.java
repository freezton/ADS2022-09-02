package by.it.group151003.mitrofanov.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class B_EditDist {


    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        final int N = one.length() + 1;
        final int M = two.length() + 1;
        int[][] distancesTable = new int[N][M];

        //Fill 1-st raw and 1-st column with string indexes
        for (int i = 0; i < N; ++i)
            distancesTable[i][0] = i;
        for (int j = 0; j < M; ++j)
            distancesTable[0][j] = j;

        for (int i = 1; i < N; ++i)
            for (int j = 1; j < M; ++j) {
                int ins = distancesTable[i][j - 1] + 1; //If insert element - take left one form the table + 1
                int del = distancesTable[i - 1][j] + 1; //If delete element - take one above from the table + 1
                int sub = distancesTable[i - 1][j - 1] + ((one.charAt(i-1) == two.charAt(j-1)) ? 0 : 1); //If change element - take one from diagonal + 1, if it's not the same element
                distancesTable[i][j] = Math.min(Math.min(ins, del), sub); //Take minimum of values above
            }

        int result = distancesTable[N - 1][M - 1];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }



    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}