package com.example.namaikan_bydiana;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    private String name;
    private String detail;
    private int photo;

    protected Hero (Parcel in)
    {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>()
    {

        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public Hero(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.name);
        parcel.writeString(this.detail);
        parcel.writeInt(this.photo);
    }
}