import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи выражение (например: 2 + 2)");
        String input = sc.nextLine();
        String result = calc(input);
        System.out.println("Результат: " + result);
    }

    static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Ошибка: Неверный формат ввода.");
        }

        int a;
        int b;
        // Проверка, что число целое
        try {
             a = Integer.parseInt(parts[0]); // 1 число из String в int
             b = Integer.parseInt(parts[2]); // 2 число из String в int
        } catch (NumberFormatException e) {
            throw new Exception("Ошибка: Вводите только целые числа.");
        }
        String operator = parts[1]; // Оператор ("+", "-", "*", "/")


        // Проверка, что оба числа от 0 до 10
        if (a < 0 || a > 10 || b < 0 || b > 10) {
            throw new Exception("Ошибка: Числа должны быть от 0 до 10.");
        }

        // Расчет выражения
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Ошибка: деление на ноль.");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Ошибка: Используйте +, -, *, /.");
        }

        return String.valueOf(result);
    }
}
