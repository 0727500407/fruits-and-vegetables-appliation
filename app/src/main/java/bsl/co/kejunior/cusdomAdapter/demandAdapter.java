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
import bsl.co.kejunior.Model.Countryproducts;
import bsl.co.kejunior.Model.Demand;
import bsl.co.kejunior.R;

public class demandAdapter extends ArrayAdapter<Demand> implements View.OnClickListener {

    private ArrayList<Demand> dataSet;
    Context mContext;


     private static class ViewHolder {

        TextView txtprodemand;
        TextView txtcountryo;
         TextView txtquantityd;;
        TextView txtqualityd;
        TextView txtcountryd;


    }

    public demandAdapter(ArrayList<Demand> data, Context context) {
        super(context, R.layout.row_demand, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Demand demand=(Demand) object;

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
        Demand demand = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        demandAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.demandAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_demand, parent, false);
            viewHolder.txtprodemand = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtcountryo = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtquantityd = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtqualityd = (TextView) convertView.findViewById(R.id.country1);
            viewHolder.txtcountryd = (TextView) convertView.findViewById(R.id.season);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (demandAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtprodemand.setText(demand.getProdemand());
        viewHolder.txtcountryo.setText(demand.getCountryo());
        viewHolder.txtquantityd.setText(demand.getQuantityd());
        viewHolder.txtqualityd.setText(demand.getQualityd());
        viewHolder.txtcountryd.setText(demand.getCountryd());
        // Return the completed view to render on screen
        return convertView;

    }

}
