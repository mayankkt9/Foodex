package Model;

import java.util.List;

/**
 * Created by mayankkataruka on 15/03/18.
 */

public class Request {

    private String email,note,total,status;
    private List<Order> foods;

    public Request()
    {

    }

    public Request(String email, String note, String total, List<Order> foods) {
        this.email = email;
        this.note = note;
        this.total = total;
        this.foods = foods;
        this.status="0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
