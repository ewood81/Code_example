package com.ridgeline.example.index.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridgeline.example.index.exception.IndexException;
import com.ridgeline.example.index.model.interfaces.IndexModel;
import com.ridgeline.example.index.service.interfaces.FileService;

@Service
public class FileServiceImpl implements FileService{

	private static Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
	
	@Override
	public void writeToJSONFile(IndexModel divisionIndexModel) throws IndexException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String home = System.getProperty("user.home");
		
		if(StringUtils.isNotBlank(home)) {
			log.info("User's home directory retrieved as: {}", home);
			
			File file = new File(home + File.separator + "Downloads" + File.separator + "mlb" + ".json");
			
			try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8")){
				outputStreamWriter.write(objectMapper.writeValueAsString(divisionIndexModel));
			} 
			catch (UnsupportedEncodingException e) {
				log.warn("Exception of type {} was thrown!", e.getClass().getName());
				
				throw new IndexException(e.getMessage(), e.getCause());
			} 
			catch (FileNotFoundException e) {
				log.warn("Exception of type {} was thrown!", e.getClass().getName());
				
				throw new IndexException(e.getMessage(), e.getCause());
			} 
			catch (IOException e) {
				log.warn("Exception of type {} was thrown!", e.getClass().getName());
				
				throw new IndexException(e.getMessage(), e.getCause());
			}
		}
	}
}
