package com.procedure.service;

import java.util.List;

import com.procedure.domain.Procedure;


public interface ConverterService {

	public List<Procedure> getProcedureJson(String excelPath) throws Exception;
}
