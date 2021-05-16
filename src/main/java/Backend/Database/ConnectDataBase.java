package Backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {
    public static ConnectDataBase connectDataBase;

    public ConnectDataBase () {
    }

    public static ConnectDataBase getConnectDataBase() {
        if (connectDataBase == null) {
            connectDataBase = new ConnectDataBase ();
        }
        return connectDataBase;
    }

    public Connection connectDB (String nameDB) throws ClassNotFoundException, SQLException {
        String user = "root";
        String password = "LexusIS250@#";
        String connextions = "jdbc:mysql://Localhost:3306/";
        connextions = connextions + nameDB + "?serverTimezone=Europe/Moscow";
        Connection connection = DriverManager.getConnection(connextions, user, password);
        return connection;
    }


}
