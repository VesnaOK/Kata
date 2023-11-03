import java.util.Scanner;

public class CalculaterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) {
        String[] razdelenie =input.split(" ");
        if (razdelenie.length != 3)
            throw new RuntimeException("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами. Пример ввода: a + b, a - b, a * b, a / b.");
        String number1 = razdelenie[0], number2 = razdelenie[2], operation = razdelenie[1];
        int num1, num2, romanNum1 = -1, romanNum2 = -1, resultRoman, test1 = -1, test2 = -1;
        String result;

        String [] roman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        if (Character.isDigit(number1.charAt(0)) && Character.isDigit(number2.charAt(0))) {
            num1 = Integer.parseInt(number1);
            num2 = Integer.parseInt(number2);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10)
                throw new RuntimeException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            else {
                switch (operation) {
                    case "+":
                        result = Integer.toString(num1 + num2);
                        break;
                    case "-":
                        result = Integer.toString(num1 - num2);
                        break;
                    case "/":
                        result = Integer.toString(num1 / num2);
                        break;
                    case "*":
                        result = Integer.toString(num1 * num2);
                        break;
                    default:
                        throw new RuntimeException("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления");
                }
            }
        } else if ((Character.isDigit(number1.charAt(0)) && Character.isLetter(number2.charAt(0))) || (Character.isLetter(number1.charAt(0)) && Character.isDigit(number2.charAt(0))))
            throw new RuntimeException ("Вводите числа в одинаковой системе счисления");
        else {
            for (int i = 0; i<roman.length; i++) {
                if (number1.equals(roman[i])) {
                    romanNum1 = i + 1;
                    test1 = 1;
                }
                if (number2.equals(roman[i])) {
                    romanNum2 = i + 1;
                    test2 = 1;
                }
            }
            if(romanNum1 > 10 || romanNum2 > 10 || test1 == -1 || test2 == -1)
                throw new RuntimeException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            else {
                switch (operation) {
                    case "+":
                        resultRoman = romanNum1 + romanNum2;
                        break;
                    case "-":
                        resultRoman = romanNum1 - romanNum2;
                        break;
                    case "/":
                        resultRoman = romanNum1 / romanNum2;
                        break;
                    case "*":
                        resultRoman = romanNum1 * romanNum2;
                        break;
                    default:
                        throw new RuntimeException("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления");
                }
            }
            if (resultRoman<=0)
                throw new RuntimeException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            else
                result = roman[resultRoman-1];
        }
        return result;
    }
}