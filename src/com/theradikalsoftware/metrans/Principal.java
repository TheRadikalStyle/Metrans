package com.theradikalsoftware.metrans;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.os.Build;
import au.com.bytecode.opencsv.CSVReader;

public class Principal extends Activity  implements OnTouchListener{
	
	   public int x,y,x2,y2,OP=1;
		public boolean move=false,move2=false, move3=false;
		private RelativeLayout l;
		StringBuilder builder= new StringBuilder();
		


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		RelativeLayout  l = (RelativeLayout)findViewById(R.id.op1);
		l.setOnTouchListener(this);
		setContentView(l);
		

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
		}*/
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
		super.onDestroy();
		//nm1.cancel();
	}
	
	private void About(){
		 Intent secondIntent = new Intent().setClass(Principal.this, AboutMe.class);
	        startActivity(secondIntent);
	}
	private void Calc(){
		Intent thirdIntent = new Intent().setClass(Principal.this, Calc.class);
				startActivity(thirdIntent);
	}
	
	
/*Funcion administradora del evento Touch para swiping*/
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		builder.setLength(0);
	  	
  		switch (event.getAction()){
  		case MotionEvent.ACTION_DOWN:
  		builder.append("se Toco:");
  		x=(int) event.getX();
  		y= (int) event.getY();
  		move2=true;
  			break;
  		case MotionEvent.ACTION_MOVE:
  			move3=true;
  			break;
  		case MotionEvent.ACTION_UP:
  			builder.append("se dejo de Tocar:");
  			x2=(int) event.getX();
  			y2= (int) event.getY();
  			move=true;
  			break;
  		}
  		if(move==true && move2==true){
  		if(x2>x){
  			builder.append("slash drerecha");
  			 //Intent act = new Intent(this,Principal.class);
  			 //startActivity(act);
  			// finish();
  		}
  			if(x>x2){
  				builder.append("slash izquierda");
		Intent act1 = new Intent(this,Calc.class);
				 startActivity(act1);
				 finish();
  			}
  		
  		move=false;
  		move2=false;
  		}
  		return true;
	}
	
	/*Funcion para cambiar de actividad*/
	public void Continuar(View v){
		Intent conti = new Intent().setClass(Principal.this,Secundaria.class);
		startActivity(conti);
	}
	
	
	public void revisarIntegridad(View v) throws IOException{
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader("yourfile.csv"));
			 String [] nextLine;
			    while ((nextLine = reader.readNext()) != null) {
			        // nextLine[] is an array of values from the line
			        System.out.println(nextLine[0] + nextLine[1] + "etc...");
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
	/*@Override
	  public boolean onTouch(View v, MotionEvent me) {
	  		
	  		builder.setLength(0);
	  	
	  		switch (me.getAction()){
	  		case MotionEvent.ACTION_DOWN:
	  		builder.append("se Toco:");
	  		x=(int) me.getX();
	  		y= (int) me.getY();
	  		move2=true;
	  			break;
	  		case MotionEvent.ACTION_MOVE:
	  			move3=true;
	  			break;
	  		case MotionEvent.ACTION_UP:
	  			builder.append("se dejo de Tocar:");
	  			x2=(int) me.getX();
	  			y2= (int) me.getY();
	  			move=true;
	  			break;
	  		}
	  		if(move==true && move2==true){
	  		if(x2>x){
	  			builder.append("slash drerecha");
	  			 //Intent act = new Intent(this,Principal.class);
	  			 //startActivity(act);
	  			// finish();
	  		}
	  			if(x>x2){
	  				builder.append("slash izquierda");
			Intent act1 = new Intent(this,Calc.class);
 				 startActivity(act1);
 				 finish();
	  			}
	  		
	  		move=false;
	  		move2=false;
	  		}
	  		return true;
	  	}*/

}
