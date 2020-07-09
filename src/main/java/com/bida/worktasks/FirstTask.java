package com.bida.worktasks;

import java.util.Random;
import java.util.Scanner;

public class FirstTask {

    private static int[][] frame;
    private static int frame_width;
    private static int frame_height;
    private static int pic_width;
    private static int pic_height;
    private static int pic_x;
    private static int pic_y;


    public static void start(){
        while (true) {
            enterMainValues();
            if (validateEnterData()) break;
        }
        createRandomFrame();
        printFrame();
        changeValuesInFrame();
        printFrame();
    }

    private static void changeValuesInFrame(){
        for(int i = 0;  i < pic_height; i++){
            for(int l = 0; l < pic_width; l++){
                frame[i][l] = frame[i + pic_y][l + pic_x];
            }
        }
    }

    private static void createRandomFrame(){
        frame = new int[frame_height][frame_width];
        for (int i = 0; i < frame_height; i++){
            for (int l = 0; l < frame_width; l++){
                frame[i][l] = (int) (Math.random() * 89) + 10;
            }
        }
    }

    private static void enterMainValues(){
        frame_width = readValues("Frame Width");
        frame_height = readValues("Frame Height");
        pic_height = readValues("Pic Height");
        pic_width = readValues("Pic Width");
        pic_x = readValues("Pic X");
        pic_y = readValues("Pic Y");
        System.out.println(frame_height + " " + frame_width);
    }

    private static int readValues(String line) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of " + line + ": ");
        int answer = 0;
        while (true) {
            String v = scanner.nextLine();
            try {
                answer = Integer.parseInt(v);
                if (answer < 0) throw new Error();
                break;
            } catch (Exception e) {
                System.out.print("Enter pasende value of " + line + ": ");
            }
        }
        return answer;
    }

    private static boolean validateEnterData(){
        return pic_height + pic_y < frame_height && pic_width + pic_x < frame_width;
    }

    private static void printFrame() {
        System.out.print("Your Frame:\n    ");
        for (int i = 0; i < frame_width; i++){
            System.out.print(i  + "   ");
        }
        System.out.println();
        for (int i = 0; i < frame_height; i++) {
            System.out.print(i + "   ");
            for (int l = 0; l < frame_height; l++) {
                System.out.print(frame[i][l] + "  ");
            }
            System.out.println();
        }
    }
}
