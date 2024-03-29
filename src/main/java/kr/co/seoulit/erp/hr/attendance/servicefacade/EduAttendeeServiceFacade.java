package kr.co.seoulit.erp.hr.attendance.servicefacade;

import kr.co.seoulit.erp.hr.attendance.to.EduAttendeeTO;

import java.util.List;

public interface EduAttendeeServiceFacade {

	public List<EduAttendeeTO> getAttendeeAll();

	public List<EduAttendeeTO> getAttendeeList(String classCode);

	public EduAttendeeTO getAttendee(String empNo);

	public void addAttendee(EduAttendeeTO to);

	public void removeAttendee(String empNo, String classCode);

	public void modifyAttendee(EduAttendeeTO to);

}
