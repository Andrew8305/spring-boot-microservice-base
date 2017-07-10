package jp.drjoy.service.common.util;

import java.io.Serializable;

/**
 * The Class ErrorInfo.
 */
public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String errMsg;

	private String errFieldId;

	public ErrorInfo(String errMsg, String errFieldId) {
		this.errFieldId = errFieldId;
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrFieldId() {
		return errFieldId;
	}

	public void setErrFieldId(String errFieldId) {
		this.errFieldId = errFieldId;
	}

}
