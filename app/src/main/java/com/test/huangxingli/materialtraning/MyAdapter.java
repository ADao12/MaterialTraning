package com.test.huangxingli.materialtraning;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by huangxingli on 2015/4/1.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] mDataset;
    int itemType;


    static final int TYPEHEADER=0;
    static final int TYPEITEM=1;

    LayoutInflater inflater;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;

        switch (viewType){
            case TYPEHEADER:


                TextView textView1=  (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,null);
                holder=new ViewHolderHeader(textView1);
                break;
            case TYPEITEM:
                TextView textView= (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,null);
                holder=new ViewHolderItem(textView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderHeader){
            ViewHolderHeader header= (ViewHolderHeader) holder;
            header.textView.setText(getItem(position));
           // ((TextView) ((ViewHolderHeader) holder).cardView.findViewById(R.id.info_text)).setText(getItem(position));
        }else if (holder instanceof  ViewHolderItem)
        {
            ViewHolderItem item= (ViewHolderItem) holder;
            item.mTextView.setText(getItem(position));

        }

    }

    private String getItem(int position){
        return mDataset[position];
    }

    @Override
    public int getItemViewType(int position) {
        if (isFirstPosition(position)){
            itemType=TYPEHEADER;

        }else {
            itemType=TYPEITEM;
        }
        return itemType;
   //     return super.getItemViewType(position);
    }

    public boolean isFirstPosition(int position){
      return position==0;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolderItem extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView mTextView;
        public ViewHolderItem(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public  static class ViewHolderHeader extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;

        public ViewHolderHeader(View itemView) {

            super(itemView);
            textView= (TextView) itemView;

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;

    }

    // Create new views (invoked by the layout manager)

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}