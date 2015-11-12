
package com.vivu.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;

public class OperatorResponse implements Parcelable {
    private int pId;

    private int result;

    private long calculatingTime;

    public OperatorResponse() {
        pId = Process.myPid();
    }

    public OperatorResponse(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        pId = parcel.readInt();
        result = parcel.readInt();
        calculatingTime = parcel.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pId);
        dest.writeInt(result);
        dest.writeLong(calculatingTime);
    }

    public static final Parcelable.Creator<OperatorResponse> CREATOR = new Creator<OperatorResponse>() {

        @Override
        public OperatorResponse[] newArray(int size) {
            return new OperatorResponse[size];
        }

        @Override
        public OperatorResponse createFromParcel(Parcel source) {
            return new OperatorResponse(source);
        }
    };

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public long getCalculatingTime() {
        return calculatingTime;
    }

    public void setCalculatingTime(long calculatingTime) {
        this.calculatingTime = calculatingTime;
    }

    public int getpId() {
        return pId;
    }

}
