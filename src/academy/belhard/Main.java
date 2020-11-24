package academy.belhard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/db_10?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "101713";


    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AddressConnector connector = new AddressConnector(connection);

        Address address1 = new Address(6, "Moscow", "Pyshkina", 5, 6, 67);
        Address address2 = new Address(7, "Piter", "Lenina", 4, 2, 34);
        Address address3 = new Address(8, "Smolensk", "Minskaya", 5,2, 55);
        Address address4 = new Address(9, "Novgorod", "Rechnaya", 87, 7, 34);
        Address address5 = new Address(10, "Minsk", "Centralnaya", 3, 1, 12);

        connector.add(address1);
        connector.add(address2);
        connector.add(address3);
        connector.add(address4);
        connector.add(address5);

        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (Address p : connector.readAll()) {
            System.out.println(p);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");


        connector.update(new Address(2,"Kirov","Nezavisimosti",45,2,1));
        connector.update(new Address(9,"Soligorsk","Solnechnaya",67,1,55));

        for (Address p : connector.readAll()) {
            System.out.println(p);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");


        connector.delete(5);
        connector.delete(8);

        for (Address p : connector.readAll()) {
            System.out.println(p);
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");


    }
}
