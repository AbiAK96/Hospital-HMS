/*
import java.sql.SQLException;
import java.util.List;

import com.hospital.dao.BranchDAO;
import com.hospital.dao.EmployeeDAO;
import com.hospital.model.Branch;

public class BranchTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Branch branch = new Branch();
		branch.setBranchName("NewTest");
		branch.setBranchAddress("Test");
		branch.setBranchEmail("test@gmail.com");
		branch.setBranchTel("101010");
		BranchDAO branchDao = new BranchDAO();
		
		//add
		branchDao.addBranch(branch);
		
		// read
        Branch b = branchDao.getSpecificBranch(1);
        System.out.println(b.getBranchId() + " "
                           + b.getBranchName() + " "
                           + b.getBranchAddress());
		
        // read All
        List<Branch> branchlists = branchDao.getAllBranch();
        for (Branch allbranch : branchlists) {
            System.out.println(allbranch);
        }
        
        // update
        Branch upBranch = branchDao.getSpecificBranch(1);
        upBranch.setBranchName("Asgard");
        branchDao.updateBranch(upBranch);
        
        //delete
        BranchDAO.deleteBranch(20);
        
	}

}*/
