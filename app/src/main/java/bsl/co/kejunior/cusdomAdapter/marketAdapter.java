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

import bsl.co.kejunior.Model.Countryproducts;
import bsl.co.kejunior.Model.Market;
import bsl.co.kejunior.R;

public class marketAdapter extends ArrayAdapter<Market> implements View.OnClickListener{

    private ArrayList<Market> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtpromarket;
        TextView txtprice;
        TextView txtcountrym;
        TextView txtdatem;
    }

    public marketAdapter(ArrayList<Market> data, Context context) {
        super(context, R.layout.row_market, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Market market=(Market) object;

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
        Market market = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        marketAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.marketAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_market, parent, false);
            viewHolder.txtpromarket = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtprice = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtcountrym = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtdatem = (TextView) convertView.findViewById(R.id.country1);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (marketAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtpromarket.setText(market.getPromarket());
        viewHolder.txtprice.setText(market.getPrice());
        viewHolder.txtcountrym.setText(market.getCountrym());
        viewHolder.txtdatem.setText(market.getDatem());
        // Return the completed view to render on screen
        return convertView;

    }

}
