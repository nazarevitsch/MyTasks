package com.bida.worktasks.ThirdTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ThirdTask {
    private static File file1 = new File("Files for third task/Treasure_1_Small.in");
    private static File file2 = new File("Files for third task/Treasure_2_Large.in");


    public static void start(){
        readFile(file1);
    }


    private static void readFile(File currentFile){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(currentFile))) {
            String line = "";
            int numbersOfTests = Integer.parseInt(bufferedReader.readLine());
            for (int test = 0; test < numbersOfTests; test++){
                line = bufferedReader.readLine();
                int numberStartKeys = Integer.parseInt(line.split(" ")[0]);
                int numberChest = Integer.parseInt(line.split(" ")[1]);
                List<String> keys = new ArrayList<>();
                line = bufferedReader.readLine();
                for(int key = 0; key < numberStartKeys; key++){
                    keys.add(line.split(" ")[key]);
                }
                List<Chest> chests = new ArrayList<>();
                for (int chest = 0; chest < numberChest; chest++){
                    chests.add(new Chest(bufferedReader.readLine(), chest));
                }

                runTest(chests, keys, test + 1);
            }
        } catch (Exception e){
            System.out.println("It happens something bad!!!");
        }
    }

    private static void runTest(List<Chest> chests, List<String> keys, int numberOfTest){
        String answer = "Case #" + numberOfTest + ": ";
        boolean end = false;
        while (!end) {
            end = true;
            Chest chest = new Chest();
            String keyForRemoving = "";
            for (int i = 0; i < keys.size(); i++) {
                for (int l = 0; l < chests.size(); l++){
                    if (keys.get(i).equals(chests.get(l).getKeyForOpening())) {
                        if (chests.get(l).getAmountOfKeys() > chest.getAmountOfKeys()) {
                            chest = chests.get(l);
                            keyForRemoving = keys.get(i);
                            end = false;
                        }
                    }
                }
            }
            keys.remove(keyForRemoving);
            keys = addAllKeys(keys, chest.getKeys());
            chests = deleteChest(chests, chest);
            if (chest.getChestIndex() != 0) {
                answer = answer + (chest.getChestIndex() + 1) + " ";
            }
        }
        if (chests.size() == 0) {
            System.out.println(answer);
        } else {
            System.out.println("Case #" + numberOfTest + ": IMPOSSIBLE");
        }
    }

    private static List<String> addAllKeys(List<String> personsKeys, List<String> chestsKeys){
        for (int i = 0; i < chestsKeys.size(); i++){
            personsKeys.add(chestsKeys.get(i));
        }
        return personsKeys;
    }

    private static List<Chest> deleteChest(List<Chest> chests, Chest chest){
        for (int i = 0 ; i < chests.size(); i++){
            if (chests.get(i).getChestIndex() == chest.getChestIndex()){
                chests.remove(i);
                break;
            }
        }
        return chests;
    }
}