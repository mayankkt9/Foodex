package Model;

/**
 * Created by mayankkataruka on 14/03/18.
 */

public class Category {

    private String Name;
    private String Image;

    public Category()
    {

    }
    public Category(String Name, String Image) {
        this.Name = Name;
        this.Image = Image;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
}
