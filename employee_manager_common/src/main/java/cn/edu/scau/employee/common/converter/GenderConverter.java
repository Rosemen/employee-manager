package cn.edu.scau.employee.common.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * 性别转换工具
 *
 * @author chen.jiale
 * @date 2019/11/16 17:08
 */
public class GenderConverter implements Converter<Integer> {

    private static final String MALE = "男";

    private static final String FEMALE = "女";

    private static final int MALE_CODE = 1;

    private static final int FEMALE_CODE = 2;

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
        String stringValue = cellData.getStringValue();
        if (MALE.equals(stringValue)){
            return MALE_CODE;
        }else {
            return FEMALE_CODE;
        }
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (integer == MALE_CODE){
            return new CellData(MALE);
        }else {
            return new CellData(FEMALE);
        }
    }
}
