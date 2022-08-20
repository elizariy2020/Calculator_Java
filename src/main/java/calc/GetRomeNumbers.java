package calc;

public class GetRomeNumbers {

    public String get(int result) {
        int units = result%10;
        int tens = (result%100)/10;
        int hundreds = (result%1000)/100;

        return Hundreds(hundreds) + Tens(tens) + Units(units);
    }

    public String Units(int units) {
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
    public  String Tens(int tens) {
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
    public  String Hundreds(int hundreds) {

        if (hundreds == 1)

            return  "C";

        return "";
    }


}
