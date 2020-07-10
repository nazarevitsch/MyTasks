package com.bida.worktasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SecondTask {

    private static HashMap<Integer, String> mapOfNumbers = new HashMap<Integer, String>();
    private static HashMap<Integer, String> mapOfTenNumbers = new HashMap<Integer, String>();
    private static List<String> list = new ArrayList<String>();
    private static String hundred = "hundred";


    public static void start(){
        while (true) {
            createMaps();
            String[] numbers = readLine();
            String integerNumber = parseIntegerNumbers(numbers[0]);
            String doubleNumber = parseHundred(numbers[1]);
            System.out.println(integerNumber + "Dollars and " + doubleNumber + " Cents");
        }
    }

    private static String parseIntegerNumbers(String line){
        String answer = "";
        int counter = -1;
        for (int i = line.length() - 1; i >= 0; i = i - 3){
            counter++;
            try {
                if(parseHundred(line.substring(i - 2, i + 1)).length() > 2) {
                    answer = parseHundred(line.substring(i - 2, i + 1)) + " " + list.get(counter) + " " + answer;
                }
            } catch (Exception e){
                answer = parseHundred(line.substring(0, (line.length() % 3))) + " " + list.get(counter) + " " + answer;
            }
        }
        return answer;
    }

    private static String parseHundred(String link){
        if (link.equals("0")){
            return "zero";
        }
        String answer = "";
        if (link.length() == 3){
            if (checkNumber(link.substring(0, 1)) != null){
                answer = checkNumber(link.substring(0, 1)) + " " + hundred + " ";
            }
            if (link.substring(1, 2).equals("1")){
                answer = answer + checkNumber(link.substring(1, 3));
            }
            else {
                if (link.substring(1, 2).equals("0")){
                    if (!link.substring(2, 3).equals("0")){
                        answer = answer + checkNumber(link.substring(2, 3));
                    }
                }
                else {
                    answer = answer + checkTenNumber(link.substring(1, 2));
                    if (!link.substring(2, 3).equals("0")){
                        answer = answer + "-" + checkNumber(link.substring(2, 3));
                    }
                }
            }
        }
        if (link.length() == 2){
            if (link.substring(0, 1).equals("1")){
                return checkNumber(link);
            }
            else {
                answer = checkTenNumber(link.substring(0, 1));
                if (checkNumber(link.substring(1, 2)) != null){
                    answer = answer + "-" + checkNumber(link.substring(1, 2));
                }
                return answer;
            }
        }
        if (link.length() ==1){
            return checkNumber(link);
        }
        return answer;
    }

    private static String checkNumber(String number){
        return  mapOfNumbers.get(Integer.parseInt(number));
    }

    private static String checkTenNumber(String number){
        return mapOfTenNumbers.get(Integer.parseInt(number));
    }

    private static String[] readLine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You enter your number or enter 'ex' if you want to exit from application");
        System.out.print("Enter your number: ");
        String[] answer;
        String line = "";
        while (true){
            line = scanner.nextLine();
            try {
                if (line.equals("ex")) System.exit(0);
                Double.parseDouble(line);
                if (line.contains(".")){
                    answer = line.split("\\.");
                    if (answer[1].length() > 2)
                    answer[1] = answer[1].substring(0, 2);
                } else {
                    answer = new String[2];
                    answer[0] = String.valueOf(Long.valueOf(line));
                    answer[1] = "0";
                }
                break;
            } catch (Exception e){
                System.out.print("Enter valid number: ");
            }
        }
        return answer;
    }

    private static void createMaps(){
        mapOfNumbers.put(1, "one");
        mapOfNumbers.put(2, "two");
        mapOfNumbers.put(3, "three");
        mapOfNumbers.put(4, "four");
        mapOfNumbers.put(5, "five");
        mapOfNumbers.put(6, "six");
        mapOfNumbers.put(7, "seven");
        mapOfNumbers.put(8, "eight");
        mapOfNumbers.put(9, "nine");
        mapOfNumbers.put(10, "ten");
        mapOfNumbers.put(11, "eleven");
        mapOfNumbers.put(12, "twelve");
        mapOfNumbers.put(13, "thirteen");
        mapOfNumbers.put(14, "fourteen");
        mapOfNumbers.put(15, "fifteen");
        mapOfNumbers.put(16, "sixteen");
        mapOfNumbers.put(17, "seventeen");
        mapOfNumbers.put(18, "eighteen");
        mapOfNumbers.put(19, "nineteen");

        mapOfTenNumbers.put(2, "twenty");
        mapOfTenNumbers.put(3, "thirty");
        mapOfTenNumbers.put(4, "forty");
        mapOfTenNumbers.put(5, "fifty");
        mapOfTenNumbers.put(6, "sixty");
        mapOfTenNumbers.put(7, "seventy");
        mapOfTenNumbers.put(8, "eighty");
        mapOfTenNumbers.put(9, "ninety");

        list.add("");
        list.add("thousand");
        list.add("million");
        list.add("billion");
    }
}
