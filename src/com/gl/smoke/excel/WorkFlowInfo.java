package com.gl.smoke.excel;

import com.gl.smoke.utilities.ReadFromEXcel;

public class WorkFlowInfo {
	
	public static Object[][] getValidData(){
		Object[][] info = ReadFromEXcel.readFromExcel("workFlow","workFlow");
		return info;
		
	}

}
