package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean
{
   private int id;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public DeleteCandidateBean(int id) {
		super();
		this.id = id;
	}
	
	public DeleteCandidateBean() {
		super();
	}
   public void deletCandidate()
   {
	   try {
		CandidateDao cd=new CandidateDaoImpl();
		cd.deleteById(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
}
