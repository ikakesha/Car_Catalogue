package com.example.assignment3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView carList;
	private LayoutInflater inflater;
	private int selectedVehiclePosition;
	private int currentTab;
	private List<Vehicle> vehicleList ;
	private TabHost tabhost;

	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save the user's current  state
		savedInstanceState.putInt("current", currentTab);
		savedInstanceState.putInt("selected", selectedVehiclePosition);
		
		
		super.onSaveInstanceState(savedInstanceState);
	}
	
	
	//restore current state
	private void restoreBundle(Bundle savedInstanceState){
		currentTab = savedInstanceState.getInt("current");
		selectedVehiclePosition = savedInstanceState.getInt("selected");
		
		Vehicle selectedVehicle = vehicleList.get(selectedVehiclePosition);
		((TextView) findViewById(R.id.tab3))
				.setText(selectedVehicle.getDescription());
		((ImageView) findViewById(R.id.tab2)).setImageResource(selectedVehicle.getImage());
	}
	
	
	//creates tabhost with three tabs
	private void createTabHost(){
		tabhost = (TabHost) findViewById(R.id.tabhost);
		tabhost.setup();

		TabHost.TabSpec spec;

		spec = tabhost.newTabSpec("screen1");

		spec.setContent(R.id.tab1);
		spec.setIndicator("Vehicles", null);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("screen2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("image", null);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("screen3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("description", null);
		tabhost.addTab(spec);

		
		tabhost.setCurrentTab(currentTab);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vehicleList = Vehicle.getDataForListView();
		
		if (savedInstanceState != null){
			restoreBundle(savedInstanceState);
		}else{
			currentTab = 0;
			selectedVehiclePosition = 0;
		}
		
		
		createTabHost();
		

		carList = (ListView) findViewById(R.id.my_list);
		carList.setAdapter(new MyBaseAdapter());
		inflater = getLayoutInflater();

		carList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Vehicle selectedVehicle = vehicleList.get(arg2);
				selectedVehiclePosition =arg2;
				int id = selectedVehicle.getImage();
				((ImageView) findViewById(R.id.tab2)).setImageResource(id);
				tabhost.setCurrentTab(1);
				currentTab = 1;
			}
		});

		tabhost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				if (tabId.equals("screen3")) {

					Vehicle selectedVehicle = vehicleList.get(selectedVehiclePosition);
						((TextView) findViewById(R.id.tab3))
								.setText(selectedVehicle.getDescription());
				}
				currentTab = tabhost.getCurrentTab();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class MyBaseAdapter extends BaseAdapter {
		List<Vehicle> vehicleList = Vehicle.getDataForListView();

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return vehicleList.size();
		}

		@Override
		public Object getItem(int arg0) {
			return vehicleList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_item, parent,
						false);
			}

			TextView chapterName = (TextView) convertView
					.findViewById(R.id.textView1);

			ImageView image = (ImageView) convertView
					.findViewById(R.id.imageView1);

			chapterName.setText(vehicleList.get(position).getName());
			image.setImageResource(vehicleList.get(position).getImage());

			return convertView;
		}

	}

}
