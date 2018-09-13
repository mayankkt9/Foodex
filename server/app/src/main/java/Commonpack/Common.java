package Commonpack;

/**
 * Created by mayankkataruka on 14/03/18.
 */

public class Common {
    public static String currentUser;
    public static String convertcodetostatus(String code)
    {
        if("0".equals(code))
            return "Placed";
        else if("1".equals(code))
            return "On My Way";
        else
            return "Shipped";
    }
}
