package com.sungard.recycle.calculation;

import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.utility.SprinterConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Manjit.Kumar on 6/16/2016.
 */
public class HoursUnitType implements IUnitType {

 public  BigDecimal calculateParameterPoint(SprintParameter sprintParameter){
     BigDecimal parameterPoint = BigDecimal.ZERO;
        BigDecimal hourUnit = sprintParameter.getActualValue();
        parameterPoint = hourUnit.divide(BigDecimal.valueOf(2l), RoundingMode.HALF_UP);
        if(parameterPoint.compareTo(BigDecimal.valueOf(SprinterConstants.GOOD_TO_HAVE_POINTS)) > 0){
            parameterPoint = BigDecimal.valueOf(SprinterConstants.GOOD_TO_HAVE_POINTS);
        }
        return parameterPoint;
    }
}
