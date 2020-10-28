package com.ridgeline.example.index.service.interfaces;

import com.ridgeline.example.index.exception.IndexException;
import com.ridgeline.example.index.model.interfaces.IndexModel;

public interface FileService {
	public void writeToJSONFile(IndexModel divisionIndexModel) throws IndexException;
}
