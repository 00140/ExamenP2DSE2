package Parcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class DatoParse implements Parcelable {
    String nombre;
    int edad;
    String correo;

    public DatoParse() {
    }

    public DatoParse(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    protected DatoParse(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        correo = in.readString();
    }

    public static final Creator<DatoParse> CREATOR = new Creator<DatoParse>() {
        @Override
        public DatoParse createFromParcel(Parcel in) {
            return new DatoParse(in);
        }

        @Override
        public DatoParse[] newArray(int size) {
            return new DatoParse[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeString(correo);
    }
}
