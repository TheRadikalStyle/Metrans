package com.theradikalsoftware.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends Activity {

	
	/*private NotificationManager nm; //Variables al admin de notif.
	private static final int ID_NOTIFICACION_CREAR = 1;*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //Declaracion de notificacion
		//noti();
		 
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
		
		//nm.cancel(ID_NOTIFICACION_CREAR);
		finish();
	    android.os.Process.killProcess(android.os.Process.myPid());
	    super.onDestroy();
	}
	
	/*private void noti(){
		//Contenido de notificacion
		Notification notificacion = new Notification( 
                R.drawable.metrans_logo,
                "Metrans inicializando... Bienvenido",
                System.currentTimeMillis() );
		//Fin de contenido de la notificacion
		PendingIntent intencionPendiente = PendingIntent.getActivity(
		          this, 0, new Intent(this, MainActivity.class), 0);
		notificacion.setLatestEventInfo(this, "Por favor espera",
		       "información adicional", intencionPendiente);
	
		 nm.notify(ID_NOTIFICACION_CREAR, notificacion); //Enviamos la notificacion al status bar
		
	}*/
	

	
}
