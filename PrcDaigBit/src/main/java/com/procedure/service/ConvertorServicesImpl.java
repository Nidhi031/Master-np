package com.procedure.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import com.procedure.domain.Procedure;

@Service
public class ConvertorServicesImpl implements ConverterService {

	List<Procedure> listProcedure = new ArrayList<>();
	@Override
	public List<Procedure> getProcedureJson(String excelPath) throws IOException {

		FileInputStream excelSheet = new FileInputStream(excelPath);
		Workbook wb = new XSSFWorkbook(excelSheet);
		Sheet s = wb.getSheetAt(0);

		/*for(i=1 ; i<= s.getLastRowNum() ; i++){
			System.out.println();
			Procedure procedure = new Procedure();
			row = s.getRow(i);
			procedure.setProcedureCd(row.getCell(0).getStringCellValue());
			procedure.setProcedureBts(row.getCell(1).getStringCellValue());
			listProcedure.add(procedure);
		}
		return listProcedure;	
	}*/
		List<Row> listRow = IteratorUtils.toList(s.iterator());

		listRow.stream().skip(1).
		forEach(Row ->{
			Procedure procedure = new Procedure();
			procedure.setProcedureCd(Row.getCell(0).getStringCellValue());
			String[] bits = Row.getCell(1).getStringCellValue().split(",");
			procedure.setProcedureBts(bits);
			listProcedure.add(procedure);
		});
		return listProcedure;	
		
	}
}
