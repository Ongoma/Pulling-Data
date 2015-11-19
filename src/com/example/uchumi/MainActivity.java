package com.example.uchumi;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.uchumi.CustomAdapter;
import com.example.uchumi.Product;
import com.example.uchumi.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView list;
    CustomAdapter adapter;
    ArrayList<Product>dataarray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = (ListView)findViewById(R.id.listView1);
		dataarray = new ArrayList<Product>();
		adapter = new CustomAdapter(this,dataarray);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    public void pull(View v){
    	String url = "http://10.0.2.2/pul/uchumipul.php";
    	AsyncHttpClient client = new AsyncHttpClient();
    	client.get(url, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				String data = new String(arg2);
				try {
					JSONArray array = new JSONArray(data);
					for(int x = 0;x<array.length();x++){
						JSONObject obj = array.getJSONObject(x);
						String id = obj.getString("id");
						String name = obj.getString("name");
						String price = obj.getString("price");
						String quantity = obj.getString("quantity");
						String discount = obj.getString("discount");
						String expirydate = obj.getString("expirydate");
						Product p = new Product(id, name, price, quantity,discount,expirydate);
						dataarray.add(p);
						Log.d("DATA",id+" "+name+" "+price+" "+quantity+" "+discount+" "+expirydate);
					}
					adapter.notifyDataSetChanged();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
			Log.e("DATA","Failed to Fetch");	
			}
		});
    }
}
