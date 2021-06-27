package SingletonSerialize;

import java.io.*;

public class UserService {
    private static final String FILE_NAME="user";
    public static void serializeUser(User user){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream(FILE_NAME);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static User deserializeUser(){
        User user=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis=new FileInputStream(FILE_NAME);
            ois=new ObjectInputStream(fis);
            Object object=ois.readObject();
            user=(User) object;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois!=null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}
