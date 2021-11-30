package bsl.co.kejunior.cusdomAdapter;

import android.content.Context;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bsl.co.kejunior.Model.Products;
import bsl.co.kejunior.Model.Sellers;
import bsl.co.kejunior.Model.User;
import bsl.co.kejunior.R;

public class userAdapter extends ArrayAdapter<User> implements View.OnClickListener{

    private ArrayList<User> dataSet;
    Context mContext;


    // View lookup cache public
    private static class ViewHolder {
        TextView txtuname;
        TextView txtfirst;
        TextView txtlast;
        TextView txtuid;
        TextView txtudate;
        TextView txtumobile;

    }

    public userAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.row_user, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        User user=(User) object;

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
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        userAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new userAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_user, parent, false);
            viewHolder.txtuname = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtfirst = (TextView) convertView.findViewById(R.id.buyer);
            viewHolder.txtlast = (TextView) convertView.findViewById(R.id.country);
            viewHolder.txtumobile = (TextView) convertView.findViewById(R.id.country1);
            viewHolder.txtuid = (TextView) convertView.findViewById(R.id.country1);
            viewHolder.txtudate = (TextView) convertView.findViewById(R.id.jun);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (userAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtuname.setText(user.getUname());
        viewHolder.txtfirst.setText(user.getFirst());
        viewHolder.txtlast.setText(user.getLast());
        viewHolder.txtumobile.setText(user.getUmobile());
        viewHolder.txtuid.setText(user.getUid());
        viewHolder.txtudate.setText(user.getUdate());
        // Return the completed view to render on screen
        return convertView;

    }

}

