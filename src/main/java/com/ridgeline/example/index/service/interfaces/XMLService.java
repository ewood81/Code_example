package com.ridgeline.example.index.service.interfaces;

import java.io.File;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;

public interface XMLService {
	public XPath createXPath();
	
	public Document createDocument(File file);
}
