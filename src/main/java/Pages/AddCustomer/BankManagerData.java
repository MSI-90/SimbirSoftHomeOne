package Pages.AddCustomer;

import java.util.HashMap;
import java.util.Map;

public class BankManagerData {
    public static final String[] englishLetters = {"a", "b", "c", "d", "e", "f", "j", "h", "i", "l", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static long numberDigits = (long)Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

    public static Map<String, String> regData = new HashMap();
}
