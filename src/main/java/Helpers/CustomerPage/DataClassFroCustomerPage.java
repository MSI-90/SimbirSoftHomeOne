package Helpers.CustomerPage;

import java.util.TreeSet;

public class DataClassFroCustomerPage {
    public static TreeSet<String> firstnames = new TreeSet<String>();
    public static int averageOfnames = averageOfNames();

    private static int averageOfNames(){
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
