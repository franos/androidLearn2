package com.zy.androidlearn2.com.zy.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zz on 16/1/16.
 */
public class Book implements Parcelable {
    String name;
    int page;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    protected Book(Parcel in) {
        name = in.readString();
        page = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(page);
    }
}
