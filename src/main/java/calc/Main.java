package calc;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        String inputStr = input.nextLine();

        if (!inputStr.contains("+") && !inputStr.contains("-") && !inputStr.contains("*") && !inputStr.contains("/"))
            throw new Exception();

        if (!checksigns(inputStr))
            throw new Exception();

        String sign = whatsign(inputStr);

        String firstNum = getfirstnumber(inputStr, sign);

        String secondNum = getsecondnumber(inputStr, sign);

        String result="";

        switch (checknum(firstNum, secondNum)) {

            case "A" -> result = calculate(firstNum, secondNum, sign);

            case "R" -> {

                result = calculate(getarabnumber(firstNum), getarabnumber(secondNum), sign);

                if (Double.parseDouble(result) < 1)
                    throw new Exception();

                GetRomeNumbers getRomeNumbers = new GetRomeNumbers();
                result = getRomeNumbers.get(Integer.parseInt(result));

            }
            
            case "" -> throw new Exception();
        }

        System.out.println(result);
    }



    private static String getarabnumber(String firstNum) {

        return switch (firstNum) {
            case "I" -> "1";
            case "II" -> "2";
            case "III" -> "3";
            case "IV" -> "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" -> "7";
            case "VIII" -> "8";
            case "IX" -> "9";
            case "X" -> "10";
            default -> "";
        };
    }

    private static String calculate(String firstNum, String secondNum, String sign) {

        return switch (sign) {
            case "+" -> String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
            case "-" -> String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum));
            case "*" -> String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum));
            case "/" -> String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum));
            default -> "";
        };

    }

    private static String checknum(String firstNum, String secondNum) {
        try {

            int num1 = Integer.parseInt(firstNum);
            int num2 = Integer.parseInt(secondNum);

            if (num1 < 1 || num1 > 10)
                return "";
            if (num2 < 1 || num2 > 10)
                return "";

            return "A";

        } catch (Exception e) {

            if (checkrome(firstNum) && checkrome(secondNum))
                return "R";


        }

        return "";

    }

    private static boolean checkrome(String num) {
        return switch (num) {
            case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" -> true;
            default -> false;
        };

    }

    private static String getsecondnumber(String inputStr, String sign) {

        return inputStr.substring(inputStr.indexOf(sign) + 1).trim();
    }

    private static String getfirstnumber(String inputStr, String sign) {

        return inputStr.substring(0, inputStr.indexOf(sign)).trim();
    }


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
