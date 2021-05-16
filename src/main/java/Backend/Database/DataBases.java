package Backend.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBases {
    public String selectDB () throws SQLException, ClassNotFoundException {
        ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
        Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select login from GoodUser;");
        String result = "";
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            result = resultSet.getString(1);
        }
        return  result;
    }
}
