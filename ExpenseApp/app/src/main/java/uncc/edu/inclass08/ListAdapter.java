package uncc.edu.inclass08;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends ArrayAdapter<Expense> {

    Context mContext;
    int mResource;
    List<Expense> mData;
    public ListAdapter(Context context, int resource, List<Expense> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
        this.mData=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(mResource,parent,false);
        }

        Expense expence=mData.get(position);

        TextView textExName= (TextView) convertView.findViewById(R.id.textExpenceName);
        textExName.setText(expence.getExName());

        TextView textExAmt= (TextView) convertView.findViewById(R.id.textExpenceAmt);
        textExAmt.setText("$"+expence.getExAmt());

        return convertView;
    }
}
