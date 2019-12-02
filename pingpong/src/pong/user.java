package pong;

import java.io.*;  // needed for saving arrays of users to file
/** minimal class which models a user */
public class user implements Serializable{  // needed for saving

    private String user;
    private String pass;
    private int score1;
    private int score2;
    public user(){

    }
    public user(String user,String pass,int score1, int score2){
        this.user = user;
        this.pass = pass;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String toString(){
        return user + " " + pass +" "+ score1 + " " + score2 + " ";
    }
    //accessor methods
    public String getuser() {
        return user;
    }

    public void setuser(String user) {
      this.user = user;
    }

    public String getpass() {
        return user;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }




}