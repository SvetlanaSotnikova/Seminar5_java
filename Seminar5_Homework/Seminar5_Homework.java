package Seminar5_Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Seminar5_Homework {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        task0();
        task1();
        task2();
    }

    static void task0() {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
        // человек может иметь несколько телефонов.
        Phonebook phonebook = new Phonebook();
        phonebook.add("123456", "Иванов");
        phonebook.add("321456", "Васильев");
        phonebook.add("345678", "Иванов");
        phonebook.add("654321", "Петрова");

        System.out.println(phonebook.getAll());
        System.out.println(phonebook.getByLastName("Иванов"));
        System.out.println(phonebook.getByPhoneNumber("321456"));
        System.out.println(phonebook.getByPhoneNumber("345678"));

    }

    static void task1() {
        // Пусть дан список сотрудников:Иван Иванов ( и остальные, полный текст дз будет
        // на платформе)
        // Написать программу, которая найдет и выведет повторяющиеся имена с
        // количеством повторений. Отсортировать по убыванию популярности.

        // Находим имена с количеством повторений
        addName("Иван Иванов");
        addName("Петр Петров");
        addName("Мария Иванова");
        addName("Иван Иванов");
        addName("Ольга Сидорова");

        findCountNames();
    }

    static void findCountNames() {
        Map<String, Integer> repeatedNames = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                repeatedNames.put(entry.getKey(), entry.getValue());
            }
        }

        // Сортируем по убыванию популярности
        repeatedNames.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    static void addName(String name) {
        map.put(name, map.getOrDefault(name, 0) + 1);
    }

    static void task2() {
        // Реализовать алгоритм пирамидальной сортировки (HeapSort).
        HeapSort heapSort = new HeapSort();
        Scanner scanner = new Scanner(System.in);

        System.out.print("input size of array: ");
        int size = scanner.nextInt();

        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        heapSort.sortArray(arr);

        System.out.println("Sorted array: ");
        HeapSort.printArray(arr);

        scanner.close();
    }

    static void task3() {
        // На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

    }
}
