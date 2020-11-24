package academy.belhard;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private final Connection connection;
    private static final String ADD = "INSERT INTO addresses (id,town,street,number_house,number_corpus,number_flat) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String REQUEST = "SELECT * FROM addresses";


    public AddressConnector(Connection connection) {
        this.connection = connection;
    }

    public void add(Address address) {
        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setInt(1, address.getId());
            statement.setString(2, address.getTown());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getNumber_house());
            statement.setInt(5, address.getNumber_corpus());
            statement.setInt(6, address.getNumber_flat());

            int res = statement.executeUpdate();

            System.out.println(res);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {

            ResultSet result = statement.executeQuery();

            while ( result.next() ) {
                int id = result.getInt("id");
                String town = result.getString("town");
                String street = result.getString("street");
                int number_house = result.getInt("number_house");
                int number_corpus = result.getInt("number_corpus");
                int number_flat = result.getInt("number_flat");

                Address address = new Address(id, town, street, number_house, number_corpus, number_flat);

                res.add(address);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void delete(int id) {

        String str = Integer.toString(id);

       String DELETE = "DELETE FROM addresses WHERE id = " +str  ;


        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            int res = statement.executeUpdate();

            System.out.println(res);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Address address) {

        String str = Integer.toString(address.getId());

        String UPDATE = "UPDATE  addresses SET town = "+"'"+address.getTown()+"'" + ", street = " +"'" +address.getStreet()+"'" +",number_house = " + "'"+ address.getNumber_house()+"'" + ",number_corpus =" +"'"+ address.getNumber_corpus()+"'" + ",number_flat =" +"'"+ address.getNumber_flat()+"'" + "WHERE id =" + str;

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            int res = statement.executeUpdate();

            System.out.println(res);

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }


