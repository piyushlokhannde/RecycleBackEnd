package com.sungard.recycle.calculation;

import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.utility.SprinterConstants;

import java.math.BigDecimal;

/**
 * Created by Manjit.Kumar on 6/16/2016.
 */
public class InstanceUnitType implements IUnitType {
    public BigDecimal calculateParameterPoint(SprintParameter sprintParameter){
        BigDecimal parameterPoint = null;
        parameterPoint = sprintParameter.getActualValue();
        if(parameterPoint.compareTo(BigDecimal.valueOf(SprinterConstants.GOOD_TO_HAVE_POINTS)) > 0){
            parameterPoint = BigDecimal.valueOf(SprinterConstants.GOOD_TO_HAVE_POINTS);
        }

        return parameterPoint;
    }
}
