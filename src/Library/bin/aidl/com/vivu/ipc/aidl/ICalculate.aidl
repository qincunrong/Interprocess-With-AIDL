package com.vivu.ipc.aidl;

import com.vivu.ipc.model.OperatorResponse;
import com.vivu.ipc.model.OperatorRequest;

interface ICalculate {
	OperatorResponse calculate(in OperatorRequest request);
}