package com.nicme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String nic = extras.getString("nic");
			String dateln = extras.getString("dateln");
			String dayln = extras.getString("dayln");
			String ageln = extras.getString("ageln");
			String entln = extras.getString("entln");

			EditText text1 = (EditText) findViewById(R.id.editText1);
			text1.setText(nic);

			EditText text2 = (EditText) findViewById(R.id.editText2);
			text2.setText(dateln);

			EditText text3 = (EditText) findViewById(R.id.editText3);
			text3.setText(dayln);

			EditText text4 = (EditText) findViewById(R.id.editText4);
			text4.setText(ageln);

			EditText text5 = (EditText) findViewById(R.id.editText5);
			text5.setText(entln);
		}
	}

	public void getExit(View view) {
		// TODO Auto-generated method stub
		//finish();
		Intent i = new Intent(ViewActivity.this, FormActivity.class);
		startActivity(i);
		finish();
	}

}
