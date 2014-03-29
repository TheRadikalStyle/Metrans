package com.theradikalsoftware.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;


public class SplashScreen extends Activity {

private long splashDelay = 6000; //milisegundos -> 	6 segundos
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
	
		TimerTask task = new TimerTask(){
		 @Override
	      public void run() {
	        Intent mainIntent = new Intent().setClass(SplashScreen.this, MainActivity.class);
	        startActivity(mainIntent);
	        finish();//Destrucion de la actividad, usuario no tendra oportunidad de verla hasta reiniciar
	      }		
	};
	Timer timer = new Timer();
	timer.schedule(task, splashDelay); //Pasando los 6 segundos entramos a la tarea en si
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
