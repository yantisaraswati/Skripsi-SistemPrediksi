package com.yanti.inventorycontroll.mybatis.generator.plugin;

import java.util.List;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * Change naming rules of Java class name and XML file name that generated by
 * MyBatis Generator
 */
public class StandardPlugin extends PluginAdapter {
	/**
	 * Constructor
	 */
	public StandardPlugin() {
	}

	/**
	 * Always enable this plug-in
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

	/**
	 * Replace tail of string if end with specified string
	 *
	 * @param oldString
	 *            To replace (remove) tail of name
	 * @param newString
	 *            To replace (overwrite) tail of name
	 * @param sourceString
	 *            To replace whole string
	 * @return Replaced string
	 */
	private String replaceTailString(String oldString, String newString,
			String sourceString) {
		if (!sourceString.endsWith(oldString)) {
			return sourceString;
		}
		return sourceString.substring(0,
				sourceString.length() - oldString.length())
				+ newString;
	}

	/**
	 * Replace string if whole string is expected
	 *
	 * @param oldString
	 *            To replace (remove) name
	 * @param newString
	 *            To replace (overwrite) name
	 * @param sourceString
	 *            To replace whole string
	 * @return Replaced string
	 */
	private String replaceWholeString(String oldString, String newString,
			String sourceString) {
		if (!sourceString.equals(oldString)) {
			return sourceString;
		}
		return newString;
	}

	/**
	 * Called when initialized
	 *
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		// Change tail of name if Java mapper class name is end with Mapper
		introspectedTable.setMyBatis3JavaMapperType(replaceTailString("Mapper",
				"Repository", introspectedTable.getMyBatis3JavaMapperType()));
		// Change tail of name if XML mapper file name is end with Mapper.xml
		introspectedTable.setMyBatis3XmlMapperFileName(replaceTailString(
				"Mapper.xml", "Repository.xml",
				introspectedTable.getMyBatis3XmlMapperFileName()));
	}

	/**
	 * Change method name to "findOne" from "selectByPrimaryKey"
	 *
	 * @param method
	 *            Method
	 * @param interfaze
	 *            Interface
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		// Change name
		method.setName(replaceWholeString("selectByPrimaryKey", "findOne",
				method.getName()));
		// Call super class method
		return super.clientSelectByPrimaryKeyMethodGenerated(method, interfaze,
				introspectedTable);
	}

	/**
	 * Change method name to "findOne" from "selectByPrimaryKey"
	 *
	 * @param method
	 *            Method
	 * @param topLevelClass
	 *            TopLevelClass
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// Change name
		method.setName(replaceWholeString("selectByPrimaryKey", "findOne",
				method.getName()));
		// Call super class method
		return super.clientSelectByPrimaryKeyMethodGenerated(method,
				topLevelClass, introspectedTable);
	}

	/**
	 * Change xml element id to "findOne" from "selectByPrimaryKey"
	 *
	 * @param element
	 *            XmlElement
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		// Remove and add id attribute
		for (int i = 0; i < element.getAttributes().size(); i++) {
			Attribute attribute = element.getAttributes().get(i);
			if (!attribute.getName().equals("id")) {
				continue;
			}
			Attribute newAttribute = new Attribute("id", replaceWholeString(
					"selectByPrimaryKey", "findOne", attribute.getValue()));
			element.getAttributes().remove(i);
			element.addAttribute(newAttribute);
			break;
		}
		// Call super class method
		return super.sqlMapSelectByPrimaryKeyElementGenerated(element,
				introspectedTable);
	}

	/**
	 * Change method name to "findOne" from "selectByPrimaryKey"
	 *
	 * @param method
	 *            Method
	 * @param interfaze
	 *            Interface
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean clientSelectAllMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		// Change name
		method.setName(replaceWholeString("selectAll", "findAll",
				method.getName()));
		return super.clientSelectAllMethodGenerated(method, interfaze,
				introspectedTable);
	}

	/**
	 * Change method name to "findOne" from "selectByPrimaryKey"
	 *
	 * @param method
	 *            Method
	 * @param topLevelClass
	 *            TopLevelClass
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean clientSelectAllMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// Change name
		method.setName(replaceWholeString("selectAll", "findAll",
				method.getName()));
		return super.clientSelectAllMethodGenerated(method, topLevelClass,
				introspectedTable);
	}

	/**
	 * Change xml element id to "findOne" from "selectByPrimaryKey"
	 *
	 * @param element
	 *            XmlElement
	 * @param introspectedTable
	 *            Information of table introspected by MyBatis Generator
	 */
	@Override
	public boolean sqlMapSelectAllElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		// Remove and add id attribute
		for (int i = 0; i < element.getAttributes().size(); i++) {
			Attribute attribute = element.getAttributes().get(i);
			if (!attribute.getName().equals("id")) {
				continue;
			}
			Attribute newAttribute = new Attribute("id", replaceWholeString(
					"selectAll", "findAll", attribute.getValue()));
			element.getAttributes().remove(i);
			element.addAttribute(newAttribute);
			break;
		}
		// Call super class method
		return super.sqlMapSelectByPrimaryKeyElementGenerated(element,
				introspectedTable);
	}
}