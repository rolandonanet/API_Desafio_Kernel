package com.api.fileTransfer.service;

import com.api.fileTransfer.model.response.FileTransferInformationResponse;

import java.util.List;

public interface FileTransferInformationService {

	List<FileTransferInformationResponse> list(Integer pageNumber, Integer pageSize);

}
