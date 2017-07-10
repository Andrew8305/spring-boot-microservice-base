package jp.drjoy.service.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import jp.drjoy.service.common.constant.Const;

/**
 * Conversion to Date type
 */
public final class CustomDateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof String) {
			if (StringUtils.isNotBlank(value.toString())) {
				SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_FORMAT_DDMMYYYY);
				try {
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					e.printStackTrace();
					return value.toString();
				}
			} else {
				return null;
			}
		} else {
			return value;
		}
	}

}
