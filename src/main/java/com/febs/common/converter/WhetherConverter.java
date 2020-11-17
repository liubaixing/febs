package com.febs.common.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class WhetherConverter implements Converter<Byte> {
    @Override
    public Class supportJavaTypeKey() {
        return Byte.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Byte convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if("是".equals(cellData.getStringValue())){
            return 1;
        }else if ("否".equals(cellData.getStringValue())){
            return 0;
        }else{
            return 2;
        }
    }

    @Override
    public CellData convertToExcelData(Byte integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(integer == 0){
            return new CellData("否");
        }else if (integer == 1){
            return new CellData("是");
        }else{
            return new CellData("未知");
        }
    }
}
