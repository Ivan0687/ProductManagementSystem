package ua.goit.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "spring_homework", name = "users")
@NamedQueries({@NamedQuery(name = "getAllUsers", query = "FROM User")})
public class User extends BasicEntity {

    @Id
    private String login;

    @Column
    private String password;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    public enum Roles {
        USER, ADMIN
    }

    public User() {
    }

    public User(String login, String username, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", role=" + role +
                '}';
    }
}
