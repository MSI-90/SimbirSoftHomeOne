package Helpers.BankManage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class DataClassForManagerPage {

    protected static final String[] englishLetters = {"a", "b", "c", "d", "e", "f", "j", "h", "i", "l", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static Map<String, String> regData = new HashMap();
    private static long numberDigits = (long)Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

    public static String[] digitAsString = getSimbol(numberDigits);
    public static String getString = getString(digitAsString, englishLetters, numberDigits);
    public static String getStringFromDigit = getStringFromDigit();

    private static String[] getSimbol(long digit){
        String numberString = Long.toString(digit);
        int arrayLength = (int) Math.ceil((double) numberString.length() / 2);
        String[] array = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = numberString.substring(i * 2, i * 2 + 2);
        }
        return array;
    }

    private static String getStringFromDigit(){
        String[] str = getSimbol(numberDigits);
        String arrayToString = "";

        for(String s : str)
            arrayToString += s;

        return arrayToString;
    }

    private static String getString(String[] stringsArrFromLongDigit, String[] englishLetters, long digit){
        String str = "";
        int numberOfSimbols = 25;
        int numberFromConvert = 0;
        int postFromPercent = 0;
        for (int i = 0; i < stringsArrFromLongDigit.length; i++){
            numberFromConvert = Integer.parseInt(stringsArrFromLongDigit[i]);
            if (numberFromConvert > numberOfSimbols){
                postFromPercent = numberFromConvert % numberOfSimbols;
                str += englishLetters[postFromPercent];
            }
            else{
                str += englishLetters[numberFromConvert];
            }
        }
        return str;
    }
}
