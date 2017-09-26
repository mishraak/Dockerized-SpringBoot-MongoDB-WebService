package com.amishra.exception;

import com.amishra.util.ErrorCodes;

public class NegativeIDException extends BaseException {

	public NegativeIDException() {
		super( ErrorCodes.NegativeIDMsg);

	}

}
