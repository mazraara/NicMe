package com.nicme;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private static MediaPlayer player = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		player = MediaPlayer.create(MainActivity.this, R.drawable.jingle);
		player.setLooping(false); // Set looping
		player.setVolume(100, 100);
		player.start();
		player.setOnCompletionListener(new OnCompletionListener() {

			// @Override
			public void onCompletion(MediaPlayer arg0) {
				// File has ended !!!
				player.stop();
			}
		});
	}

	//
	@Override
	public void onPause() {
		super.onPause();

		if (player.isPlaying()) {
			player.stop();
		}
	}

	public void clkExit(View view) {
		if (player.isPlaying()) {
			player.stop();
		}
		finish();

	}

	public void clkStart(View view) {
		Intent i = new Intent(MainActivity.this, FormActivity.class);
		startActivity(i);

		finish();
	}
	//
	// class BackgroundSound extends AsyncTask<Void, Void, Void> {
	//
	// @Override
	// protected Void doInBackground(Void... params) {
	// MediaPlayer player = MediaPlayer.create(MainActivity.this,
	// R.drawable.jingle);
	// player.setLooping(false); // Set looping
	// player.setVolume(100, 100);
	// player.start();
	//
	// return null;
	// }
	//
	// protected void onPostExecute() {
	// this.cancel(true);
	// //showDialog("Downloaded " + result + " bytes");
	// }
	//
	// }

}
