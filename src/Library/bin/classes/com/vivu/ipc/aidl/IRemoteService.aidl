package com.vivu.ipc.aidl;

import com.vivu.ipc.model.OperatorResponse;
import com.vivu.ipc.model.OperatorRequest;
import com.vivu.ipc.aidl.ICalculate;

oneway interface IRemoteService {
	void calculate(in OperatorRequest request,in ICalculate callback);
}