package ribboncafe.ribbon.com.ribboncafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.Request;
import ViewHolder.OrderViewHolder;

public class OrderStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference requests;

    FirebaseAuth auth;

    FirebaseRecyclerAdapter<Request, OrderViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        requests=database.getReference("Requests");


        recyclerView=(RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String email=auth.getCurrentUser().getEmail();
        loadOrders(email);

    }

    private void loadOrders(String email) {

        adapter=new FirebaseRecyclerAdapter<Request, OrderViewHolder>(
                Request.class,
                R.layout.order_layout,
                OrderViewHolder.class,
                requests.orderByChild("email").equalTo(email)

        ) {
            @Override
            protected void populateViewHolder(OrderViewHolder viewHolder, Request model, int position) {
                viewHolder.txtOrderId.setText(adapter.getRef(position).getKey());
                viewHolder.txtOrderstatus.setText(convertcodetostatus(model.getStatus()));
                viewHolder.txtOrderNote.setText(model.getNote());
                viewHolder.txtOrderEmail.setText(model.getEmail());


            }
        };
        recyclerView.setAdapter(adapter);
    }

    private String convertcodetostatus(String code)
    {
        if("0".equals(code))
            return "Placed";
        else if("1".equals(code))
            return "Processing";
        else
            return "Completed";
    }
}
