import java.util.HashMap;
// import java.util.Map;

class Contacts {
    // Map<String,String> file=new HashMap<>();
    
    boolean insert(String name,String number,HashMap<String,String> file){
        if(file.containsKey(name)) return false;
        file.put(name,number);
        System.out.println(file);
        return true;
    }
    String read(String name,HashMap<String,String> file){
        if(file.containsKey(name)) return file.get(name);

        else return "Person not Exists";
    }


    void delete(String name,HashMap<String,String> file){
        file.remove(name,file.get(name));
    }
    void update(String name,String number,HashMap<String,String> file){
        file.put(name,number);
    }
   
}
