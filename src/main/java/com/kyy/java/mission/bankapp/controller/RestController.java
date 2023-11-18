package com.kyy.java.mission.bankapp.controller;

import com.kyy.java.mission.bankapp.common.exception.CommonException;
import com.kyy.java.mission.bankapp.common.exception.ErrorCode;
import com.kyy.java.mission.bankapp.common.exception.SuccessCode;
import com.kyy.java.mission.bankapp.domain.dto.RequestDTO;
import com.kyy.java.mission.bankapp.domain.dto.ResponseDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.AccountDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.CustomerDTO;
import com.kyy.java.mission.bankapp.domain.service.AccountService;
import com.kyy.java.mission.bankapp.domain.service.CustomerService;
import com.kyy.java.mission.bankapp.domain.service.TransactionService;
import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.domain.vo.CustomerVO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kyy.java.mission.bankapp.common.helper.CommonUtil.isCustomerName;
import static com.kyy.java.mission.bankapp.common.helper.CommonUtil.isRequestNull;

@RequiredArgsConstructor
public class RestController {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private CommonException commonException;

    // 회원가입
    public ResponseDTO<CustomerDTO> signUp(RequestDTO<CustomerDTO> requestDTO) {

        if (isRequestNull(requestDTO)) {
            commonException = new CommonException(ErrorCode.SIGNUP_ERROR);
            return ResponseDTO.<CustomerDTO>builder()
                    .code(commonException.getErrorCode())
                    .message(commonException.getErrorMessage())
                    .data(null)
                    .build();
        }

        CustomerDTO customerDTO = requestDTO.getData();

        isCustomerName(customerDTO);

        customerService.signUp(customerDTO);

        System.out.println("회원 가입 완료");


        return ResponseDTO.<CustomerDTO>builder()
                .code(SuccessCode.OK.getCode())
                .message(SuccessCode.OK.getDescription())
                .data(customerDTO)
                .build();
    }


    // 인증
    public ResponseDTO<String> auth(RequestDTO<CustomerDTO> requestDTO) {

        if (isRequestNull(requestDTO)) {
            commonException = new CommonException(ErrorCode.AUTH_ERROR);
            return ResponseDTO.<String>builder()
                    .code(commonException.getErrorCode())
                    .message(commonException.getErrorMessage())
                    .data(null)
                    .build();
        }


        CustomerDTO customerDTO = requestDTO.getData();

        isCustomerName(customerDTO);

        boolean auth = customerService.auth(customerDTO);

        return ResponseDTO.<String>builder()
                .code(SuccessCode.OK.getCode())
                .message(SuccessCode.OK.getDescription())
                .data(auth ? "로그인 성공" : "로그인 실패")
                .build();
    }


    // 회원탈퇴
    public ResponseDTO<String> removeCustomer(RequestDTO<CustomerDTO> requestDTO) {

        if (isRequestNull(requestDTO)) {
            return ResponseDTO.<String>builder()
                    .code(500)
                    .message("fail")
                    .data(null)
                    .build();
        }

        CustomerDTO customerDTO = requestDTO.getData();

        isCustomerName(customerDTO);

        customerService.removeCustomer(customerDTO.getCustomerId());

        return ResponseDTO.<String>builder()
                .code(SuccessCode.OK.getCode())
                .message(SuccessCode.OK.getDescription())
                .data("회원탈퇴 성공")
                .build();
    }

    // 계좌생성
    public ResponseDTO<String> createAccount(RequestDTO<CustomerDTO> requestDTO) {
        CustomerDTO data = requestDTO.getData();
        AccountVO accountVO = AccountVO.builder()
                .owner(CustomerVO.to(data)).build();
        accountService.createAccount(accountVO);
        return ResponseDTO.<String>builder()
                .code(SuccessCode.OK.getCode())
                .message(SuccessCode.OK.getDescription())
                .data("계좌생성 성공")
                .build();
    }

    // 계좌조회
    public ResponseDTO<List<AccountDTO>> getAccountList(RequestDTO<CustomerDTO> requestDTO) {
        List<AccountDTO> accountList = accountService.getAccountList(requestDTO.getData().getCustomerId());
        return ResponseDTO.<List<AccountDTO>>builder()
                .code(SuccessCode.OK.getCode())
                .message(SuccessCode.OK.getDescription())
                .data(accountList)
                .build();
    }

    // 계좌탈퇴
    public void deleteAccount() {


    }


    // 입금
    public void deposit() {

    }

    // 출금
    public void withdraw() {

    }

    // 이체
    public void transfer() {

    }

    // 거래내역조회
    public void getTransaction() {

    }

    // 거래내역삭제
    public void deleteTransaction() {

    }


}
