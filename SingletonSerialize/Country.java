package SingletonSerialize;

import java.io.Serializable;

public class Country implements Serializable {
    private static Country instance;
    private String cName;

    private Country(String cName) {
        this.cName = cName;
    }
    public static Country getInstance(String cName){
        if(instance==null){
            synchronized (User.class){
                if (instance==null){
                    instance=new Country(cName);
                }
            }
        }
        return instance;
    }
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cName='" + cName + '\'' +
                '}';
    }
}
