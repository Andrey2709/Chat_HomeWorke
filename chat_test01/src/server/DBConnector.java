package server;

import java.sql.*;
import java.util.List;

public class DBConnector {
    private static final String DB_url = "jdbc:sqlite:ChatAuth01.db";
    private static Connection connection;
    private static Statement stat;
    private static final String select = "SELECT*FROM Auth WHERE login =? AND password=?;";
    private static final String select_all = "SELECT*FROM Auth;";
    private Server server;
    private Castomer c;


    public DBConnector() {

        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            throw new RuntimeException("Неудалось подключиться к базе данных");
        }

        if (connection != null) System.out.println("База данных подключена");


    }


    public Castomer select_user(String login, String password) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(select);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    this.server.castomers.add(c = new Castomer(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)));

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;

    }


}



