import java.sql.SQLException;
import java.util.*;

public class App extends Contacts {

    public static void main(String[] args) throws SQLException{
        db.usedb();
        System.out.println("--------------Contact Management System--------------");
        System.out.println();
        System.out.println("What do you want to do");
        System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4. Delete Contact");
        System.out.println("Choose Option : 1 2 3 4 ");
        
        
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        
        while(option>5){
            System.out.println("Sorry Wrong Input");
            option=sc.nextInt();
        }
        // App chose=new App();
        // chose.choose(option);
        
        ChooseOption.choose(option);
        sc.close();
    
    }
}
