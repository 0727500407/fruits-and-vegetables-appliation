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
import bsl.co.kejunior.R;


public class CusdomBuyer extends ArrayAdapter< Buyers> implements View.OnClickListener{

    private ArrayList<Buyers> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtproduct;
        TextView txtbuy;
        TextView txtorigin;
        TextView txtdestination;

    }

    public CusdomBuyer(ArrayList<Buyers> data, Context context) {
        super(context, R.layout.row_buyer, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Buyers buyers=(Buyers) object;

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
        Buyers buyers = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_buyer, parent, false);
            viewHolder.txtproduct = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtbuy = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtorigin = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtdestination = (TextView) convertView.findViewById(R.id.country1);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproduct.setText("Product Name:"+buyers.getProduct());
        viewHolder.txtbuy.setText("Buyers Name:"+buyers.getBuy());
        viewHolder.txtorigin.setText("Country Origin:"+buyers.getOrigin());
        viewHolder.txtdestination.setText("Country Destination:"+buyers.getDestination());

//         Return the completed view to render on screen
        return convertView;

    }
}