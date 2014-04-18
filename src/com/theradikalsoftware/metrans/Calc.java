package com.theradikalsoftware.metrans;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.*;
import android.content.Intent;

public class Calc extends Principal implements OnClickListener ,OnTouchListener{

	  EditText etNum1;
	  EditText etNum2;

	  Button btnAdd;
	  Button btnSub;
	  Button btnMult;
	  Button btnDiv;
	  Button raiz;

	  TextView tvResult;

	  String oper = "";
	  
	  public int x,y,x2,y2,OP=1;
		public boolean move=false,move2=false, move3=false;
		private LinearLayout l;
		StringBuilder builder= new StringBuilder();

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_calc);
	    
	    LinearLayout  l = (LinearLayout)findViewById(R.id.op);
		l.setOnTouchListener(this);
		setContentView(l);

	    // find the elements
	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    etNum2 = (EditText) findViewById(R.id.etNum2);

	    btnAdd = (Button) findViewById(R.id.btnAdd);
	    btnSub = (Button) findViewById(R.id.btnSub);
	    btnMult = (Button) findViewById(R.id.btnMult);
	    btnDiv = (Button) findViewById(R.id.btnDiv);

	    tvResult = (TextView) findViewById(R.id.tvResult);

	    // set a listener
	    btnAdd.setOnClickListener( this);
	    btnSub.setOnClickListener(this);
	    btnMult.setOnClickListener(this);
	    btnDiv.setOnClickListener(this);

	  }

	  @Override
	  public void onClick(View v) {
	    // TODO Auto-generated method stub
	    float num1 = 0;
	    float num2 = 0;
	    float result = 0;

	    // check if the fields are empty
	    if (TextUtils.isEmpty(etNum1.getText().toString())
	        || TextUtils.isEmpty(etNum2.getText().toString())) {
	      return;
	    }

	    // read EditText and fill variables with numbers
	    num1 = Float.parseFloat(etNum1.getText().toString());
	    num2 = Float.parseFloat(etNum2.getText().toString());

	    // defines the button that has been clicked and performs the corresponding operation
	    // write operation into oper, we will use it later for output
	    switch (v.getId()) {
	    case R.id.btnAdd:
	      oper = "+";
	      result = num1 + num2;
	      break;
	    case R.id.btnSub:
	      oper = "-";
	      result = num1 - num2;
	      break;
	    case R.id.btnMult:
	      oper = "*";
	      result = num1 * num2;
	      break;
	    case R.id.btnDiv:
	      oper = "/";
	      result = num1 / num2;
	      break;
	    default:
	      break;
	    }

	    // form the output line
	    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
	  }
	  
	  @Override
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
	  			 Intent act = new Intent(this,Principal.class);
	  			 startActivity(act);
	  			 finish();
	  		}
	  			if(x>x2){
	  				builder.append("slash izquierda");
//	  				Intent act2 = new Intent(this,MainActivity3.class);
//	  				 startActivity(act2);
	  			}
	  		
	  		move=false;
	  		move2=false;
	  		}
	  		return true;
	  	}
	  
	 
	}