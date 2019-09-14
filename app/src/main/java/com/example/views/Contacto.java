package com.example.views;

import android.os.Parcel;
import android.os.Parcelable;
public class Contacto implements Parcelable {
    private String Email;
    private String  Usuario;
    private String twiter;
    private String Tel;
    private String FechaNac;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getTwiter() {
        return twiter;
    }

    public void setTwiter(String twiter) {
        this.twiter = twiter;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String fechaNac) {
        FechaNac = fechaNac;
    }

    protected Contacto(Parcel in) {
        Email = in.readString();
        Usuario = in.readString();
        twiter = in.readString();
        Tel = in.readString();
        FechaNac = in.readString();
    }

    public static final Parcelable.Creator<Contacto> CREATOR =
            new Parcelable.Creator<Contacto>() {
                @Override
                public Contacto createFromParcel(Parcel in) {
                    return new Contacto(in);
                }

                @Override
                public Contacto[] newArray(int size) {
                    return new Contacto[size];
                }
            };

    public Contacto() {

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Email);
        parcel.writeString(Usuario);
        parcel.writeString(twiter);
        parcel.writeString(Tel);
        parcel.writeString(FechaNac);
    }

    private void readFromParcel(Parcel in){
        Email=in.readString();
        Usuario=in.readString();
        twiter=in.readString();
        Tel=in.readString();
        FechaNac=in.readString();


    }
}

