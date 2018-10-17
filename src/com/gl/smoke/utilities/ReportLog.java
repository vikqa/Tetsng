package com.gl.smoke.utilities;

import com.relevantcodes.extentreports.LogStatus;

public class ReportLog {

	public static String error;

	public static void addToReportLog(String des, LogStatus status) {
		error = des + "%" + status + "~";
	}

}
