package com.vivu.ipc.aidl;

import com.vivu.ipc.model.OperatorResponse;
import com.vivu.ipc.model.OperatorRequest;

interface IRemoteService {
	void calculate(ICalculate callback);
}