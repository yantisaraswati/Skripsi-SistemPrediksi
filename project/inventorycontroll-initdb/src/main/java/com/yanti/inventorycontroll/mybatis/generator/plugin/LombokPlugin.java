package com.yanti.inventorycontroll.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A MyBatis Generator plugin to use Lombok's annotations. For Criteria, use @Data
 * annotation instead of getter and setter.
 * 
 * /**
 *
 * @author Admin-NDID
 */
public class LombokPlugin extends PluginAdapter {

	private final Collection<Annotations> annotations;
	
	public static final String VALIDATION_ERROR_MESSAGE = "ValidationError.18";
	public static final String CLASS_SEARCH_PROPERTY = "classMethodSearchString";
	public static final String CLASS_REPLACE_PROPERTY = "classMethodReplaceString";
	public static final String PARAM_SEARCH_PROPERTY = "parameterSearchString";
	public static final String PARAM_REPLACE_PROPERTY = "parameterReplaceString";
	private String classMethodReplaceString;
	private Pattern classMethodPattern;
	private String parameterReplaceString;
	private Pattern parameterPattern;

	/**
	 * LombokPlugin constructor
	 */
	public LombokPlugin() {
		annotations = new HashSet<Annotations>(Annotations.values().length);
	}

	/**
	 * @param warnings
	 * @return always true
	 */
	public boolean validate(List<String> warnings) {
		String classMethodSearchString = properties.getProperty(CLASS_SEARCH_PROPERTY);
		classMethodReplaceString = properties.getProperty(CLASS_REPLACE_PROPERTY);

		String parameterSearchString = properties.getProperty(PARAM_SEARCH_PROPERTY);
		parameterReplaceString = properties.getProperty(PARAM_REPLACE_PROPERTY);

		boolean valid = stringHasValue(classMethodSearchString) && stringHasValue(classMethodReplaceString)
				&& stringHasValue(parameterSearchString) && stringHasValue(parameterReplaceString);

		if (valid) {
			classMethodPattern = Pattern.compile(classMethodSearchString);
			parameterPattern = Pattern.compile(parameterSearchString);
		} else {
			if (!stringHasValue(classMethodSearchString)) {
				warnings.add(getString(VALIDATION_ERROR_MESSAGE,
						LombokPlugin.class.getSimpleName(), CLASS_SEARCH_PROPERTY));
			}
			if (!stringHasValue(classMethodReplaceString)) {
				warnings.add(getString(VALIDATION_ERROR_MESSAGE,
						LombokPlugin.class.getSimpleName(), CLASS_REPLACE_PROPERTY));
			}
			if (!stringHasValue(parameterSearchString)) {
				warnings.add(getString(VALIDATION_ERROR_MESSAGE,
						LombokPlugin.class.getSimpleName(), PARAM_SEARCH_PROPERTY));
			}
			if (!stringHasValue(parameterReplaceString)) {
				warnings.add(getString(VALIDATION_ERROR_MESSAGE,
						LombokPlugin.class.getSimpleName(), PARAM_REPLACE_PROPERTY));
			}
		}

		return valid;
	}
	
	@Override
	public void initialized(IntrospectedTable table) {
		super.initialized(table);

		{
			String name = table.getMyBatis3JavaMapperType();
			table.setMyBatis3JavaMapperType(name.replaceAll("Mapper", "Repository"));
		}

		{
			String name = table.getMyBatis3XmlMapperFileName();
			table.setMyBatis3XmlMapperFileName(name.replaceAll("Mapper", "Repository"));
		}
		
		String oldType = table.getExampleType();
		Matcher matcher = classMethodPattern.matcher(oldType);
		oldType = matcher.replaceAll(classMethodReplaceString);
		table.setExampleType(oldType);
	}

