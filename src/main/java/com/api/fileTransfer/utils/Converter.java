package com.api.fileTransfer.utils;

import com.api.fileTransfer.model.response.FileTransferInformationResponse;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class Converter {
	public FileTransferInformationResponse gridFSFileToResponse(GridFSFile gridFSFile) {

		String fileType = gridFSFile.getFilename().substring(gridFSFile.getFilename().lastIndexOf(".") + 1);
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR"));

		return FileTransferInformationResponse.builder()
				.id(gridFSFile.getId()
				.asObjectId().getValue().toHexString())
				.name(gridFSFile.getFilename())
				.filetype(fileType).size(Long.toString(gridFSFile.getLength()))
				.since_added(dateFormat.format(gridFSFile.getUploadDate()).toString())
				.build();

	}

	public List<FileTransferInformationResponse> paginateFileResponse(List<FileTransferInformationResponse> files,
			Integer pageNumber, Integer pageSize) {
		if ((pageNumber - 1) * pageSize >= files.size()) {
			return new ArrayList<>();
		} else if (pageNumber * pageSize >= files.size()) {
			return new ArrayList<>(files.subList(((pageNumber - 1) * pageSize), files.size()));
		}
		return new ArrayList<>(files.subList(((pageNumber - 1) * pageSize), pageNumber * pageSize));
	}
}
