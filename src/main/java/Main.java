import Backend.Database.DataBases;
import Backend.User.Registrate;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Registrate user1 = new Registrate("rodimova", "111g", "sss@mail.ru","9040437670","Родимова",
                "Анна", "Ивановна", "1993-12-15", 1, "2021-05-11", "app.com/userInvite1");
        user1.registration("rodimova", "111g", "sss@mail.ru","9040437670","Родимова",
                "Анна", "Ивановна", "1993-12-15", 1, "2021-05-11", "app.com/userInvite1");

    }
}
