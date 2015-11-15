package com.vivu;

import android.os.IBinder;
import android.util.Log;

public class LocalBinder implements IBinder.DeathRecipient {
	private MainActivity mContext;

	public LocalBinder(final MainActivity context) {
		mContext = context;
	}

	@Override
	public void binderDied() {
		mContext.bindRemoteService();
		mContext = null;
		Log.d("TAG", "Remote process was killed. Just start it again.");
	}

}
