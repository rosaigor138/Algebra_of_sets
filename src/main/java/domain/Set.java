package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Set {
    private int setA[];
    private int setB[];
    private int setC[];
    private int invalidValueRepresantation = 999999;
    public Set(){
        this.setA = new int[0];
        this.setB = new int[0];
        this.setC = new int[0];
    }

    public void setSetA(int[] setA) {
        this.setA = setA;
    }

    public void setSetB(int[] setB) {
        this.setB = setB;
    }

    public void setSetC(int[] setC) {
        this.setC = setC;
    }
    public int getSize(int set){
        if (set == 0){return setA.length;}if (set == 1){return setB.length;}if (set == 2){return setC.length;}
        return 0;
    }

    /*
    public void normalizeSet(){
        int comparedItem;
        for (int i = 0; i < setA.length; i++){
            comparedItem = setA[i];
            for (int j = 0; j < setA.length-1; j++){
                if (setA[i] != j){
                    if (comparedItem == setA[j]){
                        setA[j]
                    }
                }
            }
        }
    }

     */

    public int[] union(int set1, int set2){
        int auxiliar1[] = new int[0];
        int auxiliar2[] = new int[0];
        int auxiliar3[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        if (set2 == 0){auxiliar2 = setA;}if (set1 == 1){auxiliar2 = setB;}if (set1 == 2){auxiliar2 = setC;}
        ///ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(auxiliar1));
        for (int i =0; i < auxiliar2.length; i ++){
            if (!belongs(set1,auxiliar2[i])){

            }
        }return auxiliar1;// temp
    }
    public int contained(int set1, int set2){
        int count = 0;
        int auxiliar1[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        for (int i = 0; i < auxiliar1.length; i++){
            if (belongs(set2, auxiliar1[i])){
                count++;
            }
        }
        return count;
    }
    public boolean belongs(int set, int x){
        if (set == 0){
            for (int i = 0; i < setA.length; i++){
                if (x == setA[i]){return true;}
            }
        }
        if (set == 1){
            for (int i = 0; i < setB.length; i++){
                if (x == setB[i]){return true;}
            }
        }
        if (set == 2){
            for (int i = 0; i < setC.length; i++){
                if (x == setC[i]){return true;}
            }
        }
        return false;
    }
    public void printAllData() {
        int[][] data = new int[3][];
        data[0] = this.setA;
        data[1] = this.setB;
        data[2] = this.setC;
        try{
            for (int[] arr: data) {
                for (int n : arr) {
                    System.out.print(n + " ");
                }
            }}
        catch(Exception e){
            System.out.println("");
            }
        }
    }

