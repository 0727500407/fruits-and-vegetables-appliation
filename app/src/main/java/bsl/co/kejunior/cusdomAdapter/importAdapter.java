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

import bsl.co.kejunior.Model.Export;
import bsl.co.kejunior.Model.Imports;
import bsl.co.kejunior.R;

public class importAdapter extends ArrayAdapter<Imports> implements View.OnClickListener {

private ArrayList<Imports> dataSet;
        Context mContext;


private static class ViewHolder {
    TextView txtproimport;
    TextView txtformi;
    TextView txtpurposei;;
    TextView txtcountryi;
    TextView txtdatei;


}

    public importAdapter(ArrayList<Imports> data, Context context) {
        super(context, R.layout.row_import, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Imports imports=(Imports) object;

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
        Imports imports = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        importAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.importAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_import, parent, false);
            viewHolder.txtproimport = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtformi = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtpurposei = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtcountryi = (TextView) convertView.findViewById(R.id.country1);
            viewHolder.txtdatei = (TextView) convertView.findViewById(R.id.season);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (importAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproimport.setText(imports.getProimport());
        viewHolder.txtformi.setText(imports.getFormi());
        viewHolder.txtpurposei.setText(imports.getPurposei());
        viewHolder.txtcountryi.setText(imports.getCountryi());
        viewHolder.txtdatei.setText(imports.getDatei());
        // Return the completed view to render on screen
        return convertView;

    }

}
