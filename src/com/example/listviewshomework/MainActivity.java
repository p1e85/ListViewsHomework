package com.example.listviewshomework;

import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	String[] randomInts = new String[10];
	int random;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//adding random ints
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int tempInt = rand.nextInt(100);
			random = tempInt;
		//converts to string
			String tempString = String.valueOf(random);
			randomInts[i] = tempString;
			
		}

		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, randomInts);
		
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			//parameter names (AdapterView<?> adapter, View view, int position, long id)
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Integer list = Integer.valueOf((String) parent.getItemAtPosition(position));
				if((list%2)==0)
					   // even
					Toast.makeText(MainActivity.this, "String Even", Toast.LENGTH_SHORT).show();
				else
					   // odd
					Toast.makeText(MainActivity.this, "String Odd", Toast.LENGTH_SHORT).show();
				
				//new code
				int tempInt = position;
				if (tempInt%2 == 0)
					Toast.makeText(MainActivity.this, "Position Even", Toast.LENGTH_SHORT).show();
				else
					   // odd
					Toast.makeText(MainActivity.this, "Position Odd", Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}
	
}
