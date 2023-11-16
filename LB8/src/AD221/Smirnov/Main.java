package AD221.Smirnov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Generic-клас стеку
class Stack<T> {
    private List<T> elements;

    // Конструктор класу
    public Stack() {
        elements = new ArrayList<>();
    }

    // Додає елемент до стеку
    public void push(T element) {
        elements.add(element);
    }

    // Видаляє та повертає верхній елемент стеку
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    // Перевіряє, чи стек порожній
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Статичний метод, який приймає Stack і повертає його копію з інвертованим порядком елементів
    public static <E> Stack<E> reverseStack(Stack<E> inputStack) {
        Stack<E> reversedStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            reversedStack.push(inputStack.pop());
        }

        return reversedStack;
    }
}

// Головний клас програми
public class Main {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Додати елемент до стеку");
            System.out.println("2. Видалити елемент зі стеку");
            System.out.println("3. Показати стек");
            System.out.println("4. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очищення буфера після nextInt()

            switch (choice) {
                case 1:
                    // Додавання елемента до стеку
                    System.out.print("Введіть елемент для додавання: ");
                    String elementToAdd = scanner.nextLine();
                    stringStack.push(elementToAdd);
                    break;
                case 2:
                    // Видалення елемента зі стеку
                    String removedElement = stringStack.pop();
                    if (removedElement != null) {
                        System.out.println("Видалено: " + removedElement);
                    } else {
                        System.out.println("Стек порожній, немає елементів для видалення.");
                    }
                    break;
                case 3:
                    // Виведення стеку
                    System.out.println("Стек:");
                    printStack(stringStack);
                    break;
                case 4:
                    // Вихід з програми
                    System.out.println("Програма завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильний вибір. Будь ласка, введіть вірну опцію.");
            }
        }
    }

    // Метод для виведення елементів стеку без зміни самого стеку
    private static <T> void printStack(Stack<T> stack) {
        Stack<T> tempStack = Stack.reverseStack(stack);

        while (!tempStack.isEmpty()) {
            T element = tempStack.pop();
            System.out.println(element);
            stack.push(element);
        }
    }
}


