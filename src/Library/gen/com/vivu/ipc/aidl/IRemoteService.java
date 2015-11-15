/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /media/duy/6E0E10390E0FF8BB/Work/Interprocess with AIDL/Interprocess-With-AIDL/src/Library/src/com/vivu/ipc/aidl/IRemoteService.aidl
 */
package com.vivu.ipc.aidl;
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.vivu.ipc.aidl.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.vivu.ipc.aidl.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.vivu.ipc.aidl.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.vivu.ipc.aidl.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.vivu.ipc.aidl.IRemoteService))) {
return ((com.vivu.ipc.aidl.IRemoteService)iin);
}
return new com.vivu.ipc.aidl.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_calculate:
{
data.enforceInterface(DESCRIPTOR);
com.vivu.ipc.model.OperatorRequest _arg0;
if ((0!=data.readInt())) {
_arg0 = com.vivu.ipc.model.OperatorRequest.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.vivu.ipc.aidl.ICalculate _arg1;
_arg1 = com.vivu.ipc.aidl.ICalculate.Stub.asInterface(data.readStrongBinder());
this.calculate(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.vivu.ipc.aidl.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void calculate(com.vivu.ipc.model.OperatorRequest request, com.vivu.ipc.aidl.ICalculate callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_calculate, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_calculate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void calculate(com.vivu.ipc.model.OperatorRequest request, com.vivu.ipc.aidl.ICalculate callback) throws android.os.RemoteException;
}
