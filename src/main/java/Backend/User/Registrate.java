package Backend.User;

import Backend.Database.ConnectDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class Registrate extends UserClass implements RegistrateUser{
    public Registrate(String login, String password, String email, String phone, String surname, String name, String patronymic, String birthday, int rating, String dateRegistration, String link) throws SQLException, ClassNotFoundException {
        super(id, login, password, email, phone, surname, name, patronymic, birthday, rating, dateRegistration, link);
    }
    private ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
    private Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
    private Statement statement = connection.createStatement();

    @Override
    public void toShareLink() {

    }

    @Override // регистрация первых пользователей по самым первым ссылкам. Идентификация по ссылке, проверка на то, что ссылка не передавалась и ранее не использовалась.
    public void registration( String login, String password, String email, String phone, String surname, String name,
                             String patronymic, String birthday, int rating, String dateRegistration, String link) throws SQLException, ClassNotFoundException {
        UserClass newUserRegistrate = new UserClass(UserClass.id, login, password, email, phone, surname, name,
                patronymic, birthday, rating, dateRegistration, link);

        String linkSQL = "";
        String result = "";
        int idLink = 0;
        int linkCount = 1;
        String linkTransfer = "";
        int usingLink = 0;
        ResultSet resultSet = statement.executeQuery(String.format("select id_number, numberPhoneUser, linkTransfer, usingLink from firstLink where link = '%s';", link));
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            idLink = resultSet.getInt(1);
            result = resultSet.getString(2);
            linkTransfer =  resultSet.getString(3);
            usingLink = resultSet.getInt(4);

        }
        if (newUserRegistrate != null && linkTransfer == null && usingLink == 0) {

            statement.executeUpdate(String.format("insert into GoodUser values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",id, login, password, email, phone, surname, name,
                    patronymic, birthday, rating, dateRegistration));
            statement.executeUpdate(String.format("insert into GoodUsers values('%s', '%s');",id, login));
            statement.executeUpdate(String.format("insert into GoodLink values('%s', '%s', '%s', '%s');",id, rating, linkCount, dateRegistration));
            System.out.println("пользователь зарегистрирован");
        }

    }

    @Override //вход зарегистрированного пользователя
    public void comeIn(String password, String login) throws SQLException {
        String password2 = "";
        ResultSet resultSet = statement.executeQuery(String.format("select password from GoodUser where login = '%s';", login));
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            password2 = resultSet.getString(1);
        }
        if (password2 == password) {
            // открываем доступ к приложению
            System.out.println("доступ разрешен");
        }
    }

    @Override
    public void exit() {

    }

    @Override
    public void addNewFriends() {

    }
    //регистрация пользователя

}
