package com.vivu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;

import com.vivu.dra.R;

public class MainActivity extends FragmentActivity {
	private IBinder remoteBinder;
	private LocalBinder localBinder;

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			remoteBinder = service;
			if (remoteBinder != null) {
				try {
					remoteBinder.linkToDeath(localBinder, 0);
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.layout_main_activity);

		localBinder = new LocalBinder(this);

		bindRemoteService();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(connection);
		remoteBinder.unlinkToDeath(localBinder, 0);
	}

	public void bindRemoteService() {
		Intent intent = new Intent("com.vivu.ipc.service.RemoteService");
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}
}
