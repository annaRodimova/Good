package Backend.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserClass {
    public static int id = 0;
    private String surname = "";
    private String name = "";
    private String patronymic = "";
    private String login = "";
    private String password = "";
    private String email = "";
    private String phone = "";
    private String birthday = "";
    private String dateRegistration = "";
    private int rating = 0;
    private String link = "";

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public int getRating() {
        return rating;
    }

    public UserClass (int id1, String login, String password, String email, String phone, String surname, String name,
                       String patronymic, String birthday, int rating, String dateRegistration, String link) {
        id = id +1;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rating = 0;
        this.dateRegistration = dateRegistration;
        this.link = link;
    }
}
