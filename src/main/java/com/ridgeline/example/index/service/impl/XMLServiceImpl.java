package com.ridgeline.example.index.service.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ridgeline.example.index.service.interfaces.XMLService;

@Service
public class XMLServiceImpl implements XMLService {

	@Override
	public XPath createXPath() {
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		return xpath;
	}

	@Override
	public Document createDocument(File file) {
		Document result = null;

		try {
			if (null != file) {
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

				docBuilderFactory.setNamespaceAware(false);

				result = docBuilderFactory.newDocumentBuilder().parse(file);
				
				result.normalize();
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
