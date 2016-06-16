package com.sungard.recycle.factory;

import com.sungard.recycle.calculation.HoursUnitType;
import com.sungard.recycle.calculation.IUnitType;
import com.sungard.recycle.calculation.InstanceUnitType;
import com.sungard.recycle.calculation.PercentageUnitType;

/**
 * Created by Manjit.Kumar on 6/16/2016.
 */
public class UnitTypeFacotry {

    public static IUnitType getUnitType(String unitType){
        IUnitType unitTypeObj = null;
        if("HOURS".equalsIgnoreCase(unitType)){
            unitTypeObj = new HoursUnitType();
        } else if("PERCENTAGE".equalsIgnoreCase(unitType)){
            unitTypeObj = new PercentageUnitType();
        } else if("INSTANCE".equalsIgnoreCase(unitType)){
            unitTypeObj = new InstanceUnitType();
        }
        return unitTypeObj;
    }
}
