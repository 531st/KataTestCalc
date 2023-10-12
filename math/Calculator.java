package math;

import java.util.HashMap;

public class Calculator {
    
    private String result;
    private boolean isRoman = false;
    private int a;
    private int b;
    private String operator;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }


    public Calculator (String input) {
        setNums(input);
        this.result = calculate(a, b, operator);
    }

    public String getResult(){
        return result;
    }

    private void setNums(String strInput) {
        String[] splitInput = strInput.split(" ");
        this.operator = splitInput[1];

        a = toArab(splitInput[0]);
        b = toArab(splitInput[2]);      
    }


    private int toArab (String string) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        {map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);}
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            this.isRoman = true;
            int result = 0;
            for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            int currentValue = map.get(current);
            if (i < string.length() - 1) {
                char next = string.charAt(i + 1);
                int nextValue = map.get(next);
                if (currentValue < nextValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }
        return result;
        }
    }
    

    private String toRoman(int num) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }


    public String  calculate (int a, int b, String operator){
        int result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                System.out.println("Invalid operator");
        }
        if (isRoman) {
            return toRoman(result);
        }

        return Integer.toString(result);
    }
}

