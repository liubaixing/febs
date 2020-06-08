package com.febs.common.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.febs.common.enums.VerifyEnum;

public class VerifyConverter implements Converter<Byte> {
    @Override
    public Class supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Byte convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(Byte b, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        switch (b){
            case 0:
                return new CellData(VerifyEnum.UNSUBMITTED.getLable());
            case 1:
                return new CellData(VerifyEnum.SUBMITTED.getLable());
            case 2:
                return new CellData(VerifyEnum.VERIFY.getLable());
            case 3:
                return new CellData(VerifyEnum.RETURN.getLable());
            default:
                return new CellData("未知");
        }
    }

}
