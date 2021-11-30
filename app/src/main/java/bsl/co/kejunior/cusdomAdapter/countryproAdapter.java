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
import bsl.co.kejunior.R;

public class countryproAdapter  extends ArrayAdapter<Countryproducts> implements View.OnClickListener{

    private ArrayList<Countryproducts> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtproname;
        TextView txtcountrypro;
        TextView txtquantity;
        TextView txtdat;
        TextView txtseason;

    }

    public countryproAdapter(ArrayList<Countryproducts> data, Context context) {
        super(context, R.layout.row_countrypro, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Countryproducts countryproducts=(Countryproducts) object;

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
        Countryproducts countryproducts = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        countryproAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.countryproAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_countrypro, parent, false);
            viewHolder.txtproname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtcountrypro = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtquantity = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtdat = (TextView) convertView.findViewById(R.id.country1);
           viewHolder.txtseason = (TextView) convertView.findViewById(R.id.season);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (countryproAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproname.setText(countryproducts.getProname());
        viewHolder.txtcountrypro.setText(countryproducts.getCountrypro());
        viewHolder.txtquantity.setText(countryproducts.getQuantity());
        viewHolder.txtdat.setText(countryproducts.getDat());
        viewHolder.txtseason.setText(countryproducts.getSeason());
        // Return the completed view to render on screen
        return convertView;

    }

}
