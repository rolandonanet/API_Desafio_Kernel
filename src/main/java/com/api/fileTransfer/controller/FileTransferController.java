package com.api.fileTransfer.controller;

import com.api.fileTransfer.model.response.FileTransferInformationResponse;
import com.api.fileTransfer.service.FileTransferInformationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.fileTransfer.model.File;
import com.api.fileTransfer.service.FileTransferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Api;

import java.util.List;

@Api(tags = "FileTransfer")
@RestController
@RequestMapping("/fileTransfer")
public class FileTransferController {

	@Autowired
	private FileTransferService service;

	@Autowired
	private FileTransferInformationService informationService;

	@ApiOperation(value = "Insert File")
	@RequestMapping(method = RequestMethod.POST)
	public String create(@ApiParam(value = "entity", required = true) @RequestParam("file") MultipartFile file) {
		return service.insertFile(file);
	}

	@ApiOperation(value = "Get File")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<InputStreamResource> read(
			@ApiParam(value = "id", required = true) @PathVariable ObjectId id) {

		File file = service.returnFile(id);
		InputStreamResource resource = new InputStreamResource(file.getStream());

		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}

	@ApiOperation(value = "delete")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String delete(@ApiParam(value = "id", required = true) @PathVariable ObjectId id) {
		return service.deleteFile(id);
	}

	@ApiOperation(value = "Show pageable list of files information")
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<FileTransferInformationResponse> list(
			@RequestParam(value = "page number", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
		return informationService.list(pageNumber, pageSize);
	}

}
