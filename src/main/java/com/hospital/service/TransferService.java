package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.TransferDAO;
import com.hospital.model.Transfer;


public class TransferService {
	
	public boolean addTransfer(Transfer transfer) throws ClassNotFoundException, SQLException {
		return TransferDAO.addTransfer(transfer);
	}
	
	public Transfer getSpecificTransfer(int transferId) throws ClassNotFoundException, SQLException {
		return TransferDAO.getSpecificTransfer(transferId);
	}
	
	public List<Transfer> getAllTransfer() throws ClassNotFoundException, SQLException {
		return TransferDAO.getAllTransfer();
	}
	
	public boolean updateTransfer(Transfer transfer) throws ClassNotFoundException, SQLException {
		return TransferDAO.updateTransfer(transfer);
	}
	
	public boolean deleteTransfer(int transferId) throws ClassNotFoundException, SQLException {
		return TransferDAO.deleteTransfer(transferId);
	}

}
