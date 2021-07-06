package cn.sweet.wife.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author ziqiang.xia
 */
public class CustomStringStringConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
                                    GlobalConfiguration globalConfiguration) throws Exception {
        return "自定义："+cellData.getStringValue();
    }

    @Override
    public CellData convertToExcelData(String s, ExcelContentProperty excelContentProperty,
                                       GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(s);
    }
}
