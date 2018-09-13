package Model;

/**
 * Created by mayankkataruka on 14/03/18.
 */

public class Foods {
    private String Image,MenuId,Name,Price;

    public Foods()
    {

    }

    public Foods(String image, String menuId, String name, String price) {
        Image = image;
        MenuId = menuId;
        Name = name;
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public String getMenuId() {
        return MenuId;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
