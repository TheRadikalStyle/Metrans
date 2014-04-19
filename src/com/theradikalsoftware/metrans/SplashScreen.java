package com.theradikalsoftware.metrans;

import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class SplashScreen extends Activity {

	private long splashDelay = 6000; //milisegundos -> 	6 segundos	
	
	public NotificationManager nm1; // Variables para crear notificación en StatusBar
	public static final int ID_NOTIFICACION_CREAR = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
        
        nm1 = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //Declaración de notificación
        
        TimerTask task = new TimerTask(){
   		 @Override
   	      public void run() {
   	        Intent mainIntent = new Intent().setClass(SplashScreen.this, Principal.class);
   	        startActivity(mainIntent);
   	        finish();//Destrucion de la actividad, usuario no tendra oportunidad de verla hasta reiniciar
   	      }		
   	};
   	Timer timer = new Timer();
   	timer.schedule(task, splashDelay); //Pasando los 6 segundos entramos a la tarea en si
     noti1(); //Llamamos a la función para crear la notificacion   
     
       // nm1.cancel(noti1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen, menu);
        return true;
    }

   /* @Override
  /public boolean onOptionsItemSelected(MenuItem item) {
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
            View rootView = inflater.inflate(R.layout.fragment_splash_screen, container, false);
            return rootView;
        }
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
		          this, 0, new Intent(this, Principal.class), 0);
		notificacion.setLatestEventInfo(this, "Metrans",
		       "Pulsa para ir a la app", intencionPendiente);

		 nm1.notify(ID_NOTIFICACION_CREAR, notificacion); //Enviamos la notificacion al status bar
		notificacion.defaults |= Notification.DEFAULT_VIBRATE; //Agregando algo de vibracion... Espero y funcione
		notificacion.defaults |= Notification.DEFAULT_SOUND; //Afregando algo de sonido... Espero y este si funcione
	  
	}

}
