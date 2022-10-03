package pl.hyorinmaru.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    public static void main(String[] args) {
        Matcher matcher = pattern.matcher("Strategia17#");
        System.out.println(matcher.matches());
    }
}
