
package com.vivu.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;

public class OperatorRequest implements Parcelable {
    private int pId;

    private int a;

    private int b;

    private long timeRequest;

    public OperatorRequest() {
        pId = Process.myPid();
        timeRequest = System.currentTimeMillis();
    }

    public OperatorRequest(Parcel parcel) {
        pId = parcel.readInt();
        a = parcel.readInt();
        b = parcel.readInt();
        timeRequest = parcel.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pId);
        dest.writeInt(a);
        dest.writeInt(b);
        dest.writeLong(timeRequest);
    }

    public static final Parcelable.Creator<OperatorRequest> CREATOR = new Creator<OperatorRequest>() {

        @Override
        public OperatorRequest[] newArray(int size) {
            return new OperatorRequest[size];
        }

        @Override
        public OperatorRequest createFromParcel(Parcel source) {
            return new OperatorRequest(source);
        }
    };

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public long getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(long timeRequest) {
        this.timeRequest = timeRequest;
    }

}
