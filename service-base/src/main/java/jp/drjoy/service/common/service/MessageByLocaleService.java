package jp.drjoy.service.common.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class MessageByLocaleService {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String msg) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(msg, null, locale);
	}
}
