package com.my.classParcerable;

import com.my.classDTO.ImagenSecDTO;

import android.os.Parcel;
import android.os.Parcelable;

public class ImagenSecParcelable implements Parcelable{

	ImagenSecDTO imagen;
	
	public ImagenSecParcelable(ImagenSecDTO imagen) {
		
		this.imagen = imagen;
		
	}
	
	public ImagenSecParcelable(Parcel in){
		
		imagen = new ImagenSecDTO();
		
		imagen.setCod_img_sec(in.readInt());
		imagen.setCod_plato(in.readInt());
		imagen.getFuente().setCod_fuente(in.readInt());
		imagen.getFuente().setDesc_fuente(in.readString());
		imagen.setUrl_external_img(in.readString());
		imagen.setUrl_local_img(in.readString());
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static final Parcelable.Creator<ImagenSecParcelable> CREATOR
    = new Parcelable.Creator<ImagenSecParcelable>() {
		public ImagenSecParcelable createFromParcel(Parcel in) {
			return new ImagenSecParcelable(in);
		}

		public ImagenSecParcelable[] newArray(int size) {
			return new ImagenSecParcelable[size];
		}
	};

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		
		out.writeInt(imagen.getCod_img_sec());
		out.writeInt(imagen.getCod_plato());
		out.writeInt(imagen.getFuente().getCod_fuente());
		out.writeString(imagen.getFuente().getDesc_fuente());
		out.writeString(imagen.getUrl_external_img());
		out.writeString(imagen.getUrl_local_img());
		
	}

	public ImagenSecDTO getImagen() {
		return imagen;
	}

	public void setImagen(ImagenSecDTO imagen) {
		this.imagen = imagen;
	}
	
	
	
	

}
