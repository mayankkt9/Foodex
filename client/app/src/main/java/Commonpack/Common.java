package Commonpack;

/**
 * Created by mayankkataruka on 14/03/18.
 */

public class Common {
    public static String currentUser;

    public static String convertcodetostatus(String code)
    {
        if(code.equals("0"))
            return "Placed";
        else if(code.equals("1"))
            return "Processing";
        else
            return "Completed";
    }
}
