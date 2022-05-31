package singleton;
//* EXAMPLE OF SINGLETON DESIGN PATTERN (IT IS A CREATIONAL DESIGN PATTERN)
//  In Every Project All the classes access a single Database, so we create only one
//  instance of Database Object.
// */
public class Database {
    private static Database database;
    // private Construction so User can't create Object using new Keyword.
    private Database(){

    }

    public static Database getInstance(){
        //if instance is null then create an object
        if(database == null){
            database = new Database();
        }
        return  database;
    }

    public void getConnection(){
        System.out.println("Connected to Database");
    }
}
