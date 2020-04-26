import java.sql.*;
import java.util.HashMap;

/**
 * Created by anton on 25.04.2020.
 */
public class Connector {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=Europe/Kiev";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public Connector() {
    }

    public String result (HashMap<String, String> apt) {
        String result = "";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement =
                connection.createStatement()) {
            if (!connection.isClosed()) {
                System.out.println("Oll good!");
            }
            String querie = "SELECT * FROM appartments WHERE ";
            String next = " VALUE (";
            int num = 0;
            for (String value : apt.keySet()) {
                if (apt.get("marker").equals("search")) {
                    if(apt.get(value).equals("search")){continue;}
                    if (num != 0) {
                        querie += "AND " + value + " = " + "'" + apt.get(value) + "' ";
                    } else {
                        querie += value + " = " + "'" + apt.get(value) + "' ";
                        num++;
                    }
                }else {
                    if (apt.get(value).equals("app")){continue;}
                    if(num == 0){querie ="INSERT INTO appartments (";}
                    num++;
                    querie += value + ", ";
                    next += "'" + apt.get(value) + "'" + ", ";
                    if(num == 7){
                        querie = querie.substring(0, querie.length() - 2) + ")";
                        next = next.substring(0, next.length() - 2) + ")";
                        querie += next;
                        num = -1;
                    }

                }
            }
            querie = querie + ";";
            if(num > 0) {
                ResultSet set = statement.executeQuery(querie);
                while (set.next()) {
                    int id = set.getInt("id");
                    String region = set.getString("region");
                    String sity = set.getString("sity");
                    String district = set.getString("district");
                    String street = set.getString("street");
                    int numberHous = set.getInt("numberHous");
                    int floor = set.getInt("floor");
                    int numberAppartment = set.getInt("numberAppartment");
                    result += "[id: " + id + ", region: " + region + ", sity: " + sity + ", district: " + district +
                            ", street: " + street + ", number hous: " + numberHous + ", floor: " + floor +
                            ", room count: " + numberAppartment + "]\n";
                }
            }else {
                statement.execute(querie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }






        return result;
    }

}
