package com.api.fileTransfer.service;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import com.api.fileTransfer.model.File;

public interface FileTransferService {

	String insertFile(MultipartFile file);

	File returnFile(ObjectId id);

	String deleteFile(ObjectId id);

}
