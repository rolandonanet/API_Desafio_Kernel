package com.api.fileTransfer.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FileTransferInformationResponse {
	private String id;
	private String name;
	private String filetype;
	private String size;
	private String since_added;
}
