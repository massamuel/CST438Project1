package edu.csumb.spoplack.project1samryanjamesjose;

public class User {

    /**
     *
     */

    private String username;
    private String password;
    private String FirstName;
    private String LastName;
    private int UserID;

    public User(String username,String password,String FirstName,String LastName,int UserID) {
        this.username = username;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserID = UserID;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getFirstName() { return FirstName;   }

    public String getLastName() { return LastName;    }

    public int getUserID() { return UserID;    }

    public void setUsername(String uName) {this.username = uName;}

    public void setPassword(String uPass) {this.password = uPass;}

    public void setFirstName(String uFirstName) {this.FirstName = uFirstName;}

    public void setLastName(String uLastName) {this.LastName = uLastName;}

    public void setUserID(int uUID) {this.UserID = uUID;}



}
