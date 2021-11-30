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

import bsl.co.kejunior.Model.Country;
import bsl.co.kejunior.Model.Form;
import bsl.co.kejunior.R;

public class formAdapter extends ArrayAdapter<Form> implements View.OnClickListener{

    private ArrayList<Form> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtproform;
        TextView txtformname;

    }

    public formAdapter(ArrayList<Form> data, Context context) {
        super(context, R.layout.row_form, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Form form=(Form) object;


    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Form form = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        bsl.co.kejunior.cusdomAdapter.formAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new bsl.co.kejunior.cusdomAdapter.formAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_form, parent, false);
            viewHolder.txtproform = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtformname = (TextView) convertView.findViewById(R.id.country);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (bsl.co.kejunior.cusdomAdapter.formAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtproform.setText(form.getProform());
        viewHolder.txtformname.setText(form.getFormname());

        // Return the completed view to render on screen
        return convertView;

    }
}