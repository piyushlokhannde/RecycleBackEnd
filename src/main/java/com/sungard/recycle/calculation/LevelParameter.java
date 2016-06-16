package com.sungard.recycle.calculation;

import com.sungard.recycle.dto.SprintParameter;
import com.sungard.recycle.factory.UnitTypeFacotry;

import java.math.BigDecimal;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
public class LevelParameter implements IParamType {
    public BigDecimal calculateParameterPoint(SprintParameter sprintParameter){
        BigDecimal parameterPoint = null;
        IUnitType unitType = UnitTypeFacotry.getUnitType(sprintParameter.getUnits());
        parameterPoint = unitType.calculateParameterPoint(sprintParameter);
        return parameterPoint;
    }
}
