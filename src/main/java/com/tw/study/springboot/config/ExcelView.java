package com.tw.study.springboot.config;

import com.tw.study.springboot.entity.Excel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * Created by hwwei on 2016/11/16.
 */
public class ExcelView extends AbstractXlsView {

    static final String KEY_EXCEL_DATA = "KEY_EXCEL_DATA";

    public static final ModelAndView newModelAndView(Object data) {
        ModelAndView modelAndView = new ModelAndView(INSTANCE);
        modelAndView.addObject(KEY_EXCEL_DATA, data);
        return modelAndView;
    }

    private static ExcelView INSTANCE = new ExcelView();

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      org.apache.poi.ss.usermodel.Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {


        Object data = model.get(KEY_EXCEL_DATA);
        if (!(data instanceof Collection)) {
            throw new IllegalArgumentException("类型不匹配");
        }
        Collection<?> list = (Collection<?>) data;

        // 行下标
        int rowIndex = 0;

        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(rowIndex++);
        Cell nameCell = row.createCell(0);
        nameCell.setCellValue("名字");
        Cell ageCell = row.createCell(1);
        ageCell.setCellValue("年龄");
        Cell oldCell = row.createCell(2);
        oldCell.setCellValue("老么");

        for (Object o : list) {
            Excel item = (Excel) o;
            Row itemRow = sheet.createRow(rowIndex++);

            nameCell = itemRow.createCell(0);
            nameCell.setCellValue(item.name);

            ageCell = itemRow.createCell(1);
            ageCell.setCellValue(item.age);

            oldCell = itemRow.createCell(2);
            oldCell.setCellValue(item.old);
        }

        response.setHeader("Content-Disposition", "attachment; filename= data");
    }
}
