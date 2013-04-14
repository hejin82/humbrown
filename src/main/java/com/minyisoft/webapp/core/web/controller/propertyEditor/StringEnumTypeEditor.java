package com.minyisoft.webapp.core.web.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.minyisoft.webapp.core.model.enumField.ICoreEnum;

/**
 * 系统整形枚举转换器
 * @author qingyong_ou
 *
 */
public class StringEnumTypeEditor extends PropertyEditorSupport {
	private ICoreEnum<String>[] stringEnums;

	public StringEnumTypeEditor(ICoreEnum<String>[] stringEnums) {
		this.stringEnums = stringEnums;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isBlank(text)) {
			setValue(null);
		}
		for (ICoreEnum<String> intEnum : this.stringEnums) {
			if (intEnum.getValue().equals(text)) {
				setValue(intEnum);
				return;
			}
		}
		setValue(null);
	}
}
