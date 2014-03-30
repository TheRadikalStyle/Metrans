package com.theradikalsoftware.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	//Creacion de menu
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	/*****Selector de funciones desde el menu*****/
	@Override 
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case R.id.exit:
			Exit();
			break;
		}
		return true;
	}
	
	/*****Funciones del menu de esta actividad*****/
	private void Exit() {
		finish();
	    android.os.Process.killProcess(android.os.Process.myPid());
	    super.onDestroy();
	}
	

	
}
