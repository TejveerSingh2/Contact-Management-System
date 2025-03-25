import java.sql.SQLException;
import java.util.HashMap;

public class createContact extends Contacts {
    @Override
    boolean insert(String name, String number,HashMap<String,String> temp){
        boolean a=super.insert(name, number,temp);
        try {
            db.insertdata(name,Integer.parseInt(number));
        } catch (NumberFormatException | SQLException e) {
            return false;
        }
        return a; 
    }


    // createContact(String name,int number)
    // {
        //// return true;
    //     Contacts a=new Contacts();
    //     a.insert(name, number);
    // }
}
