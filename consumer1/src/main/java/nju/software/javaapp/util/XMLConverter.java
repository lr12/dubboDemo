package nju.software.javaapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;

public class XMLConverter {
	private static String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	// private static String XML_CHEAK
	// =" xmlns=\"http://dataexchange.court.gov.cn/2009/data\"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"xsi:schemaLocation=\"http://dataexchange.court.gov.cn/2009/data _";
	/*
	 * 将Case类型的XstreamModel转出为XML格式
	 * 
	 * @param src 源XstreamModel
	 * 
	 * @return XML字符串结果
	 * 
	 * @throws XMLParseException
	 */
	public static String convertCaseToXml(Object src) {
		String xmlRes = null;
		XStream xStream = new XStream();
		try {
			xStream.processAnnotations(src.getClass());
			xmlRes = xStream.toXML(src);
		} catch (Exception e) {
		}
		return xmlRes.replaceAll("__", "_");
	}

	/**
	 * 将xml String对象转化为xml文件
	 * 
	 * @param xmlStr
	 * @param filename
	 * @throws IOException
	 * @throws XmlFileWriteException
	 */
	public static void writeFile(String xmlStr, String filename)
			throws IOException {
		File file = new File(filename);
		if (!file.exists())
			file.createNewFile();
		// 写入文件的时候可能需要验证一下
		FileOutputStream fos = new FileOutputStream(filename);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		String xmlStr2 = xmlStr.replaceAll("__", "_");
		osw.write(XML_HEADER + "\n" + xmlStr2);
		osw.flush();
		fos.close();
		osw.close();
	}

	/**
	 * 针对与案实体名录中的“自然人基本情况”和“单位基本情况”的过滤
	 * 
	 * @param xml
	 * @param filterType
	 * @return
	 */
	public static String filterXml(String xml, int filterType) {
		String filter_s = "";
		String filter_e = "";
		switch (filterType) {
		// zrrjbqk
		case 1:
			filter_s = "<zrrjbqk>";
			filter_e = "</zrrjbqk>";
			break;
		// dwjbqk
		case 2:
			filter_s = "<dwjbqk>";
			filter_e = "</dwjbqk>";
			break;
		}
		while (xml.indexOf(filter_s) >= 0) {
			int index_s = xml.indexOf(filter_s);
			int index_e = xml.indexOf(filter_e);
			String middle_str = xml.substring(index_s, index_e);
			middle_str = middle_str.replaceAll("\n        ", "\n      ");
			xml = xml.substring(0, index_s) + middle_str
					+ xml.substring(index_e);
			xml = xml.replaceFirst(filter_s + "\n      ", "");
			xml = xml.replaceFirst("  " + filter_e + "\n    ", "");
		}
		return xml;
	}
}
