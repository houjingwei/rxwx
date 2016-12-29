package com.rxwx.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	// 判断excel版本
	static Workbook openWorkbook(InputStream in, String filename)
			throws IOException {
		Workbook wb = null;
		if (filename.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(in);// Excel 2007
		} else {
			wb = new HSSFWorkbook(in);// Excel 2003
		}
		return wb;
	}

	/**
	 * 表格导入，支技2003-2007版本excel
	 * @param file
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String[][] getExcelData(File file, String fileName) throws Exception 
	{
		InputStream in = new FileInputStream(file);
		Workbook wb = openWorkbook(in, fileName);
		
		Sheet sheet = (Sheet)wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		List<String[]> list = new ArrayList<String[]>();
		String[] values = new String[totalCells];
		Arrays.fill(values, "");
		
		String[][] result = new String[totalRows][totalCells];
		for(int r=0; r<totalRows; r++) 
		{
			row = sheet.getRow(r);
			for(int c = 0; c < totalCells; c++)
			{
				cell = row.getCell(c);
				String cellValue = "";
				if(null != cell){
					// 以下是判断数据的类型
					switch (cell.getCellType()) 
					{
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						cellValue = cell.getNumericCellValue() + "";
						//时间格式
						if(HSSFDateUtil.isCellDateFormatted(cell)){
							Date dd = cell.getDateCellValue();
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							cellValue = df.format(dd);
						}
						break;

					case HSSFCell.CELL_TYPE_STRING: // 字符串
						cellValue = cell.getStringCellValue();
						break;

					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = cell.getBooleanCellValue() + "";
						break;

					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						cellValue = cell.getCellFormula() + "";
						break;

					case HSSFCell.CELL_TYPE_BLANK: // 空值
						cellValue = "";
						break;

					case HSSFCell.CELL_TYPE_ERROR: // 故障
						cellValue = "非法字符";
						break;

					default:
						cellValue = "未知类型";
						break;
					}
				}
				values[c]=cellValue;
			}
			list.add(values);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = (String[]) list.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception
	{
		String fileName = "G:/111.xlsx";
		String[][] data = ExcelUtil.getExcelData(new File(fileName), fileName);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println(data[i][j]);
			}
		}
	}
	
	@SuppressWarnings({ "deprecation", "null" })
	public void aa (HttpServletRequest request,HttpServletResponse response){
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet("Sheet1");
		sheet.setDefaultRowHeightInPoints(5000);

		sheet.setColumnWidth((short) 0, (short) 4000);
		sheet.setColumnWidth((short) 1, (short) 4000);
		sheet.setColumnWidth((short) 2, (short) 4000);
		
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		//字体加粗样式
		HSSFCellStyle fontWeightStyle = wb.createCellStyle();
		fontWeightStyle.setFont(font);
		fontWeightStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		fontWeightStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		// 创建表头
		HSSFRow row = sheet.createRow((int) 0);
		
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ID");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 1);
		cell.setCellValue("设备SN");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 1);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		List<?> list = null;
		
		for (int i = 0; i < list.size(); i++) {
			// 创建一行
			row = sheet.createRow((int) i + 1);
			// 设值
			row.createCell((short) 0).setCellValue("");
			row.createCell((short) 1).setCellValue("");
			row.createCell((short) 2).setCellValue("");
		}
		
		try {
			DownLoadUtil.excelDownLoad("text.xlsx", wb, request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
