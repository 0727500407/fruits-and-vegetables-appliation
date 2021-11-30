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
import bsl.co.kejunior.Model.Season;
import bsl.co.kejunior.R;

public class seasonAdapter extends ArrayAdapter<Season> implements View.OnClickListener{

    private ArrayList<Season> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtseaname;
        TextView txtdatefrom;
        TextView txtdateto;
        TextView txtcountrsi;

    }

    public seasonAdapter(ArrayList<Season> data, Context context) {
        super(context, R.layout.row_season, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Season season=(Season) object;

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
        Season season = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        seasonAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new seasonAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_season, parent, false);
            viewHolder.txtseaname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtdatefrom = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtdateto = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtcountrsi = (TextView) convertView.findViewById(R.id.country1);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (seasonAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtseaname.setText(season.getSeaname());
        viewHolder.txtdatefrom.setText(season.getDatefrom());
        viewHolder.txtdateto.setText(season.getDateto());
        viewHolder.txtcountrsi.setText(season.getCountrsi());
        // Return the completed view to render on screen
        return convertView;

    }
}