package com.crm.listenersCode;

import static org.testng.Assert.assertEquals;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry  implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
//		int start=0;int end=2;
//		while(start<end)
//		{
//			start++;
//			return true;
//		}
//		return false;
		
		for(int start=0;start<2;start++)
		{
			return true;
		}
		return false;
	}

}
