package bsl.co.kejunior.cusdomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.Model.Sellers;
import bsl.co.kejunior.R;

public class sellerAdapter extends ArrayAdapter<Sellers> implements View.OnClickListener{

    private ArrayList<Sellers> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtproductse;
        TextView txtsellers;
        TextView txtorigin;
        TextView txtdestination;

    }

    public sellerAdapter(ArrayList<Sellers> data, Context context) {
        super(context, R.layout.row_seller, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Sellers sellers=(Sellers) object;

//      switch (v.getId())
//    {
//        case R.id.item_info:
//            Snackbar.make(v, "Release date " +buyers.getBuyerid(), Snackbar.LENGTH_LONG)
//                    .setAction("No action", null).show();
//            break;
//    }
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Sellers sellers = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        sellerAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new sellerAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_seller, parent, false);
            viewHolder.txtproductse = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtsellers = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtorigin = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtdestination = (TextView) convertView.findViewById(R.id.country1);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (sellerAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproductse.setText(sellers.getProductse());
        viewHolder.txtsellers.setText(sellers.getSellers());
        viewHolder.txtorigin.setText(sellers.getOrigin());
        viewHolder.txtdestination.setText(sellers.getDestination());
        // Return the completed view to render on screen
        return convertView;

    }
}