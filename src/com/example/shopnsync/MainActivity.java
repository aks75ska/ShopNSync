package com.example.shopnsync;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<String> values = new ArrayList<String>(); 
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		values.addAll(Arrays.asList("ListItem1", "ListItem2", "ListItem3", "asdasa", "asdad", "asdad","dfas adfa", "adfafaf a"));
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_text_view, R.id.listText, values);
		ListView myListView = (ListView) findViewById(R.id.mainList);
		
		myListView.setAdapter(adapter);
		
		final EditText addItems = (EditText) findViewById(R.id.EditText);
		
		addItems.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				// TODO Auto-generated method stub
				if(event.getAction()==KeyEvent.ACTION_DOWN)
				{
					String temp = addItems.getText().toString().trim();
					if(keyCode == KeyEvent.KEYCODE_ENTER && (!(addItems.getText().toString().trim().isEmpty()) || !(addItems.getText().toString().trim().equals(""))))
					{
						values.add(0, addItems.getText().toString().trim());
						adapter.notifyDataSetChanged();
						addItems.setText("");
					}
				}
				return false;
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
