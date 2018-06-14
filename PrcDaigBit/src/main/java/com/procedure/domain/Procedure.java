package com.procedure.domain;

public class Procedure{

	String ProcedureCd;
	String[] ProcedureBts;

	public Procedure() {

	}

	public Procedure(String procedureCd, String[] procedureBts) {
		super();
		ProcedureCd = procedureCd;
		ProcedureBts = procedureBts;
	}

	public String getProcedureCd() {
		return ProcedureCd;
	}
	public void setProcedureCd(String procedureCd) {
		this.ProcedureCd = procedureCd;
	}
	public String[] getProcedureBts() {
		return ProcedureBts;
	}
	public void setProcedureBts(String[] bits) {
		this.ProcedureBts = bits;
	}
}
