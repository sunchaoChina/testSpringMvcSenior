package com.rederfile.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.junit.Test;

public class XmlReaderTest {

	@Test
	@SuppressWarnings("unchecked")
	public void testReadMap() {
		Map<String, Object> resultMaps = new HashMap<String, Object>();
		XmlReader xmlReader = XmlReader.gitInstance();
		Document document = xmlReader.getXMLDocument("readerFile/xml/securites_20171208.xml");
		Object datas = xmlReader.nodesParse(document.getRootElement());
		if (datas instanceof List) {
			List<Object> xmlDatas = (List<Object>) datas;
			for (Object data : xmlDatas) {
				String securityId = ((Map<String, Object>) data).get("SecurityID").toString();
				resultMaps.put(securityId, data);
			}
		} else if (datas instanceof Map) {
			Object securityData = ((Map<String, Object>) datas).get("Security");
			String securityId = ((Map<String, Object>) securityData).get("SecurityID").toString();
			resultMaps.put(securityId, securityData);
		}
	}
}
