package jp.drjoy.service.common.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

import jp.drjoy.service.common.constant.Const;

/**
 * Conversion to String type
 */
public final class CustomStringConverter implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_FORMAT_DDMMYYYY);
			return sdf.format(value);
		} else {
			return value.toString();
		}
	}
}
