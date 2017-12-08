package com.rederfile.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReader {

	public static XmlReader gitInstance() {
		return new XmlReader();
	}

	/**
	 * 获取xml Document
	 * 
	 * @param filePath
	 * @return
	 */
	public Document getXMLDocument(String filePath) {
		FileInputStream inputStream = null;
		Document document = null;
		try {
			inputStream = new FileInputStream(filePath);
			document = new SAXReader().read(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return document;
	}

	/**
	 * xml节点解析
	 * 
	 * @param element
	 *            根节点
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object nodesParse(Element element) {
		// 获取子节点
		List<Element> childElements = element.elements();
		if (childElements.size() == 0) {
			return element.getTextTrim();
		} else {
			String prevElementName = null;
			boolean isArray = false;
			Iterator<Element> iterator = childElements.iterator();
			while (iterator.hasNext()) {
				Element childElement = iterator.next();
				String elementName = childElement.getName();
				if (prevElementName == null) {
					prevElementName = elementName;
				} else {
					isArray = elementName.equals(prevElementName);
					break;
				}
			}
			iterator = childElements.iterator();
			if (isArray) {
				List<Object> data = new ArrayList<Object>();
				while (iterator.hasNext()) {
					Element childElement = iterator.next();
					data.add(nodesParse(childElement));
				}
				return data;
			} else {
				Map<String, Object> data = new HashMap<String, Object>();
				while (iterator.hasNext()) {
					Element childElement = iterator.next();
					data.put(childElement.getName(), nodesParse(childElement));
				}
				return data;

			}
		}
	}
}
