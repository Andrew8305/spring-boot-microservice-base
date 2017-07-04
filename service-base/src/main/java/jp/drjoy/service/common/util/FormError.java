package jp.drjoy.service.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class FormError {

	public static List<ErrorInfo> bindingResult(BindingResult result) {

		List<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
		if (result.hasErrors()) {
			List<FieldError> errs = result.getFieldErrors();
			for (FieldError fieldError : errs) {
				errorList.add(new ErrorInfo(fieldError.getDefaultMessage(), fieldError.getField()));
			}
			return errorList;
		}
		return errorList;
	}
}
