import math.Calculator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Введите операцию в формате \"Число Оператор Число\"");
        System.out.println("Использовать можно арабские или римские цифры от 1 до 10.");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        Calculator calc = new Calculator(input);
        int a = calc.getA();
        int b = calc.getB();
        validate(a);
        validate(b);
        

        String result = calc.getResult();
        System.out.println("= " + result);
    }

    public static void  validate (int input){
        String e;
        if (input > 10 || input < 1) {
            e = "Числа не могут быть меньше 1 или больше 10. Проблема: (" + input + ")";
            System.out.println(e);
            System.exit(1);
        }

    }
}