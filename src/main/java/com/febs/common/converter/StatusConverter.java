package com.febs.common.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.febs.common.enums.StatusEnum;

public class StatusConverter implements Converter<Integer> {
    @Override
    public Class supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(StatusEnum.ENABLE.getLable().equals(cellData.getStringValue()))
            return StatusEnum.ENABLE.getCode();
        else if(StatusEnum.DISABLE.getLable().equals(cellData.getStringValue()))
            return StatusEnum.DISABLE.getCode();
        else
            return 0;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(integer == StatusEnum.ENABLE.getCode())
            return new CellData(StatusEnum.ENABLE.getLable());
        else if(integer == StatusEnum.DISABLE.getCode())
            return new CellData(StatusEnum.DISABLE.getLable());
        else
            return new CellData(StatusEnum.UNKNOWN.getLable());
    }
}
