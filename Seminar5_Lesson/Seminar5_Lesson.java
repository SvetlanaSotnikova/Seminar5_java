package Seminar5_Lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Seminar5_Lesson {
    private static final int N = 8; // Размер доски

    public static void main(String[] args) {
        task0();
        System.out.println(task1("paper", "title"));
        System.out.println(task2("<{a}+{(d*3)}>"));
        task5("Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.");
        System.out.println(task3("MMXXII"));
        System.out.println(task4(2022));
        task6();
    }

    static void task0() {
        // Создать структуру для хранения Номеров паспортов и Фамилий
        // сотрудников организации.
        // 123456 Иванов
        // 321456 Васильев
        // 234561 Петрова
        // 234432 Иванов
        // 654321 Петрова
        // 345678 Иванов
        // Вывести данные по сотрудникам с фамилией Иванов.
        
        Passports passports = new Passports();
        passports.add("123456", "Иванов");
        passports.add("321456", "Васильев");
        passports.add("234561", "Петрова");
        passports.add("234432", "Иванов");
        passports.add("654321", "Петрова");
        passports.add("345678", "Иванов");

        System.out.println(passports.getAll());
        System.out.println(passports.getByPassNum("654321"));
        System.out.println(passports.getByLastName("Иванов"));
    }

    static boolean task1(String str1, String str2) {
        // Даны 2 строки, написать метод, который вернет true, если эти строки являются
        // изоморфными
        // и false, если нет. Строки изоморфны, если одну букву в первом слове можно
        // заменить на
        // некоторую букву во втором слове, при этом
        // 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с
        // сохранением
        // порядка следования. (Например, add - egg изоморфны)
        // 2. буква может не меняться, а остаться такой же. (Например, note - code)
        // Пример 1:
        // Input: s = "foo", t = "bar"
        // Output: false
        // Пример 2:
        // Input: s = "paper", t = "title"
        // Output: true

        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (map.containsKey(c1[i])) {
                if (c2[i] != map.get(c1[i]))
                    return false;
            } else {
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }

    static boolean task2(String str) {
        // Написать программу, определяющую правильность расстановки скобок в выражении.
        // Пример 1: a+(d*3) - истина
        // Пример 2: [a+(1*3) - ложь
        // Пример 3: [6+(3*3)] - истина
        // Пример 4: {a}[+]{(d*3)} - истина
        // Пример 5: <{a}+{(d*3)}> - истина
        // Пример 6: {a+]}{(d*3)} - ложь

        char[] c = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('<', '>');

        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i]))
                stack.push(c[i]);
            if (map.containsValue(c[i])) {
                if (stack.isEmpty() || map.get(stack.pop()) != c[i])
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    static int task3(String str) {
        // Написать метод, который переведет число из римского формата записи в
        // арабский.
        // Например, MMXXII = 2022

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
                result -= map.get(str.charAt(i));
            } else {
                result += map.get(str.charAt(i));
            }
        }

        return result;
    }

    static String task4(int number) {
        // Написать метод, который переведёт данное целое число в римский формат.
        // http://graecolatini.bsu.by/htm-different/num-converter-roman.htm
        // Принципы римской с/с

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int floorKey;
        StringBuilder stringBuilder = new StringBuilder();

        while (number > 0) {
            floorKey = map.floorKey(number);
            if (floorKey != -1) {
                stringBuilder.append(map.get(floorKey));
                number -= floorKey;
            }
        }
        return stringBuilder.toString();
    }

    static void task5(String str) {
        // Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг
        // прелестный Пора красавица проснись.
        // Написать метод, который отсортирует эти строки по длине с помощью TreeMap.
        // Строки с одинаковой длиной не должны “потеряться”.

        String[] words = str.split(" ");
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String word : words) {
            int length = word.length();
            if (map.containsKey(length)) {
                List<String> list = map.get(length);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(length, list);
            }
        }
        System.out.println(map);
    }

    static void task6() {
        // Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке
        // была строго один раз.

        int[][] sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        // Начинаем с клетки (0,0)
        sol[0][0] = 1;
        if (solveKnightTour(sol, 0, 0, 2)) {
            printSolution(sol);
        } else {
            System.out.println("Решение не существует");
        }
    }

    private static void printSolution(int[][] sol) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4d ", sol[i][j]);
            }
            System.out.println();
        }
    }

    // Функция для проверки, что данный ход коня находится в пределах доски
    private static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == 0);
    }

    // Рекурсивная функция для решения задачи о ходе коня
    private static boolean solveKnightTour(int[][] sol, int x, int y, int moveCount) {
        if (moveCount == N * N + 1) {
            return true; // Все клетки заполнены
        }

        // Возможные ходы коня по горизонтали и вертикали
        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        // Проверяем все возможные ходы коня

        for (int k = 0; k < 8; k++) {
            int nextX = x + moveX[k];
            int nextY = y + moveY[k];
            
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = moveCount;

                // Рекурсивно проверяем следующий ход
                if (solveKnightTour(sol, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    // Если следующий ход не привел к решению, отменяем текущий ход (backtrack)
                    sol[nextX][nextY] = 0;
                }
            }
        }

        return false; // Если все ходы были проверены и не привели к решению
    }

}
