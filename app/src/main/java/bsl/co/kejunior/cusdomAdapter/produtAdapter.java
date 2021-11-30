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
import bsl.co.kejunior.Model.Products;
import bsl.co.kejunior.R;

public class produtAdapter extends ArrayAdapter<Products> implements View.OnClickListener {

    private ArrayList<Products> dataSet;
    Context mContext;


    private static class ViewHolder {

        TextView txtproduname;
        TextView txtcommodityf;
        TextView txtprocategory;;
        TextView txtvariety;
        TextView txtqualityclass;


    }

    public produtAdapter(ArrayList<Products> data, Context context) {
        super(context, R.layout.row_produt, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Products products=(Products) object;

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
        Products products = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        produtAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.produtAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_produt, parent, false);
            viewHolder.txtproduname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtcommodityf = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtprocategory = (TextView) convertView.findViewById(R.id.name1);
            viewHolder.txtvariety = (TextView) convertView.findViewById(R.id.season);
            viewHolder.txtqualityclass = (TextView) convertView.findViewById(R.id.country1);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (produtAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproduname.setText(products.getProduname());
        viewHolder.txtcommodityf.setText(products.getCommodityf());
        viewHolder.txtprocategory.setText(products.getProcategory());
        viewHolder.txtvariety.setText(products.getVariety());
        viewHolder.txtqualityclass.setText(products.getQualityclass());
        // Return the completed view to render on screen
        return convertView;

    }

}
