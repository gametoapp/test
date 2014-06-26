package com.mnc.dralarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	
	public Button codeBt,xmlBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		codeBt = (Button)findViewById(R.id.main_code_bt);
		xmlBt = (Button)findViewById(R.id.main_xml_bt);
		
		codeBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, CodeTypeAD.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		xmlBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, XmlTypeAD.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}
	
	

}
