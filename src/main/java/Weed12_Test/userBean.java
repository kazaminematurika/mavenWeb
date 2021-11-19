package Weed12_Test;

import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
public class userBean {
    private String user;
    private String password;
    private String realName;
    private String gender;
    private Vector vector;

    public userBean() {
    }


    public String getUser() {
        return user;
    }

    public void setUser(String User) {
        user = User;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password = Password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String RealName) {
        realName = RealName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        gender = Gender;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector Vector) {
        vector = Vector;
    }
}
