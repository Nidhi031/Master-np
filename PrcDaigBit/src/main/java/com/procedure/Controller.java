package com.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.procedure.domain.Procedure;
import com.procedure.service.ConverterService;

@RestController
public class Controller {

	@Autowired
	ConverterService service;

	@RequestMapping("/procedure")
	public List<Procedure> getProcedureJson(@RequestParam(name = "excelPath") String excelPath) throws Exception {

		List<Procedure> listProcedure = service.getProcedureJson(excelPath);
		for (Procedure Procedure : listProcedure) {
			System.out.println("PCd : "+Procedure.getProcedureCd());
			System.out.println("PBt : "+Procedure.getProcedureBts());
		}
		return listProcedure;
	}
}


