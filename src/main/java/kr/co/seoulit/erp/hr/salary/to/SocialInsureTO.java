package kr.co.seoulit.erp.hr.salary.to;

import lombok.Data;

@Data

public class SocialInsureTO{
	private String attributionYear,
	healthinsureRates,
	longtermcareRate,
	nationpensionRates,
	teachpenisionRates,
	empinsureRates,
	wrkinsureRates,
	jobstabilRates,
	vocacompetencyRates,
	industinsureRates,
	industinsurecharRates;
}