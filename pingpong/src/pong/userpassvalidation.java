package pong;

public class userpassvalidation {

   private user name;



    public userpassvalidation(){
    }


    public userpassvalidation(user name){
        //setting attributes values directly)
      this.name = name;
    }
    //accessor methods
    public user getname() {
        return name;
    }
    public void setName(user name) {
        this.name = name;
    }
}
