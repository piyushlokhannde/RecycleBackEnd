package com.sungard.recycle.calculation;

import com.sungard.recycle.dto.SprintParameter;

import java.math.BigDecimal;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
public interface IParamType {
    BigDecimal calculateParameterPoint(SprintParameter sprintParameter);
}
