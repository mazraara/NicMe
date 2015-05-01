package com.nicme;

import java.util.GregorianCalendar;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.*;

public class FormActivity extends Activity {

	private ProgressBar linProgressBar;
	private final Handler uiHandler = new Handler();
	private boolean isUpdateRequired = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
	}

	public void goback(View view) {

		Intent i = new Intent(FormActivity.this, MainActivity.class);
		startActivity(i);
		finish();

	}

	public void getLost(View view) {

		finish();

	}

	public void basicInitializations() {

		linProgressBar = (ProgressBar) findViewById(R.id.ProgressBar01);
		linProgressBar.setVisibility(View.VISIBLE);

		try {
			new Thread() {
				public void run() {
					initializeApp();
					uiHandler.post(new Runnable() {
						@Override
						public void run() {
							if (isUpdateRequired) {

							} else {

								try {
									Thread.sleep(2000, 1);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								linProgressBar.setVisibility(View.GONE);

							}
						}
					});
				}

				public void initializeApp() {
					// Initialize application data here
				}
			}.start();
		} catch (Exception e) {
		}
	}

	public void findDob(View view) {

		EditText name = (EditText) findViewById(R.id.editText1);

		if (name.length() == 0) {
			Toast.makeText(this, "Nic Number cannot be empty.",
					Toast.LENGTH_LONG).show();
		}

		else if (name.length() == 9) {

			try {
				String nic = name.getText().toString();

				String dateln, dayln = null, ageln, entln;

				Nicco a = new Nicco();
				Nicco b = new Nicco();
				Nicco cc = new Nicco();

				Nicco d = new Nicco();
				Nicco ee = new Nicco();

				d.ch = nic.charAt(0); // 9
				ee.ch = nic.charAt(1); // 0

				a.ch = nic.charAt(2); // 0
				b.ch = nic.charAt(3); // 2
				cc.ch = nic.charAt(4);// 8
				a.ret();
				b.ret();
				cc.ret();

				d.ret();
				ee.ret();
				int year = 1900 + d.chr * 10 + ee.chr;
				dateln = (" " + year + " ");
				int day = a.chr * 100 + b.chr * 10 + cc.chr;
				int daym = 0;
				int mon = 0;
				String sex = "Male";

				if (day > 500) {
					sex = "Female";
					day = day - 500;
				}

				entln = (sex);

				if (day <= 31) {
					dateln = (dateln + "January " + day);
					daym = day;
					mon = 0;
				}
				if (31 < day & day <= 60) {
					dateln = (dateln + "February " + (day - 31));
					daym = day - 31;
					mon = 1;
				}
				if (60 < day & day <= 91) {
					dateln = (dateln + "March " + (day - 60));
					daym = day - 60;
					mon = 2;
				}
				if (91 < day & day <= 121) {
					dateln = (dateln + "April " + (day - 91));
					daym = day - 91;
					mon = 3;
				}
				if (121 < day & day <= 152) {
					dateln = (dateln + "May " + (day - 121));
					daym = day - 121;
					mon = 4;
				}
				if (152 < day & day <= 182) {
					dateln = (dateln + "June " + (day - 152));
					daym = day - 152;
					mon = 5;
				}
				if (182 < day & day <= 213) {
					dateln = (dateln + "July " + (day - 182));
					daym = day - 182;
					mon = 6;
				}
				if (213 < day & day <= 244) {
					dateln = (dateln + "August " + (day - 213));
					daym = day - 213;
					mon = 7;
				}
				if (244 < day & day <= 274) {
					dateln = (dateln + "September " + (day - 244));
					daym = day - 244;
					mon = 8;
				}
				if (274 < day & day <= 305) {
					dateln = (dateln + "Octomber " + (day - 274));
					daym = day - 274;
					mon = 9;
				}
				if (305 < day & day <= 335) {
					dateln = (dateln + "November " + (day - 305));
					daym = day - 305;
					mon = 10;
				}
				if (335 < day & day <= 366) {
					dateln = (dateln + "December " + (day - 335));
					daym = day - 335;
					mon = 11;
				}
				if (day > 366) {
					Toast.makeText(this, "Invalid NIC Number. Try Again.",
							Toast.LENGTH_LONG).show();
					return;
				}

				Calendar cal = new GregorianCalendar(year, mon, daym);
				int dayOfWeek;
				dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				if (dayOfWeek == 1) {
					dayln = ("Sunday");
				}
				if (dayOfWeek == 2) {
					dayln = ("Monday");
				}
				if (dayOfWeek == 3) {
					dayln = ("Tuesday");
				}
				if (dayOfWeek == 4) {
					dayln = ("wednesday");
				}
				if (dayOfWeek == 5) {
					dayln = ("Thursday");
				}
				if (dayOfWeek == 6) {
					dayln = ("Friday");
				}
				if (dayOfWeek == 7) {
					dayln = ("Saturday");
				}
				CalAge age = new CalAge();
				age.y = year;
				age.m = mon;
				age.d = daym;
				age.agecal();
				ageln = (" " + age.ye + " years " + age.mo + " months and "
						+ age.da + " Days");

				basicInitializations();

				final Intent i = new Intent(getApplicationContext(),
						ViewActivity.class);
				i.putExtra("nic", nic);
				i.putExtra("dateln", dateln);
				i.putExtra("dayln", dayln);
				i.putExtra("ageln", ageln);
				i.putExtra("entln", entln);

				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
				dlgAlert.setTitle("Good News");
				dlgAlert.setMessage("A result has been discovered, Press ok to view.");

				dlgAlert.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								startActivity(i);
								finish();
							}
						});
				dlgAlert.setCancelable(false);
				dlgAlert.create().show();

			} catch (Exception e) {

				Toast.makeText(this,
						"Oppz, Something Wrong :" + e.getMessage(),
						Toast.LENGTH_LONG).show();
				// TODO: handle exception
			}
		} else {
			Toast.makeText(this, "Please Enter The Correct Nic",
					Toast.LENGTH_LONG).show();
		}

	}
}

