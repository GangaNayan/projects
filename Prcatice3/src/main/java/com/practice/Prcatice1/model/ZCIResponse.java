package com.practice.Prcatice1.model;

import java.util.Arrays;

public class ZCIResponse
{
	private boolean		status;
	private String		errorCode	= "";
	private String		errorMessage;
	private String[]	errorParams;
	private String		checksum;
	private String		responseCode;
	private Object		result;
	

	/**
	 * @return {@link Boolean}
	 */
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status {@link Boolean}
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	/**
	 * @return {@link String}
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * @param errorCode {@link String}
	 */
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * @return {@link String}
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}

	/**
	 * @param errorMessage {@link String}
	 */
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	/**
	 * @return Array of {@link String}
	 */
	public String[] getErrorParams()
	{
		return errorParams;
	}

	/**
	 * @param errorParams Array of {@link String}
	 */
	public void setErrorParams(String[] errorParams)
	{
		this.errorParams = errorParams;
	}

	/**
	 * @return {@link Object}
	 */
	public Object getResult()
	{
		return result;
	}

	/**
	 * @param result {@link Object}
	 */
	public void setResult(Object result)
	{
		this.result = result;
	}

	/**
	 * @return {@link String}
	 */
	public String getChecksum()
	{
		return checksum;
	}

	/**
	 * @param checksum {@link String}
	 */
	public void setChecksum(String checksum)
	{
		this.checksum = checksum;
	}

	/**
	 * @return {@link String}
	 */
	public String getResponseCode()
	{
		return responseCode;
	}

	/**
	 * @param responseCode {@link String}
	 */
	public void setResponseCode(String responseCode)
	{
		this.responseCode = responseCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ZCIResponse [status=" + status + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", errorParams=" + Arrays.toString(errorParams) + ", result=" + result + ", checksum=" + checksum
				+ ", responseCode=" + responseCode + "]";
	}
}