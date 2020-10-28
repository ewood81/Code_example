package com.ridgeline.example.index.utility;

import java.io.File;

import javax.xml.xpath.XPath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.ridgeline.example.index.exception.IndexException;
import com.ridgeline.example.index.model.interfaces.IndexModel;
import com.ridgeline.example.index.service.interfaces.FileService;
import com.ridgeline.example.index.service.interfaces.IndexService;
import com.ridgeline.example.index.service.interfaces.XMLService;

@Component
public class IndexGeneratorUtil {
	private static Logger log = LoggerFactory.getLogger(IndexGeneratorUtil.class);
	
	private IndexService indexService;
	
	private XMLService xmlService;
	
	private FileService fileService;
	
	@Autowired
	public IndexGeneratorUtil(IndexService indexService, XMLService xmlService, FileService fileService) {
		this.indexService = indexService;
		this.xmlService = xmlService;
		this.fileService = fileService;
	}
	
	public void beginIndexCreationProcess(File file) throws IndexException {
		if(null != file) {
			log.info("Creating index from file {}", file.getName());
			
			XPath xpath = xmlService.createXPath();
			
			if(null != xpath) {
				Document d = xmlService.createDocument(file);
				
				if(null != d) {
					IndexModel indexModel = indexService.generateIndex(d, xpath);
					
					if(null != indexModel) {
						fileService.writeToJSONFile(indexModel);
					}
				}
			}
		}
	}
}
