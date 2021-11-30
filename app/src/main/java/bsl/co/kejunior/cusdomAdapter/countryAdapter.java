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

import bsl.co.kejunior.Model.Category;
import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.R;

public class countryAdapter extends ArrayAdapter<Country> implements View.OnClickListener{

    private ArrayList<Country> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtcode;
        TextView txtcountryname;

    }

    public countryAdapter(ArrayList<Country> data, Context context) {
        super(context, R.layout.row_country, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Country country=(Country) object;


    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Country country = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        bsl.co.kejunior.cusdomAdapter.countryAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.countryAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_country, parent, false);
            viewHolder.txtcode = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtcountryname = (TextView) convertView.findViewById(R.id.country);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (bsl.co.kejunior.cusdomAdapter.countryAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtcode.setText(country.getCode());
        viewHolder.txtcountryname.setText(country.getCountryname());

        // Return the completed view to render on screen
        return convertView;

    }
}