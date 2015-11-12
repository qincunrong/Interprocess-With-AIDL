
package com.vivu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.vivu.ipc.aidl.ICalculate;
import com.vivu.ipc.aidl.ICalculate.Stub;
import com.vivu.ipc.aidl.IRemoteService;
import com.vivu.ipc.model.OperatorRequest;
import com.vivu.ipc.model.OperatorResponse;
import com.vivu.ipc2.R;

public class MainActivity extends FragmentActivity {
    ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            calculator = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            calculator = IRemoteService.Stub.asInterface(service);
        }
    };

    private ICalculate.Stub callback = new Stub() {

        @Override
        public void calculate(OperatorResponse response) throws RemoteException {
            Log.d("TAG", "Server's pId=" + response.getpId());
            Log.d("TAG",
                    String.format("Get result= %d after %ds", response.getResult(), (int)response.getCalculatingTime()));
            Log.d("TAG", "Current process's pId=" + Process.myPid());
        }
    };

    private IRemoteService calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText aText = (EditText)findViewById(R.id.et_a);
        final EditText bText = (EditText)findViewById(R.id.et_b);
        findViewById(R.id.btn_Add).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String a = aText.getText().toString();
                String b = bText.getText().toString();

                int first = TextUtils.isEmpty(a) ? 0 : Integer.parseInt(a);
                int second = TextUtils.isEmpty(b) ? 0 : Integer.parseInt(b);

                OperatorRequest request = new OperatorRequest();
                request.setA(first);
                request.setB(second);
                Log.d("TAG", "Client's pId=" + request.getpId());
                try {
                    calculator.calculate(request, callback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intent = new Intent("com.vivu.ipc.service.RemoteService");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

}