	/**
	 * Intercepts base record class generation
	 *
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		addDataAnnotation(topLevelClass);
		return true;
	}

	/**
	 * Intercepts primary key class generation
	 *
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		addDataAnnotation(topLevelClass);
		return true;
	}

	/**
	 * Intercepts "record with blob" class generation
	 *
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean modelRecordWithBLOBsClassGenerated(
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addDataAnnotation(topLevelClass);
		return true;
	}

	/**
	 * Prevents all getters from being generated. See SimpleModelGenerator
	 *
	 * @param method
	 * @param topLevelClass
	 * @param introspectedColumn
	 * @param introspectedTable
	 * @param modelClassType
	 * @return
	 */
	@Override
	public boolean modelGetterMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}

	/**
	 * Prevents all setters from being generated See SimpleModelGenerator
	 *
	 * @param method
	 * @param topLevelClass
	 * @param introspectedColumn
	 * @param introspectedTable
	 * @param modelClassType
	 * @return
	 */
	@Override
	public boolean modelSetterMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return false;
	}

	/**
	 * Adds the lombok annotations' imports and annotations to the class
	 *
	 * @param topLevelClass
	 */
	private void addDataAnnotation(TopLevelClass topLevelClass) {
		for (Annotations annotation : annotations) {
			topLevelClass.addImportedType(annotation.javaType);
			topLevelClass.addAnnotation(annotation.name);
		}
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);

		// @Data is default annotation
		annotations.add(Annotations.DATA);

		for (Entry<Object, Object> entry : properties.entrySet()) {
			boolean isEnable = Boolean
					.parseBoolean(entry.getValue().toString());

			if (isEnable) {
				String paramName = entry.getKey().toString().trim();
				Annotations annotation = Annotations.getValueOf(paramName);
				if (annotation != null) {
					annotations.add(annotation);
					annotations.addAll(Annotations.getDependencies(annotation));
				}
			}
		}
	}

	private enum Annotations {
		DATA("data", "@Data", "lombok.Data"), BUILDER("builder", "@Builder",
				"lombok.Builder"), ALL_ARGS_CONSTRUCTOR("allArgsConstructor",
				"@AllArgsConstructor", "lombok.AllArgsConstructor"), NO_ARGS_CONSTRUCTOR(
				"noArgsConstructor", "@NoArgsConstructor",
				"lombok.NoArgsConstructor"), TO_STRING("toString", "@ToString",
				"lombok.ToString");

		private final String paramName;
		private final String name;
		private final FullyQualifiedJavaType javaType;

		Annotations(String paramName, String name, String className) {
			this.paramName = paramName;
			this.name = name;
			this.javaType = new FullyQualifiedJavaType(className);
		}

		private static Annotations getValueOf(String paramName) {
			for (Annotations annotation : Annotations.values())
				if (String.CASE_INSENSITIVE_ORDER.compare(paramName,
						annotation.paramName) == 0)
					return annotation;

			return null;
		}

		private static Collection<Annotations> getDependencies(
				Annotations annotation) {
			if (annotation == ALL_ARGS_CONSTRUCTOR)
				return Collections.singleton(NO_ARGS_CONSTRUCTOR);
			else
				return Collections.emptyList();
		}
	}
	
	boolean renameMethod(Method method) {
		String oldMethodName = method.getName();
		Matcher matcher = classMethodPattern.matcher(oldMethodName);
		String newMethodName = matcher.replaceAll(classMethodReplaceString);
		method.setName(newMethodName);

		for (int i = 0; i < method.getParameters().size(); i++) {
			Parameter parameter = method.getParameters().get(i);
			String oldParamName = parameter.getName();
			matcher = parameterPattern.matcher(oldParamName);
			if (matcher.lookingAt()) {
				String newName = matcher.replaceAll(parameterReplaceString);
				Parameter newParam = new Parameter(parameter.getType(), newName, parameter.isVarargs());
				for (String annotation : parameter.getAnnotations()) {
					newParam.addAnnotation(annotation);
				}
				method.getParameters().set(i, newParam);
			}
		}
		return true;
	}
	
	boolean renameElement(XmlElement element) {
		for (int i = 0; i < element.getAttributes().size(); i++) {
			Attribute attribute = element.getAttributes().get(i);
			if ("id".equals(attribute.getName())) {
				String oldValue = attribute.getValue();
				Matcher matcher = classMethodPattern.matcher(oldValue);
				String newValue = matcher.replaceAll(classMethodReplaceString);
				Attribute newAtt = new Attribute(attribute.getName(), newValue);
				element.getAttributes().set(i, newAtt);
			}
		}

		return true;
}
	
	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}
	
	@Override
	public boolean clientCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}
	
	@Override
	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}
	
	@Override
	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}

	@Override
	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return renameMethod(method);
	}
	
	@Override
	public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		return renameElement(element);
	}

	@Override
	public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		return renameElement(element);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return renameElement(element);
	}

	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return renameElement(element);
	}

	@Override
	public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		removeIdColumns(introspectedTable, element);
		return renameElement(element);
	}

	@Override
	public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		removeIdColumns(introspectedTable, element);
		return renameElement(element);
	}

	@Override
	public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		removeIdColumns(introspectedTable, element);
		return renameElement(element);
	}
	
	void removeIdColumns(IntrospectedTable introspectedTable, XmlElement element) {
//		List<String> updates = new ArrayList<>();
//
//		String alias = introspectedTable.getTableConfiguration().getAlias();
//		if (alias == null) {
//			alias = "";
//		} else {
//			alias = alias + ".";
//		}
//
//		List<IntrospectedColumn> ids = introspectedTable.getPrimaryKeyColumns();
//		for (IntrospectedColumn column : ids) {
//			String update = String.format("%4$s%1$s = #{record.%2$s,jdbcType=%3$s},", column.getActualColumnName(),
//					column.getJavaProperty(), column.getJdbcTypeName(), alias);
//			/*log.debug("update: {}", update);*/
//			updates.add(update);
//		}
//
//		if (!updates.isEmpty()) {
//			removeIdColumns(updates, element, null, -1);
//		}
	}
	
	void removeIdColumns(List<String> updates, Element element, XmlElement parent, int index) {
		/*log.debug("element type: {}", element.getClass().getSimpleName());
		log.debug("element: {}", element.getFormattedContent(0));*/

		if (element instanceof TextElement) {
			TextElement textElement = (TextElement) element;
			for (String update : updates) {
				if (textElement.getContent().contains(update)) {
					TextElement newElement = new TextElement(textElement.getContent().replace(update, ""));
					parent.getElements().set(index, newElement);
				}
			}
		} else if (element instanceof XmlElement) {
			XmlElement xmlElement = (XmlElement) element;
			for (int i = 0; i < xmlElement.getElements().size(); i++) {
				Element e = xmlElement.getElements().get(i);
				removeIdColumns(updates, e, xmlElement, i);
			}
		}
	}
	
}
