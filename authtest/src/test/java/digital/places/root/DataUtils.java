package digital.places.root;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtils
{
	private static final String testDataFileName = "digital/places/root/test.xlsx";
	private static final String validPagesSheet = "nlivalid";
	private static final String invalidPagesSheet = "nli404";

	public List<Page> loadValidURLs()
	{
		return loadTestData(testDataFileName,validPagesSheet);
	}
	
	public List<Page> loadInvalidURLs()
	{
		return loadTestData(testDataFileName,invalidPagesSheet);
	}
	
	private List<Page> loadTestData(String testFileName,String xlSheetName)
	{
		List<Page> webpages = new ArrayList<Page>();
		try {
		
			InputStream file = this.getClass().getClassLoader().getResourceAsStream(testFileName);
			
			Workbook workbook = new XSSFWorkbook(file);

			Sheet sheet = workbook.getSheet(xlSheetName);
			
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Page webpage = new Page();
				Row row = rowIterator.next();

				Cell url = row.getCell(0);
				if (url != null && StringUtils.isNotEmpty(url.getStringCellValue()))
				{
					webpage.setUrl(url.getStringCellValue());
				}
				
				Cell title = row.getCell(1);
				if (title != null && StringUtils.isNotEmpty(title.getStringCellValue()))
				{
					webpage.setTitle(title.getStringCellValue());
				}
				
				Cell metaDesc = row.getCell(2);
				if (metaDesc != null && StringUtils.isNotEmpty(metaDesc.getStringCellValue()))
				{
					webpage.setMetaDescription(metaDesc.getStringCellValue());
				}
				
				Cell login = row.getCell(3);
				if (login != null && StringUtils.isNotEmpty(login.getStringCellValue()))
				{
					webpage.setLoginId(login.getStringCellValue());

					Cell password = row.getCell(4);
					if (password != null && StringUtils.isNotEmpty(password.getStringCellValue()))
					{
						webpage.setPassword(password.getStringCellValue());
					}
					else
					{
						webpage.setLoginId(null);
					}
				}
				
				
				webpages.add(webpage);
			}
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return webpages;
	}
	
}
