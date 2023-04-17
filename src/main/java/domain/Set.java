package domain;

public class Set {
    private int setA[];
    private int setB[];
    private int setC[];

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

    public int[] union(int set1, int set2){
        int auxiliar1[] = new int[0];
        int auxiliar2[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        if (set2 == 0){auxiliar2 = setA;}if (set2 == 1){auxiliar2 = setB;}if (set2 == 2){auxiliar2 = setC;}
        int[] unionArray = new int[auxiliar1.length];
        for (int i =0; i < auxiliar2.length; i ++){
            if (!belongs(set1,auxiliar2[i])){
                unionArray = expandVector(unionArray, auxiliar2[i]);
            }
        }return unionArray;
    }
    public int[] intersection(int set1, int set2){
        int auxiliar1[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        int[] interArr = new int[0];
        for (int i = 0; i < auxiliar1.length; i ++){
            if (belongs(set2,auxiliar1[i])){
                interArr = expandVector(interArr,auxiliar1[i]);
            }
        }return interArr;
    }
    public int[][] powerSet(int set1) {
        int auxiliar1[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        int tamanhoConjunto = auxiliar1.length;
        int tamanhoConjuntoDasPartes = 1 << tamanhoConjunto;
        int[][] conjuntoDasPartes = new int[tamanhoConjuntoDasPartes][];

        for (int i = 0; i < tamanhoConjuntoDasPartes; i++) {
            int tamanhoSubconjunto = Integer.bitCount(i);
            int[] subconjunto = new int[tamanhoSubconjunto];
            int indice = 0;

            for (int j = 0; j < tamanhoConjunto; j++) {
                if ((i & (1 << j)) != 0) {
                    subconjunto[indice++] = auxiliar1[j];
                }
            }

            conjuntoDasPartes[i] = subconjunto;
        }

        return conjuntoDasPartes;
    }

    public int[] cartesianProduct(int set1, int set2){
        int auxiliar1[] = new int[0];
        int auxiliar2[] = new int[0];

        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        if (set2 == 0){auxiliar2 = setA;}if (set2 == 1){auxiliar2 = setB;}if (set2 == 2){auxiliar2 = setC;}
        int[] result = new int[0];
        for (int i = 0; i < auxiliar1.length; i ++){
            for (int j = 0; j < auxiliar2.length; j++){
                result = expandVector(result,auxiliar1[i],auxiliar2[j]);
            }
        }return result;
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
    public int[] differenceBetween(int set1, int set2){
        int auxiliar1[] = new int[0];
        int auxiliar2[] = new int[0];
        int result[] = new int[0];
        if (set1 == 0){auxiliar1 = setA;}if (set1 == 1){auxiliar1 = setB;}if (set1 == 2){auxiliar1 = setC;}
        if (set2 == 0){auxiliar2 = setA;}if (set2 == 1){auxiliar2 = setB;}if (set2 == 2){auxiliar2 = setC;}
        for (int i = 0; i < auxiliar1.length; i ++){
            if (!belongs(set2,auxiliar1[i])){
                result = expandVector(result,auxiliar1[i]);
            }
        }return result;
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
    public int[] expandVector(int[] arr, int item) {
        int n = arr.length;
        int[] newArr = new int[n+1];

        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = item;

        return newArr;
    }
    public int[] expandVector(int[] arr, int item,int item2) {
        int n = arr.length;
        int[] newArr = new int[n+2];

        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = item;
        newArr[n+1] = item2;

        return newArr;
    }
    }

