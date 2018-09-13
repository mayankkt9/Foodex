package ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import Interface.ItemClickListener;
import ribboncafe.ribbon.com.ribboncafe.R;

/**
 * Created by mayankkataruka on 15/03/18.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtOrderId,txtOrderstatus,txtOrderEmail,txtOrderNote;
    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);

        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderEmail=(TextView)itemView.findViewById(R.id.order_email);
        txtOrderstatus=(TextView)itemView.findViewById(R.id.order_status);
        txtOrderNote=(TextView)itemView.findViewById(R.id.order_note);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }


    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
