package com.my;

import java.util.ArrayList;

import com.my.classDTO.CevicheDTO;
import com.my.classDTO.ImagenSecDTO;
import com.my.classParcerable.CevicheParcelable;
import com.my.classParcerable.ImagenSecParcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PruebacevicheparcelableActivity extends Activity {
	
	private String TAG = getClass().getSimpleName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent intent = new Intent(this, segundo.class);
        Bundle bundle = new Bundle();
        
        
        ArrayList<ImagenSecParcelable> lista = new ArrayList<ImagenSecParcelable>();
        ImagenSecDTO ceviche = new ImagenSecDTO();
        ceviche.setCod_plato(1);
        ceviche.setUrl_external_img("hola 1");
        ceviche.getFuente().setDesc_fuente("desc");
        
        lista.add(new ImagenSecParcelable(ceviche));
        
        Log.v(TAG," size: "+lista.size()+lista.get(0).getClass());
        
        
        //..........................
        ArrayList<CevicheParcelable> lista2 = new ArrayList<CevicheParcelable>();
        CevicheDTO c2 = new CevicheDTO();
        c2.setCod_plato(1);
        c2.setNombre("mi_plato");
        lista2.add(new CevicheParcelable(c2));
        
        Log.v(TAG, "Lista 2: "+lista2.size());
        //..........................
        
        
        
        bundle.putParcelableArrayList("hola", lista);
        bundle.putParcelableArrayList("hola2", lista2);
        intent.putExtras(bundle);
        
        startActivity(intent);
        
        
        
    }
}