package com.ridgeline.example.index.service.interfaces;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;

import com.ridgeline.example.index.exception.IndexException;
import com.ridgeline.example.index.model.interfaces.IndexModel;

public interface IndexService {
	public IndexModel generateIndex(Document document, XPath xpath) throws IndexException;
}
