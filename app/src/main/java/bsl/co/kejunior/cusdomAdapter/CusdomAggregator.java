package bsl.co.kejunior.cusdomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import bsl.co.kejunior.Model.Aggregator;

import bsl.co.kejunior.Model.Buyers;
import bsl.co.kejunior.R;

public class CusdomAggregator extends ArrayAdapter< Aggregator> implements View.OnClickListener{

        private ArrayList<Aggregator> dataSet;
        Context mContext;


        // View lookup cache public
        private static class ViewHolder {
            TextView txtaggname;
            TextView txtaggcountry;

        }

        public CusdomAggregator(ArrayList<Aggregator> data, Context context) {
            super(context, R.layout.row_aggregatorr, data);
            this.dataSet = data;
            this.mContext=context;

        }

        @Override
        public void onClick(View v) {

            int position=(Integer) v.getTag();
            Object object= getItem(position);
            Aggregator aggregator=(Aggregator) object;

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
            Aggregator aggregator = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            bsl.co.kejunior.cusdomAdapter.CusdomAggregator.ViewHolder viewHolder; // view lookup cache stored in tag

            final View result;

            if (convertView == null) {

                viewHolder = new bsl.co.kejunior.cusdomAdapter.CusdomAggregator.ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.row_aggregatorr, parent, false);
                viewHolder.txtaggname = (TextView) convertView.findViewById(R.id.name);
                viewHolder.txtaggcountry = (TextView) convertView.findViewById(R.id.country);
                result=convertView;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (bsl.co.kejunior.cusdomAdapter.CusdomAggregator.ViewHolder) convertView.getTag();
                result=convertView;
            }

            Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
            result.startAnimation(animation);
            lastPosition = position;


            viewHolder.txtaggname.setText(aggregator.getAggname());
            viewHolder.txtaggcountry.setText(aggregator.getAggcountry());

            // Return the completed view to render on screen
            return convertView;

        }
    }