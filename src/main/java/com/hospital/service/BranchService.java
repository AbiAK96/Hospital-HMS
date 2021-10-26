package com.hospital.service;

import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.BranchDAO;
import com.hospital.model.Branch;

public class BranchService {
	
	public boolean addBranch(Branch branch) throws ClassNotFoundException, SQLException {
		return BranchDAO.addBranch(branch);
	}
	
	public Branch getSpecificBranch(int branchId) throws ClassNotFoundException, SQLException {
		return BranchDAO.getSpecificBranch(branchId);
	}
	
	public List<Branch> getAllBranch() throws ClassNotFoundException, SQLException {
		List<Branch> branches = BranchDAO.getAllBranch();
		
		for(Branch branch : branches) {
			System.out.println(branch.getBranchId());
		}
		
		return BranchDAO.getAllBranch();
	}
	
	public boolean updateTheBranch(Branch branch) throws ClassNotFoundException, SQLException {
		return BranchDAO.updateBranch(branch);
	}
	
	public boolean deleteBranch(int branchId) throws ClassNotFoundException, SQLException {
		return BranchDAO.deleteBranch(branchId);
	}

}
