package com.api.fileTransfer.repository;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.api.fileTransfer.model.File;
import com.api.fileTransfer.model.DTO.FileTransferDTO;

@Repository
public interface FileTransferRepository extends GenericRepository<File, ObjectId> {

}
