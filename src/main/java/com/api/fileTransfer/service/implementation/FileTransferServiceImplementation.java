package com.api.fileTransfer.service.implementation;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.fileTransfer.model.File;
import com.api.fileTransfer.repository.FileTransferRepository;
import com.api.fileTransfer.service.FileTransferService;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service("fileTranferService")
public class FileTransferServiceImplementation implements FileTransferService {

	@Autowired
	private FileTransferRepository fileTransferRepository;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@Autowired
	private GridFsOperations operations;

	@Override
	public String insertFile(MultipartFile file) {
		try {

			gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());

		} catch (IOException e) {

			return "Failed to process file";

		}

		return "Your file has been successfully saved";
	}

	@Override
	public File returnFile(ObjectId id) {

		GridFSFile expectedFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
		File file = new File();
		file.setNameFile(expectedFile.getFilename());
		try {
			file.setStream(operations.getResource(expectedFile).getInputStream());
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;

	}

	public String deleteFile(ObjectId id) {

		gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));

		return "Your file has been successfully deleted";

	}

}
