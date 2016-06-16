package com.sungard.recycle.factory;

import com.sungard.recycle.calculation.FixedParameter;
import com.sungard.recycle.calculation.IParamType;
import com.sungard.recycle.calculation.LevelParameter;
import com.sungard.recycle.calculation.RangeParameter;

/**
 * Created by Manjit.Kumar on 6/15/2016.
 */
public class ParamTypeFactory {

    public static IParamType getParamType(String paramType){
        IParamType paramTypeObj = null;
        if("Fixed".equalsIgnoreCase(paramType)){
            paramTypeObj = new FixedParameter();
        } else if("Range".equalsIgnoreCase(paramType)){
            paramTypeObj = new RangeParameter();
        } else if("Level".equalsIgnoreCase(paramType)){
            paramTypeObj = new LevelParameter();
        }
        return paramTypeObj;
    }
}
