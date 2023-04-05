import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner option = new Scanner(System.in);
        int intChoice;
        boolean boolChoice;
        String strChoice;

        System.out.println("""
                That program is created by Igor Rosa F. Pinto
                Here you will see an algorithm responsible for making calculations involving Sets.
                You like to create(1) manually the sets or import(2) from an .txt
                Before you choose, if you choose the import option the txt that will be read is the 
                'externalData.txt' in the package of the application.
                
                For that we have some rules to make that process more easy to you, write the data that way:
                1, 2, 5 , 6 ,-220
                -13, 14 , 22 
                Insert on one line the data you wanna in every one of those 
                
                """);
        intChoice = option.nextInt();
        if (intChoice == 1){

        }
        if (intChoice == 2){
            System.out.println("""
                    Reading data from 'externalData.txt'
                    """);
            File file = new File(
                    "C:\\Users\\Igor\\Desktop\\github\\Algebra_of_sets\\src\\main\\java\\externalData.txt"
            );
        }
        if (intChoice != 1 || intChoice != 2){
            throw new IllegalArgumentException("You typed an wrong option");
        }
    }
}
