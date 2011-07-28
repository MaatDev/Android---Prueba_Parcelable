package com.my;

import java.util.ArrayList;

import com.my.classParcerable.CevicheParcelable;
import com.my.classParcerable.ImagenSecParcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class segundo extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segundo);
		Log.v("Droidnova", "hola 1");
		Bundle bundle = getIntent().getExtras();
		Log.v("Droidnova", "hola 2 "+ bundle.size());
		ArrayList<ImagenSecParcelable> lista = null;
		ArrayList<CevicheParcelable> lista2 = null;
		lista = bundle.getParcelableArrayList("hola");
		lista2 = bundle.getParcelableArrayList("hola2");
		Log.v("Droidnova", "hola 3: "+ lista);
		
		for(ImagenSecParcelable c:lista){
		
			Log.v("Droidnova", " "+c.getImagen().getFuente().getDesc_fuente());
			
		}
		
		
		
		
		
	}

}
