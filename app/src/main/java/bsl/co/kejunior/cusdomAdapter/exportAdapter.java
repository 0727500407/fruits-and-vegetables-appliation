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


import bsl.co.kejunior.Model.Demand;
import bsl.co.kejunior.Model.Export;
import bsl.co.kejunior.R;

public class exportAdapter extends ArrayAdapter<Export> implements View.OnClickListener {

    private ArrayList<Export> dataSet;
    Context mContext;


    private static class ViewHolder {
        TextView txtproducte;
        TextView txtpurpose;
        TextView txtform;;
        TextView txtcountrye;
        TextView txtdatee;


}

    public exportAdapter(ArrayList<Export> data, Context context) {
        super(context, R.layout.row_eporter, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Export export=(Export) object;

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
        Export export = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        exportAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.exportAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_eporter, parent, false);
            viewHolder.txtproducte = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtpurpose = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtform = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtcountrye = (TextView) convertView.findViewById(R.id.country1);
            viewHolder.txtdatee = (TextView) convertView.findViewById(R.id.season);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (exportAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproducte.setText(export.getProducte());
        viewHolder.txtpurpose.setText(export.getPurpose());
        viewHolder.txtform.setText(export.getForm());
        viewHolder.txtcountrye.setText(export.getCountrye());
        viewHolder.txtdatee.setText(export.getDatee());
        // Return the completed view to render on screen
        return convertView;

    }

}
