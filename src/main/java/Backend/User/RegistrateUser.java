package Backend.User;

import java.sql.SQLException;
import java.util.Calendar;

public interface RegistrateUser {
    public void toShareLink ();
    public void registration(String login, String password, String email, String phone, String surname, String name,
                             String patronymic, String birthday, int rating, String dateRegistration, String link) throws SQLException, ClassNotFoundException;
    public void comeIn (String password, String login) throws SQLException;
    public void exit ();
    public void addNewFriends();
}
