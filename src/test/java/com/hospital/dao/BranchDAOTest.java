package com.hospital.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.hospital.model.Branch;

class BranchDAOTest {
	
	@BeforeClass

	@Test
	void testAddBranch() throws ClassNotFoundException, SQLException {
		Branch branch = new Branch();
		
		branch.setBranchName("NewTest");
		branch.setBranchAddress("Test");
		branch.setBranchEmail("test@gmail.com");
		branch.setBranchTel("101010");
		BranchDAO branchDao = new BranchDAO();
		
		assertEquals("Branch Added Successfully", true,BranchDAO.addBranch(branch));
	}

	@Test
	void testGetSpecificBranch() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllBranch() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBranch() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBranch() {
		fail("Not yet implemented");
	}

}
