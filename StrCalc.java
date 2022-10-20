import java.util.Scanner;

public class StrCalc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String ty = sc.nextLine();//.replace("\"", "");
        String[] s = ty.split(" ");
        if (s[0].length() > 12 || s[2].length() > 12) {
            throw new RuntimeException("Строка не должна состоять длиннее 10 символов ");
        }
        if (s[0].charAt(0) != '\"') {
            throw new RuntimeException("Строки должны передаваться в кавычках");
        }
        switch (s[1]) {
            case "+" -> System.out.print(Plus(s));
            case "*" -> System.out.print(Umn(s));
            case "-" -> System.out.print(Minus(s));
            case "/" -> System.out.print(Del(s));
            default -> throw new Exception("Не правильно выбрано выражение");
        }
    }

    public static String Plus(String[] s) {

        return strResult(s[0] + s[2]);
    }

    public static String Umn(String[] s) {

        return strResult(s[0].repeat(checkInt(s[2])));
    }

    public static String Minus(String si) {
        String [] s = new String[3];
        for (int i = 0; i < s[1].length(); i++) {
            if (si.contains(" " + s[i] + " ")) {
                s[0] =si.substring(0, si.indexOf(" " + s[i] + " "));
                s[1] = s[i];
                s[2] = si.substring(s[0].length() + 3, si.length());
                break;
            }
        }
        return strResult(s[0].replace(s[2], ""));
    }

    public static String Del(String[] s) {
        int x = s[0].length() / checkInt(s[2]);
        return strResult(s[0].substring(0, x));
    }

    public static Integer checkInt(String s) {
        int i = Integer.parseInt(s);
        if (i <= 10 && i > 0) {
            return i;
        } else {
            throw new RuntimeException("Число должно быть не больше 10");
        }
    }

    public static String strResult(String s) {
        String si = s.replace("\"","");
        return "\"" + ((si.length() <= 40) ? si : (si.substring(0, 40) + "...")) + "\"";

    }
}
