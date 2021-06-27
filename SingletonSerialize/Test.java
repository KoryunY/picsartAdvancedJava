package SingletonSerialize;

public class Test {
    public static void main(String[] args) {
        User user1=User.getInstance("log","pass",13,true,Country.getInstance("Country"));
        UserService.serializeUser(user1);
        System.out.println("HashCode of serialized User  "+user1.hashCode());
        User p= UserService.deserializeUser();
        System.out.println(p);
        System.out.println("Hashcode of deserialized User  "+p.hashCode());
    }
}
