package com.theradikalsoftware.metrans;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;

public class AboutMe extends Activity {

	//Button cerr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_me);
		
		//cerr = (Button)findViewById(R.id.cerrar_about);

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
		
		ImageView img = (ImageView)findViewById(R.id.fb_david);
		img.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        Intent intent = new Intent();
		        intent.setAction(Intent.ACTION_VIEW);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setData(Uri.parse("http://facebook.com/radikal.david"));
		        startActivity(intent);
		    }
		});
		
		/*ImageView img0 = (ImageView)findViewById(R.id.tw_david);
		img.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v0){
		        Intent intent0 = new Intent();
		        intent0.setAction(Intent.ACTION_VIEW);
		        intent0.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent0.setData(Uri.parse("http://www.twitter.com/theradikalstyle"));
		        startActivity(intent0);
		    }
		});*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_me, menu);
		return true;
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_about_me,
					container, false);
			return rootView;
		}
	}
	
	public void Cerrar(View v){
		finish();
	}



}