class Nicco {
	char ch;
	int chr;

	void ret() {
		if (ch == 48) {
			chr = 0;
		}
		if (ch == 49) {
			chr = 1;
		}
		if (ch == 50) {
			chr = 2;
		}
		if (ch == 51) {
			chr = 3;
		}
		if (ch == 52) {
			chr = 4;
		}
		if (ch == 53) {
			chr = 5;
		}
		if (ch == 54) {
			chr = 6;
		}
		if (ch == 55) {
			chr = 7;
		}
		if (ch == 56) {
			chr = 8;
		}
		if (ch == 57) {
			chr = 9;
		}
	}
}

class CalAge {

	int y, m, d, ye, mo, da;

	void agecal() {

		Calendar cal = new GregorianCalendar(y, m, d); // given y,m,d
		Calendar now = new GregorianCalendar(); // now
		ye = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		if ((now.get(Calendar.MONTH) < cal.get(Calendar.MONTH))
				|| ((now.get(Calendar.MONTH) == cal.get(Calendar.MONTH)) && (now
						.get(Calendar.DAY_OF_MONTH) < cal
						.get(Calendar.DAY_OF_MONTH)))) {
			ye--; // if day is not arvied in same month or if month is not
					// arrived in same year. reduce the year by 1
		}
		if (now.get(Calendar.MONTH) < cal.get(Calendar.MONTH)) {
			mo = 11 - m + now.get(Calendar.MONTH) + 1;
			{
				if (now.get(Calendar.DAY_OF_MONTH) < cal
						.get(Calendar.DAY_OF_MONTH)) {
					da = 30 - d + now.get(Calendar.DAY_OF_MONTH);
					mo--;
				}
				if (now.get(Calendar.DAY_OF_MONTH) >= cal
						.get(Calendar.DAY_OF_MONTH)) {
					da = now.get(Calendar.DAY_OF_MONTH)
							- cal.get(Calendar.DAY_OF_MONTH);

				}
			}
		}
		if (now.get(Calendar.MONTH) >= cal.get(Calendar.MONTH)) {
			mo = now.get(Calendar.MONTH) - cal.get(Calendar.MONTH);
			if (now.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)) {
				da = 30 - d + now.get(Calendar.DAY_OF_MONTH);
				if (now.get(Calendar.MONTH) != cal.get(Calendar.MONTH)) {
					mo--;
				}
				if (now.get(Calendar.MONTH) == cal.get(Calendar.MONTH)) {
					mo = 11 - m + now.get(Calendar.MONTH);
				}

			}
			if (now.get(Calendar.DAY_OF_MONTH) >= cal
					.get(Calendar.DAY_OF_MONTH)) {
				da = now.get(Calendar.DAY_OF_MONTH)
						- cal.get(Calendar.DAY_OF_MONTH);

			}
		}
	}
}
