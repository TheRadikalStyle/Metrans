package com.theradikalsoftware.metrans;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class Principal extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	
	/***Selector de funciones del menú de esta actividad***/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.exit ){
			Exit();
			return true;
		}
		if(id==R.id.about){
			About();
			return true;
		}
		if(id==R.id.calc){
			Calc();
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_principal,
					container, false);
			return rootView;
		}
	}
	
	/*****Funciones del menú de esta actividad****/
	private void Exit(){
		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onDestroy();;
	}
	
	private void About(){
		 Intent secondIntent = new Intent().setClass(Principal.this, AboutMe.class);
	        startActivity(secondIntent);
	}
	private void Calc(){
		Intent thirdIntent = new Intent().setClass(Principal.this, Calc.class);
				startActivity(thirdIntent);
	}

}
