package com.theradikalsoftware.metrans;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.Menu;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;


public class SplashScreen extends Activity {
	
	public NotificationManager nm1; //Variables al admin de notif.
	public static final int ID_NOTIFICACION_CREAR = 1;

private long splashDelay = 6000; //milisegundos -> 	6 segundos
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		nm1 = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //Declaracion de notificacion
		
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
	noti1();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}
/***************Funcion de notificacion en status bar ***********************/
	private void noti1(){
		/*Contenido de notificacion*/
		Notification notificacion = new Notification( 
                R.drawable.metrans_logo,
                "Metrans inicializando... Bienvenido",
                System.currentTimeMillis() );
		/*Fin de contenido de la notificacion*/
		PendingIntent intencionPendiente = PendingIntent.getActivity(
		          this, 0, new Intent(this, MainActivity.class), 0);
		notificacion.setLatestEventInfo(this, "Somos tan chingones",
		       "que tenemos notificaciones aqui", intencionPendiente);
	
		 nm1.notify(ID_NOTIFICACION_CREAR, notificacion); //Enviamos la notificacion al status bar
		notificacion.defaults |= Notification.DEFAULT_VIBRATE; //Agregando algo de vibracion... Espero y funcione
		
	}

}
