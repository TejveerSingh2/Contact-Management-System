import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class ChooseOption {
       
    static void choose(int option) throws NumberFormatException, SQLException{
        Scanner sc=new Scanner(System.in);
        HashMap<String,String> file=new HashMap<>();
       
        while(option!=5){

            switch (option) {
                case 1:
    
                //* Cretaing a new Contact if already exists return false else true */
                    System.out.print("Name of the Person : ");
                    String name=sc.next();
                    System.err.print("Number : ");
                    String number=sc.next();
                    createContact create=new createContact();
                    boolean check=create.insert(name, number,file);
                    if(!check) System.out.println("Person is Already Exists");
                    else System.out.println("Number is Added");

                    System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4.Delete Contact  5.Exit");
                    option=sc.nextInt();
                    break;
                    
                case 2:
               
                    //* Reading a contact of a number */
                    System.out.print("Name of the Person : ");
                    name=sc.next();
                    readContact read=new readContact();
                    System.out.println(read.read(name,file));
                    System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4.Delete Contact  5.Exit");
                    option=sc.nextInt();
                    break;
                case 3:
    
                    //* Updating a Contact of a Person */
                    System.out.print("Name of the Person : ");
                    name=sc.next();
                    System.out.print("New Number : ");
                    String number1=sc.next();
                    updateContact update=new updateContact();
                    update.update(name, number1,file);
                    System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4.Delete Contact  5.Exit");
                    option=sc.nextInt();
                    break;
                case 4:
    
                    //* Deleting a Contact */
                    System.out.print("Name of the Person : ");
                    name=sc.next();
                    deleteContact delete=new deleteContact();
                    delete.delete(name,file);
                    System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4.Delete Contact  5.Exit");
                    option=sc.nextInt();
                    break;

                case 5:
                break;
                
                default:
                System.out.println("Sorry Wrong Input");
                System.out.println("1.Create contact  2.Read Contact  3.Update Contact  4.Delete Contact  5.Exit");
                option=sc.nextInt();
                break;
            }
            // System.out.println("Thank You for Coming here !");
        }
        
            sc.close();
    }

}