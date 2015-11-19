package com.example.uchumi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Product> data;//modify here
	public CustomAdapter(Context context, ArrayList<Product> data) //modify here
	{
		this.mContext = context;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}
	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}
	@Override
	public long getItemId(int id) {
		return id;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//modify here
			viewHolder = new ViewHolder();
			viewHolder.tvId = (TextView) convertView.findViewById(R.id.tvId);//modify here
			viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);//modify here
			viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);//modify here
			viewHolder.tvQuantity = (TextView) convertView.findViewById(R.id.tvQuantity);//modify here
			viewHolder.tvDiscount = (TextView) convertView.findViewById(R.id.tvDiscount);//modify here
			viewHolder.tvExpirydate = (TextView) convertView.findViewById(R.id.tvExpirydate);//modify here
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Product p = data.get(position);//modify here
		viewHolder.tvId.setText(p.getId());//modify here
		viewHolder.tvName.setText(p.getName());
		viewHolder.tvPrice.setText(p.getPrice());
		viewHolder.tvQuantity.setText(p.getQuantity());
		viewHolder.tvDiscount.setText(p.getDiscount());
		viewHolder.tvExpirydate.setText(p.getExpirydate());
	
		return convertView;
	}
	static class ViewHolder {
		TextView tvId;//modify here
		TextView tvPrice;//modify here
		TextView tvName;//modify here
		TextView tvQuantity;//modify here
		TextView tvDiscount;
		TextView tvExpirydate;
	}

}
