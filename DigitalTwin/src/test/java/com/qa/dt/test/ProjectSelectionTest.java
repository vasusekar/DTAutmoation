package com.qa.dt.test;


import org.testng.annotations.Test;

import com.qa.dt.base.BaseClass;
import com.qa.dt.page.ProjectSelectionPage;
import com.qa.dt.util.Xls_Reader;


public class ProjectSelectionTest extends LoginintoTheApplicationTest{
	ProjectSelectionPage psp;
	static Xls_Reader xl = new Xls_Reader();
	
	@Test
	private void ProjectSelection() throws Throwable {
		psp = new ProjectSelectionPage();
		psp.selectProjectFromDd(xl.getCellData("projectSelect","ProjectList",2));
		psp.selectUserGroupFromDd(xl.getCellData("projectSelect","UserGroup",2));
		
	}

}
