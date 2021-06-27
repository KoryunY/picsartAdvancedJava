
package SingletonSerialize;

import java.io.Serializable;

public class User implements Serializable {
    private static User instance;
    private String login;
    private transient String password;
    private int year;
    private boolean isAdmin;
    private Country country;


    private User(String login, String password, int year, boolean isAdmin, Country country) {
        this.login = login;
        this.password = password;
        this.year = year;
        this.isAdmin = isAdmin;
        this.country = country;
    }

    public static User getInstance(String login, String password, int year, boolean isAdmin, Country country){
        if(instance==null){
            synchronized (User.class){
                if (instance==null){
                    instance=new User( login,  password,  year,  isAdmin,  country);
                }
            }
        }
        return instance;
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", year=" + year +
                ", isAdmin=" + isAdmin +
                ", country=" + country +
                '}';
    }
    protected Object readResolve()
    {
        return instance;
    }
}
