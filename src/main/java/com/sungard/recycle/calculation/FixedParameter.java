package com.sungard.recycle.calculation;

import com.sungard.recycle.dto.SprintParameter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
public class FixedParameter implements IParamType {
    public BigDecimal calculateParameterPoint(SprintParameter sprintParameter){
        BigDecimal parameterPoint = null;
        BigDecimal variationPer = BigDecimal.ZERO;;
        boolean isPositiveAdj = false;
        BigDecimal diff = BigDecimal.ZERO;
        BigDecimal avgLimt = BigDecimal.ZERO;;
        boolean isHigherTheBetter = sprintParameter.getIsHigherTheBetter();
            if(sprintParameter.getActualValue().compareTo(BigDecimal.valueOf(sprintParameter.getStartValue())) == 0){
                parameterPoint = BigDecimal.valueOf(100l);
                isPositiveAdj = true;
            } else {
                avgLimt = BigDecimal.valueOf(sprintParameter.getStartValue());
                if(sprintParameter.getActualValue().compareTo(BigDecimal.valueOf(sprintParameter.getStartValue())) < 0){
                    diff = BigDecimal.valueOf(sprintParameter.getStartValue()).subtract(sprintParameter.getActualValue());
                    if(isHigherTheBetter){
                        isPositiveAdj = false;
                    } else{
                        isPositiveAdj = true;
                    }
                } else {
                    diff = sprintParameter.getActualValue().subtract(BigDecimal.valueOf(sprintParameter.getEndValue()));
                    if(isHigherTheBetter){
                        isPositiveAdj = true;
                    } else{
                        isPositiveAdj = false;
                    }
                }
                variationPer = (BigDecimal.valueOf(100l).divide(avgLimt,2,RoundingMode.HALF_UP)).multiply(diff);
                if(variationPer.compareTo(BigDecimal.valueOf(25l)) > 0){
                    variationPer = BigDecimal.valueOf(25l);
                }

            }
        BigDecimal amtAdj =
                sprintParameter.getExpectedTotal().multiply(variationPer.divide(BigDecimal.valueOf(100l),2,RoundingMode.HALF_UP));
        if(isPositiveAdj){
            parameterPoint = sprintParameter.getExpectedTotal().add(amtAdj);
        } else {
            parameterPoint = sprintParameter.getExpectedTotal().subtract(amtAdj);
        }

        return parameterPoint;
    }
}
