import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public void calculate(String expression){

        boolean addition = true;
        int checkPoint = 0;
        List<String> addList = new ArrayList<String>();
        List<String> minusList = new ArrayList<String>();

        for (int i = 0; i < expression.length(); i++) {

            String expChar = expression.substring(i, i + 1);

            if ("+".equals(expChar)) {
                checkOperator(addList, minusList, addition, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                addition = true;
                continue;
            }

            if ("-".equals(expChar)) {
                checkOperator(addList, minusList, addition, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                addition = false;
                continue;
            }
        }
        checkOperator(addList, minusList, addition, expression.substring(checkPoint).trim());

        // Get sum each list
        int sumAdd = sumList(addList);
        int sumMinus = sumList(minusList);


        int result =  sumAdd - sumMinus;

        System.out.println("Result: " + result + " mm");
    }

    private int sumList(List<String> addList) {
        int sum = 0;
        for (String exp: addList) {
            String[] arr = exp.split(" ");
            int value = Integer.parseInt(arr[0]);
            int scale = Metrics.valueOf(arr[1]).getScale();
            sum = sum + value * scale;
        }
        return sum;
    }

    private void checkOperator(List<String> addList, List<String> minusList, boolean op, String substring) {
        if (op) {
            addList.add(substring);
        } else {
            minusList.add(substring);
        }
    }
}
