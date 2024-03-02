package Helpers.CustomerPage;

import java.util.ArrayList;
import java.util.TreeSet;

public class DataClassFroCustomerPage {
    public static ArrayList<String> firstnames = new ArrayList<String>();
    public static ArrayList<String> firstNamesAfterSort = new ArrayList<String>();

    public static int averageOfnames = averageOfNames();

    public static int averageOfNames(){
        int itemsSumm = firstnames.stream()
                .mapToInt(String::length)
                .sum();
        int averageLength =  (int)Math.ceil((double) itemsSumm / firstnames.size());

        return averageLength;
    }

    public static String isCompleate(String firstNameFromTable, String fromRegData){
        String result = null;
        if (!firstNameFromTable.equals(fromRegData)){
            result = "Что-то не так, значение указаное пользователем при заполнении формы - " + fromRegData + " не пришло на сервер";
        }
        return result;
    }
}
