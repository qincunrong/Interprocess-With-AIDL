package com.vivu.ipc.aidl;

import com.vivu.ipc.model.OperatorResponse;
import com.vivu.ipc.model.OperatorRequest;

oneway interface ICalculate {
	void calculate(in OperatorResponse response);
}