package com.my.classParcerable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;



import com.my.classDTO.CevicheDTO;
import com.my.classDTO.ImagenSecDTO;
import com.my.classDTO.IngredienteDTO;

public class CevicheParcelable implements Parcelable{
	
	private String TAG = getClass().getSimpleName();
	
	private CevicheDTO ceviche;
	
	public CevicheParcelable(CevicheDTO ceviche){
		
		this.ceviche = ceviche;
		
	}

	private CevicheParcelable(Parcel in) {
		Log.v(TAG, "Comenzar con el parelable del bundle");
		ceviche = new CevicheDTO();
		
		
		
		//Plato		
		ceviche.setCod_plato(in.readInt());
		
		ceviche.setNombre(in.readString());
		
		Log.v(TAG,"Termine de leer el plato");
		
		
		//Imagen Primario
		
		
		ceviche.getImg_prim().setCod_img_prim(in.readInt());
		ceviche.getImg_prim().getFuente().setCod_fuente(in.readInt());
		ceviche.getImg_prim().getFuente().setDesc_fuente(in.readString());
		ceviche.getImg_prim().setUrl_external_img(in.readString());
		ceviche.getImg_prim().setUrl_local_img(in.readString());
		
		
		Log.v(TAG,"Termine de leer imagen primario");
		//Imagen Secundario
		
		int arraySize = in.readInt();
		
		Log.v(TAG, "Estoy por leer arreglo de Imagenes");
		
		for(int i = 0; i<arraySize;i++){
			
			ImagenSecDTO img = new ImagenSecDTO();
			img.setCod_img_sec(in.readInt());
			img.setCod_plato(in.readInt());
			img.getFuente().setCod_fuente(in.readInt());
			img.getFuente().setDesc_fuente(in.readString());
			img.setUrl_external_img(in.readString());
			img.setUrl_local_img(in.readString());
			
			ceviche.getImgs_sec().add(img);
			
		}
		
		
		//Ingredientes
		
		arraySize = in.readInt();
		
		Log.v(TAG, "Estoy por leer arreglo de ingredientes");
		
		for(int i = 0; i<arraySize; i++){
			
			IngredienteDTO ing = new IngredienteDTO();
			
			ing.setCod_ingrediente(in.readInt());
			ing.setDesc_ingrediente(in.readString());
			
			ceviche.getIngredientes().add(ing);
			
		}
		
		//Rating
		
		ceviche.getRating().setCod_rating(in.readInt());
		ceviche.getRating().setNum_estrellas(in.readInt());
		ceviche.getRating().setDesc_comentario(in.readString());
				
		//Region
		
		ceviche.getRegion().setCod_region(in.readInt());
		ceviche.getRegion().setDesc_region(in.readString());
				
		//Tip
		ceviche.getTip().setCot_tip(in.readInt());
		ceviche.getTip().setDesc_tip(in.readString());
			
		//Tipo
		ceviche.getTipo().setCod_tipo(in.readInt());
		ceviche.getTipo().setDesc_tipo(in.readString());
				
		//Video
		
		ceviche.getVideo().setCod_video(in.readInt());
		ceviche.getVideo().setCod_plato(in.readInt());
		ceviche.getVideo().getFuente().setCod_fuente(in.readInt());
		ceviche.getVideo().getFuente().setDesc_fuente(in.readString());
		ceviche.getVideo().setUrl_external_video(in.readString());
		ceviche.getVideo().setUrl_local_video(in.readString());
		
			
	}

	public CevicheDTO getCeviche() {
		return ceviche;
	}

	public void setCeviche(CevicheDTO ceviche) {
		this.ceviche = ceviche;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static final Parcelable.Creator<CevicheParcelable> CREATOR
    = new Parcelable.Creator<CevicheParcelable>() {
		public CevicheParcelable createFromParcel(Parcel in) {
			return new CevicheParcelable(in);
		}

		public CevicheParcelable[] newArray(int size) {
			return new CevicheParcelable[size];
		}
	};
	
	
//	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
//        public CevicheParcelable createFromParcel(Parcel in) {
//            return new CevicheParcelable(in);
//        }
// 
//        public CevicheParcelable[] newArray(int size) {
//            return new CevicheParcelable[size];
//        }
//    };

	@Override
	public void writeToParcel(Parcel out, int arg1) {
		// TODO Auto-generated method stub
		
		//Plato
		out.writeInt(ceviche.getCod_plato());
		out.writeString(ceviche.getNombre());
		
		//Imagen Primario
		out.writeInt(ceviche.getImg_prim().getCod_img_prim());
		out.writeInt(ceviche.getImg_prim().getFuente().getCod_fuente());
		out.writeString(ceviche.getImg_prim().getFuente().getDesc_fuente());
		out.writeString(ceviche.getImg_prim().getUrl_external_img());
		out.writeString(ceviche.getImg_prim().getUrl_local_img());
		
		//Imagen Secundario
		
		//Tamaño del array
		
		if(ceviche.getImgs_sec() != null){
			out.writeInt(ceviche.getImgs_sec().size());			
		}else{
			out.writeInt(0);			
		}
		
		Log.v(TAG, "Estoy por escribir las imagenes: "+ceviche.getImgs_sec().size());
		
		for(ImagenSecDTO temp: ceviche.getImgs_sec()){
			out.writeInt(temp.getCod_img_sec());
			out.writeInt(temp.getCod_plato());
			out.writeInt(temp.getFuente().getCod_fuente());			
			out.writeString(temp.getFuente().getDesc_fuente());
			out.writeString(temp.getUrl_external_img());
			out.writeString(temp.getUrl_local_img());			
		}
		
		//Ingredientes
		
		//Tamaño del array
		if(ceviche.getIngredientes() != null){
			
			out.writeInt(ceviche.getIngredientes().size());
			
		}else{
			
			out.writeInt(0);
			
		}
		
		Log.v(TAG, "Estoy por escribir los ingredientes");
		for(IngredienteDTO temp: ceviche.getIngredientes()){			
			out.writeInt(temp.getCod_ingrediente());
			out.writeString(temp.getDesc_ingrediente());			
		}
		
		//Rating
		out.writeInt(ceviche.getRating().getCod_rating());
		out.writeInt(ceviche.getRating().getNum_estrellas());
		out.writeString(ceviche.getRating().getDesc_comentario());
		
		//Region
		out.writeInt(ceviche.getRegion().getCod_region());
		out.writeString(ceviche.getRegion().getDesc_region());
		
		//Tip
		out.writeInt(ceviche.getTip().getCot_tip());
		out.writeString(ceviche.getTip().getDesc_tip());
		
		//Tipo
		out.writeInt(ceviche.getTipo().getCod_tipo());
		out.writeString(ceviche.getTipo().getDesc_tipo());
		
		//Video
		out.writeInt(ceviche.getVideo().getCod_video());
		out.writeInt(ceviche.getVideo().getCod_plato());
		out.writeInt(ceviche.getVideo().getFuente().getCod_fuente());
		out.writeString(ceviche.getVideo().getFuente().getDesc_fuente());
		out.writeString(ceviche.getVideo().getUrl_external_video());
		out.writeString(ceviche.getVideo().getUrl_local_video());
	}
	

}
