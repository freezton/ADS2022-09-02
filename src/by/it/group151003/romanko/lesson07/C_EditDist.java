package by.it.group151003.romanko.lesson07;

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
    Итерационно вычислить алгоритм преобразования двух данных непустых строк
    Вывести через запятую редакционное предписание в формате:
     операция("+" вставка, "-" удаление, "~" замена, "#" копирование)
     символ замены или вставки

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    #,#,

    Sample Input 2:
    short
    ports
    Sample Output 2:
    -s,~p,#,#,#,+s,

    Sample Input 3:
    distance
    editing
    Sample Output 2:
    +e,#,#,-s,#,~i,#,-c,~g,


    P.S. В литературе обычно действия редакционных предписаний обозначаются так:
    - D (англ. delete) — удалить,
    + I (англ. insert) — вставить,
    ~ R (replace) — заменить,
    # M (match) — совпадение.
*/


public class C_EditDist {

    String getDistanceEditing(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int[][] dist = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < one.length() + 1; i++) {
            dist[i][0] = i;
        }
        for (int j = 0; j < two.length() + 1; j++) {
            dist[0][j] = j;
        }
        for (int i = 1; i < one.length() + 1; i++) {
            for (int j = 1; j < two.length() + 1; j++) {
                int cost = one.charAt(i - 1) == two.charAt(j - 1) ? 0 : 1;
                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
                if (i > 1 && j > 1 && one.charAt(i - 1) == two.charAt(j - 2) && one.charAt(i - 2) == two.charAt(j - 1)) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int i = one.length();
        int j = two.length();

        while (i > 0 && j > 0) {
            result.insert(0, ",");
            boolean check = one.charAt(i - 1) == two.charAt(j - 1);
            char symbol = check ? '#' : '~';
            int value = check ? 0 : 1;
            if (dist[i][j] == dist[i - 1][j - 1] + value) {
                if (symbol == '~')
                    result.insert(0, "~" + two.charAt(j - 1));
                else
                    result.insert(0, symbol);
                --j;
                --i;
            }
            else
            if (dist[i][j] == dist[i - 1][j] + 1) {
                result.insert(0, '-');
                result.insert(1, one.charAt(i - 1));
                --i;
            }
            else if (dist[i][j] == dist[i][j - 1] + 1) {
                result.insert(0, '+');
                result.insert(1, two.charAt(j - 1));
                --j;
            }
        }

        if (i > 0) {
            result.insert(0,',');
            result.insert(0,'-');
            result.insert(1, one.charAt(i - 1));
        } else if (j > 0) {
            result.insert(0,',');
            result.insert(0,'+');
            result.insert(1, two.charAt(j - 1));
        };

        return result.toString();
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        C_EditDist instance = new C_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
    }

}