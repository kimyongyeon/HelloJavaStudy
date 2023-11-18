package com.kyy.java.mission.bankapp.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class BaseVO {
    LocalDateTime regDate;
    String register;
    LocalDateTime modDate;
    String modifier;
}
