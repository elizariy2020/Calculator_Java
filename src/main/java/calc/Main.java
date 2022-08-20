package calc;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner inputString = new Scanner(System.in);//---------------------------- Вводим выражение с консоли ----------------

        String input = inputString.nextLine();

        String result= calc(input);//----------------- Расчитываем результат ---------------------------

        System.out.println(result);//--------------------- Выводим результат в консоль Ура!!!!------------

    }

    //============================================= Расчитываем результат ---------------------------
    private static String calc(String inputStr) throws Exception {

        if (!inputStr.contains("+") &&
                !inputStr.contains("-") &&
                !inputStr.contains("*") &&
                !inputStr.contains("/"))//-------------------------- Проверяем наличие арифметического выражения ----------------
            throw new Exception();

        if (!checksigns(inputStr))//-------------------------- Проверяем осутствие еще одного арифметического выражения ----------------
            throw new Exception();

        GetRomeNumbers getRomeNumbers = new GetRomeNumbers();//-------- Создаем экземпляр класса для работы с римскими-арабскими цифрами

        String sign = whatsign(inputStr);//-------------------------- Определяем арифметическое действие -------------------------

        String firstNum = inputStr.substring(0, inputStr.indexOf(sign)).trim();//--------------- Определяем первое число выражения -------------

        String secondNum = inputStr.substring(inputStr.indexOf(sign) + 1).trim();//---------------- Определяем второе число выражения ----------

        String result="";

        switch (checknum(firstNum, secondNum)) {//-------------------- Проверяем числа выражения на арабские, римские  или не подходят-------------

            case "A" -> result = calculate(firstNum, secondNum, sign);//---------- Если числа арабские вычисляем результат -----------

            case "R" -> {//---------- Если числа римские вычисляем результат -----------

                String num1= getRomeNumbers.getarabnumber(firstNum);//--------------- Переводим первое число в арабское

                String num2 = getRomeNumbers.getarabnumber(secondNum);//--------------- Переводим второе число в арабское

                result = calculate(num1,num2 , sign);//---------- Числа уже арабские, вычисляем результат -----------

                if (Double.parseDouble(result) < 1)//---------------- Проверяем результат -------------
                    throw new Exception();


                result = getRomeNumbers.get(Integer.parseInt(result));//--------- Переводим результат из арабского в римский --------

            }

            case "" -> throw new Exception();
        }

        return result;//-------------------------- Возвращаем результат --------------------------
    }

    //---------- Арабские числа вычисляем результат -----------
    private static String calculate(String firstNum, String secondNum, String sign) {

        return switch (sign) {
            case "+" -> String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
            case "-" -> String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum));
            case "*" -> String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
            case "/" -> String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum));
            default -> "";
        };

    }
    //======================================== Проверяем числа выражения на арабские, римские  или не подходят-------------
    private static String checknum(String firstNum, String secondNum) {
        try {

            int num1 = Integer.parseInt(firstNum);//----------------- Переводим String в Int --------------

            int num2 = Integer.parseInt(secondNum);//----------------- Переводим String в Int --------------

            if (num1 < 1 || num1 > 10)//------------ Проверяем первое число на условие задачи --------
                return "";

            if (num2 < 1 || num2 > 10)//------------ Проверяем второе число на условие задачи --------
                return "";

            return "A";//--------------------- Если числа арабские и соответствуют условию задачи возвращаем "А"

        } catch (Exception e) {//---------------------- Если числа не арабские или не числа выскочит Исключение --------

            if (checkrome(firstNum) && checkrome(secondNum))//----------- Проверяем числа на римские, если норм возвращаем "R"
                return "R";


        }

        return "";//-------------------------- Если числа не числа возвращаем "" --------------

    }

    //========================================= Проверяем числа на римские
    private static boolean checkrome(String num) {
        return switch (num) {
            case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" -> true;
            default -> false;
        };

    }

    //============================================ Определяем арифметическое действие -------------------------
    private static String whatsign(String inputStr) {
        int index;

        index = inputStr.indexOf("+");
        if (index != -1)
            return "+";

        index = inputStr.indexOf("-");
        if (index != -1)
            return "-";

        index = inputStr.indexOf("*");
        if (index != -1)
            return "*";

        index = inputStr.indexOf("/");
        if (index != -1)
            return "/";

        return "";
    }

    //======================================================= Проверяем осутствие еще одного арифметического выражения ----------------
    private static boolean checksigns(String inputStr) {
        int index;
        index = inputStr.indexOf("+");
        if (index != -1)
            if (inputStr.substring(index + 1).contains("+") ||
                    inputStr.substring(index + 1).contains("-") ||
                    inputStr.substring(index + 1).contains("*") ||
                    inputStr.substring(index + 1).contains("/"))
                return false;
        index = inputStr.indexOf("-");
        if (index != -1)
            if (inputStr.substring(index + 1).contains("+") ||
                    inputStr.substring(index + 1).contains("-") ||
                    inputStr.substring(index + 1).contains("*") ||
                    inputStr.substring(index + 1).contains("/"))
                return false;

        index = inputStr.indexOf("*");
        if (index != -1)
            if (inputStr.substring(index + 1).contains("+") ||
                    inputStr.substring(index + 1).contains("-") ||
                    inputStr.substring(index + 1).contains("*") ||
                    inputStr.substring(index + 1).contains("/"))
                return false;

        index = inputStr.indexOf("/");
        if (index != -1)
            if (inputStr.substring(index + 1).contains("+") ||
                    inputStr.substring(index + 1).contains("-") ||
                    inputStr.substring(index + 1).contains("*") ||
                    inputStr.substring(index + 1).contains("/"))
                return false;

        return true;
    }


}
