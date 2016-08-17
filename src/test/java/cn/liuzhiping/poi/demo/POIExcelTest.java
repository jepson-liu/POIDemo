/**
 * Project Name:poi-demo
 * File Created at Aug 17, 2016
 *
*/

package cn.liuzhiping.poi.demo;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {add comment} <br/>
 * Date: Aug 17, 2016 <br/>
 * 
 * @author jepson.liu
 * @version 1.0
 * @since 1.0
 */
public class POIExcelTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}
	
	@Ignore
	@Test
	public void testCreateExcel() throws Throwable {
		Workbook xlsWb = new HSSFWorkbook();
		FileOutputStream xlsFos = new FileOutputStream("test.xls");
		xlsWb.write(xlsFos);
		xlsFos.close();
		xlsWb.close();
		Workbook xlsxWb = new XSSFWorkbook();
		FileOutputStream xlsxFos = new FileOutputStream("test.xlsx");
		xlsxWb.write(xlsxFos);
		xlsxFos.close();
		xlsxWb.close();

	}

	@Ignore
	@Test
	public void testCreateSheet() throws Throwable {
		Workbook wb = new XSSFWorkbook();
		wb.createSheet(WorkbookUtil.createSafeSheetName("[中文]"));
		wb.createSheet("new Sheet");
		FileOutputStream fos = new FileOutputStream("withSheet.xlsx");
		wb.write(fos);
		fos.close();
		wb.close();
	}
	//@Ignore
	@Test
	public void testCreateCells() {
		Workbook wb = null;
		FileOutputStream fos = null;
		try {
			wb = new XSSFWorkbook();
			CreationHelper createHelper = wb.getCreationHelper();
			fos = new FileOutputStream("cells" + Util.getCurrentDateStr() + ".xlsx");
			logger.debug("create cells ...");
			// test implements
			Sheet sheet = wb.createSheet();
			Row row = sheet.createRow(0);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue("new cell");

			Cell cell1 = row.createCell(1);
			cell1.setCellValue(new Date());
			CellStyle cellStytle = wb.createCellStyle();
			cellStytle.setDataFormat(createHelper.createDataFormat().getFormat("YYYY-MM-dd HH:mm:ss.SSS"));
			cell1.setCellStyle(cellStytle);
			wb.write(fos);
			fos.flush();
		} catch (Throwable t) {
			logger.error(t.getMessage(), t);
		} finally {
			Util.close(wb, fos);
		}
	}
}
