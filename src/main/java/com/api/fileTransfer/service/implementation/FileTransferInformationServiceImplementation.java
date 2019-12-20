package com.api.fileTransfer.service.implementation;

import com.api.fileTransfer.model.response.FileTransferInformationResponse;
import com.api.fileTransfer.repository.FileTransferRepository;
import com.api.fileTransfer.service.FileTransferInformationService;
import com.api.fileTransfer.utils.Converter;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service("fileTranferInformationService")
public class FileTransferInformationServiceImplementation implements FileTransferInformationService {

	@Autowired
	private Converter converter;

	@Autowired
	private FileTransferRepository fileTransferRepository;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@Autowired
	private GridFsOperations operations;

	@Override
	public List<FileTransferInformationResponse> list(Integer pageNumber, Integer pageSize) {

		List<FileTransferInformationResponse> convertedResponse = new ArrayList<>();

		gridFsTemplate.find(new Query()).forEach(
				(Consumer<GridFSFile>) gridFSFile -> convertedResponse.add(converter.gridFSFileToResponse(gridFSFile)));

		List<FileTransferInformationResponse> response = converter.paginateFileResponse(convertedResponse, pageNumber,
				pageSize);

		return response;
	}
}
