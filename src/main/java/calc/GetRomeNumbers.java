package calc;

public class GetRomeNumbers {

    public String get(int result) {

        int units = result%10;//--------------- Вычисляем единицы -----------

        int tens = (result%100)/10;// ---------------- Вычисляем десятки ----------

        int hundreds = (result%1000)/100;// -------------- Вычисляем сотни -----------

        return hundreds(hundreds) + tens(tens) + units(units); // ------Возвращаем полученное римское число -----------

    }
//===================================== Сопоставляем арабские единицы римскому числу  ----------------------
    public String units(int units) {
        return switch (units) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
    }
    //===================================== Сопоставляем арабские десятки римскому числу  ----------------------
    public  String tens(int tens) {
        return switch (tens) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "";
        };
    }
    //===================================== Сопоставляем арабские сотни римскому числу  ----------------------
    public  String hundreds(int hundreds) {

        if (hundreds == 1)

            return  "C";

        return "";
    }
//=========================================== Получаем арабское число изи римского --------------------------
    public   String getarabnumber(String firstNum) {

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
}
