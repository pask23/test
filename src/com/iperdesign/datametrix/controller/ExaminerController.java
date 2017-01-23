package com.iperdesign.datametrix.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.iperdesign.datametrix.bean.Examiner;
import com.iperdesign.datametrix.dal.ExaminerMockModel;  


@Path("/examiners")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExaminerController {
	private ExaminerMockModel mock = new ExaminerMockModel();
	
	
	@GET	
	public Response getExaminer(){
		List<Examiner> examiners = mock.getAllExaminers();
		if(examiners.size()>0)
			return Response.status(Status.OK).entity(examiners).build();
		return Response.status(Status.NOT_FOUND).entity(examiners).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getExaminerById(@PathParam("id") int id){
		Examiner examiner = mock.getExaminer(id);
		if(examiner!=null)
			return Response.status(Status.OK).entity(examiner).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	public Response addExaminer(Examiner examiner){
		Examiner new_examiner = mock.addExaminer(examiner);
		if(new_examiner!=null)
			return Response.status(Status.CREATED).entity(new_examiner).build();
		return Response.status(Status.CONFLICT).build();
	}
	
	@PUT
	public Response updateExaminer(Examiner examiner){
		Examiner updateExaminer =  mock.updateExaminer(examiner);
		if(updateExaminer != null)
			return Response.status(Status.OK).entity(updateExaminer).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteExaminer(@PathParam("id") int id){
		if(mock.deleteExaminer(id))
			 return Response.status(Status.NO_CONTENT).build();
		return Response.status(Status.NOT_FOUND).build();
		
	}
}
