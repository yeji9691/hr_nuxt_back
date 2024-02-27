package kr.co.seoulit.erp.hr.conexpense.servicefacade;

import kr.co.seoulit.erp.hr.conexpense.to.ConExpenseTO;

import java.util.ArrayList;

public interface ConExpenseServiceFacade {

    ArrayList<ConExpenseTO> getAllConExpenseList();

    // 경조사 신청 조회
    ArrayList<ConExpenseTO> getConExpenseList(String startDate, String endDate, String searchEmpCode);

    // 경조사 신청 등록
    void insertConExpense(ConExpenseTO conExpenseTO);

    // 경조사 신청 수정
    void updateConExpense(ConExpenseTO conExpenseTO);

    // 경조사 신청 삭제
    void deleteConExpense(String reqNum);
}
