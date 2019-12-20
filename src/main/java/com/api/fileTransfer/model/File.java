package com.api.fileTransfer.model;

import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {

	private ObjectId _id;
	private String nameFile;
	private InputStream stream;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//	private Date day;

	public String get_id() {
		return _id.toHexString();
	}

}
