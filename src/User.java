public abstract class User implements Observer {
    private String name;
    private String password;
    private long ID;
    private boolean conncted;

    public User(String name, Long id, String password){
        if ((id<100000000)||(id>1000000000))throw new RuntimeException("not valid id");
        if ((password.length()<4)||(password.length()>8))throw new RuntimeException("not valid password");
        this.ID=id;
        this.name=name;
        this.password=password;
        conncted=true;
    }
    public void login(Long id,String password){
      if (this.password.equals(password)&&id==this.ID){
          conncted=true;
          System.out.println("you connected");
      }
      else {
          System.out.println("the password or the id is not equal");
      }
    }
    public void logout(){
        conncted=false;
    }

}
