import java.io.File;
import java.util.Scanner;
import domain.*;


public class App {
    public static void main(String[] args) {
        Scanner option = new Scanner(System.in);
        int intChoice;
        boolean boolChoice = true;
        String strChoice;
        App app = new App();
        Set sets;
        // Initial Menu
        System.out.println("""
                    That program is created by Igor Rosa F. Pinto
                    Here you will see an algorithm responsible for making calculations involving Sets.
                    ***
                    You like to create(1) manually the sets or import(2) from an .txt
                    ***
                    Before you choose, if you choose the import option the txt that will be read is the 
                    'externalData.txt' in the package of the application.
                    
                    For that we have some rules to make that process more easy to you, write the data that way:
                    1, 2, 5 , 6 ,-220
                    -13, 14 , 22 
                    
                    1- Create manually the set
                    2- Use the externalData.txt
                    
                    """);
        intChoice = option.nextInt();
            // 1 to create manually and 2 to import options
            if (intChoice == 1) {
                int set[][] = new int[3][];
                set = app.create_manually_sets();
                sets = new Set();
                sets.setSetA(set[0]);
                sets.setSetB(set[1]);
                sets.setSetC(set[2]);
                System.out.println("You have created your set");
                while (boolChoice) {
                    System.out.println("""
                            \n
                            1- To go to 'operations with set'
                            2- To exit to exit the system
                            """);
                    //Menu with options of set
                    intChoice = option.nextInt();
                    if (intChoice == 1) {
                        System.out.println("""
                                1- Belongs
                                2- Properly contained, contained or not contained
                                3- Union
                                4- Intersection
                                5- Cartesian Product
                                6- Difference between
                                7- Parts set
                                """);
                        intChoice = option.nextInt();
                        switch (intChoice){
                            case 1:
                                System.out.println("""
                                        Enter two variables:
                                        1- Enter with 0,1 or 2 for the set
                                        2- Item to be compared
                                        """);
                                int intEnter = option.nextInt();
                                System.out.println("2- Enter the value of the item to be compared");
                                int intEnter2 = option.nextInt();
                                if (sets.belongs(intEnter,intEnter2)){
                                    System.out.println("Item "+intEnter2+" belongs to the set "+intEnter);
                                }else{
                                    System.out.println("Item "+intEnter2+"dont belongs to the set "+intEnter);
                                }
                                break;
                            case 2:
                                System.out.println("""
                                        Enter two variables:
                                        1- Enter with 0,1 or 2 for the first set
                                        2- Enter with 0,1 or 2 for the second set
                                        """);
                                intEnter = option.nextInt();
                                System.out.println("Enter the second set");
                                intEnter2 = option.nextInt();
                                int count = sets.contained(intEnter,intEnter2);
                                if (count == sets.getSize(intEnter)){
                                    if (sets.getSize(intEnter) == sets.getSize(intEnter2)){
                                        System.out.println("Set 1 is contained in set 2");
                                    }else {
                                        System.out.println("Set 1 is properly contained in set 2");
                                    }
                                }else {
                                    System.out.println("Set 1 is not contained in set 2");
                                }
                                break;
                            case 3:
                                System.out.println("""
                                        Enter the number of the first set to be unified
                                        """);
                                intEnter = option.nextInt();
                                System.out.println("Enter the second set");
                                intEnter2 = option.nextInt();
                                int[] unifiedSet = sets.union(intEnter,intEnter2);
                                for(int i = 0; i < unifiedSet.length; i ++){
                                    System.out.println(unifiedSet[i] + ",");
                                }
                                break;
                            case 4:
                                System.out.println("""
                                        Enter the number of the first set""");
                                intEnter = option.nextInt();
                                System.out.println("Enter the number of the second set");
                                intEnter2 = option.nextInt();
                                int[] interArr = sets.intersection(intEnter, intEnter2);
                                for(int i = 0; i < interArr.length; i ++){
                                    System.out.println(interArr[i]+",");
                                }
                                break;
                            case 5:
                                System.out.println("""
                                        Enter the number of the first set""");
                                intEnter = option.nextInt();
                                System.out.println("Enter the number of the second set");
                                intEnter2 = option.nextInt();
                                int[] prd = sets.cartesianProduct(intEnter, intEnter2);
                                for (int i = 0; i < prd.length/2; i ++){
                                    System.out.println("("+prd[i]+prd[i+1]+")");
                                }
                                System.out.println("""
                                        You want to reverse it ?
                                        1- Yes
                                        2- No
                                        """);
                                intEnter = option.nextInt();
                                if (intEnter == 1){
                                    int[] set1 = new int[0];
                                    int[] set2 = new int[0];
                                    for (int i = 0; i < prd.length/2; i++){
                                        set1 = app.expandVector(set1,prd[i]);
                                        set2 = app.expandVector(set2, prd[i+1]);
                                    }
                                    System.out.println("Your sets now is");
                                    for (int i =0;i < set1.length;i++){
                                        System.out.print(set1[i]);
                                    }
                                    for (int i = 0; i< set2.length; i ++){
                                        System.out.print(set2[i]);
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("""
                                        Enter the number of the first set""");
                                intEnter = option.nextInt();
                                System.out.println("Enter the number of the second set");
                                intEnter2 = option.nextInt();
                                int[] result = sets.differenceBetween(intEnter, intEnter2);
                                System.out.println("The items above dont belongs to the second set");
                                for (int i = 0; i < result.length; i++){
                                    System.out.println(result[i]+",");
                                }
                                break;
                            case 7:
                                System.out.println("""
                                        Enter the number of the set""");
                                intEnter = option.nextInt();
                                int[][] powerSet = sets.powerSet(intEnter);
                                for (int i = 0; i < powerSet.length; i++){
                                    System.out.println("{");
                                    for (int j = 0; j < powerSet[i].length; i++){
                                        System.out.println(powerSet[i]+",");
                                    }
                                    System.out.println("},");
                                }
                                break;
                        }

                    } else if (intChoice == 2) {
                        throw new IllegalArgumentException("Thank you for testing this project");
                    }
                }
            }

            if (intChoice == 2){
                System.out.println("""
                        Reading data from 'externalData.txt'
                        """);
                File file = new File(
                        "C:\\Users\\Igor\\Desktop\\github\\Algebra_of_sets\\src\\main\\java\\externalData.txt"
                );
            }
            //else throw new IllegalArgumentException("Invalid option");

        }


    public int[][] create_manually_sets() {
        Scanner option = new Scanner(System.in);
        int intScan;
        int itemFromUser;


        System.out.println("You choose the option to create manually the Set");
        System.out.println("""
                We can create 3 sets:
                1- To create 1 set
                2- To create 2 sets
                3- To create 3 sets
                """);
        intScan = option.nextInt();

        int[][] sets = new int[3][];

        switch (intScan) {
            case 1:
                sets[0] = create_set();
                System.out.println("You created your set");
                break;
            case 2:
                sets[0] = create_set();
                sets[1] = create_set();
                System.out.println("You created your set");
                break;
            case 3:
                sets[0] = create_set();
                sets[1] = create_set();
                sets[2] = create_set();
                System.out.println("You created your set");
                break;
        }
        return sets;
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

    public int[] create_set(){
        Scanner option = new Scanner(System.in);
        int intChoice;
        System.out.println("Enter the size of your set");
        intChoice= option.nextInt();
        int[] set = new int[intChoice];
        for (int i = 0; i < intChoice; i++){
            System.out.println("Enter the value of the [" + i + "] position");
            set[i] = option.nextInt();
        }
        System.out.println();
        return set;
    }
}
