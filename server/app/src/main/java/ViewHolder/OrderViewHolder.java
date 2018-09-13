package ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import Interface.ItemClickListener;
import ribboncafe.ribbon.com.eatserver.R;

/**
 * Created by mayankkataruka on 15/03/18.
 */



public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener {

    public TextView txtOrderId,txtOrderStatus,txtemail,txtnote;
    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView)
    {
        super(itemView);

        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus=(TextView)itemView.findViewById(R.id.order_status);
        txtemail=(TextView)itemView.findViewById(R.id.order_email);
        txtnote=(TextView)itemView.findViewById(R.id.order_note);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);


    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View view) {

        Log.w("myApp", "no network ----------------");
        itemClickListener.onClick(view,getAdapterPosition(),false);
        Log.w("myApp", "xx");

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        Log.w("myApp", "yy");
        contextMenu.setHeaderTitle("Select the Action");
        contextMenu.add(0,0,getAdapterPosition(),"Update");
        contextMenu.add(0,1,getAdapterPosition(),"Delete");
        Log.w("myApp", "zz");



    }
}
