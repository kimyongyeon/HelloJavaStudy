package com.kyy.java.mission.bankapp.common.helper;

import com.kyy.java.mission.bankapp.common.exception.CommonException;
import com.kyy.java.mission.bankapp.common.exception.ErrorCode;
import com.kyy.java.mission.bankapp.domain.dto.RequestDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.CustomerDTO;

public class CommonUtil {
    public static void isCustomerName(CustomerDTO customerDTO) {
        if (customerDTO.getName().equals("") || customerDTO.getName() == null) {
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }
    }

    public static boolean isRequestNull(RequestDTO<CustomerDTO> requestDTO) {
        if (requestDTO == null) {
            return true;
        }
        return false;
    }

}
