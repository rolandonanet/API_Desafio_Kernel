package com.api.fileTransfer.model.DTO;

import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileTransferDTO {

	private ObjectId _id;
	private String fileEncoded;

//	private String nameFile;
//	private InputStream file;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//	private Date day;

	public String get_id() {
		return _id.toHexString();
	}

}
