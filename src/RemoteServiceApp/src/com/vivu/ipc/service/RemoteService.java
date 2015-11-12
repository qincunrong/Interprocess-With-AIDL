
package com.vivu.ipc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.vivu.ipc.aidl.IRemoteService;
import com.vivu.ipc.aidl.IRemoteService.Stub;
import com.vivu.ipc.model.OperatorRequest;
import com.vivu.ipc.model.OperatorResponse;

public class RemoteService extends Service {
    private IRemoteService.Stub stub = new Stub() {

        @Override
        public OperatorResponse calculate(OperatorRequest request) throws RemoteException {
            OperatorResponse response = new OperatorResponse();
            response.setResult(request.getA() + request.getB());
            response.setCalculatingTime(System.currentTimeMillis() - request.getTimeRequest());
            return response;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

}
