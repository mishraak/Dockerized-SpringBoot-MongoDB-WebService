package com.amishra.exception;

import com.amishra.util.ErrorCodes;

public class ZeroRecordsFound extends BaseException {

	public ZeroRecordsFound() {		
		super(ErrorCodes.ZeroRecordsFoundMsg);
	}

	
}
