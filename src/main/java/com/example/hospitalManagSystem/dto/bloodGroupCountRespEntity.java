package com.example.hospitalManagSystem.dto;

import com.example.hospitalManagSystem.Entity.type.BloodGroupType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class bloodGroupCountRespEntity {
    private BloodGroupType bloodgroup;
    private long count;
}
