package edu.sjsu.cmpe226.lab.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe226.lab.dto.MongoDao;

@Path("/catalog")
public class UserResource {

	private MongoDao mongoDao = new MongoDao();
	
	
	@GET
	@Path("/apachetest")
	public Response responseMsg( ) {
		
		String output = "Hello World!";
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/search/{searchtext}")
	@Produces("text/html")
	public Response searchitem(@PathParam("searchtext") String searchtext ) {
		System.out.println("the search string is"+searchtext);
		return Response.status(200).entity(mongoDao.getsearch(searchtext)).build();
	}
	@GET
	@Path("/productscatalog")
	@Produces("text/html")
	public Response getProducts(){
		return Response.status(200).entity(mongoDao.getProducts()).build();
	}
	
	@GET
	@Path("/electronicscatalog")
	@Produces("text/html")
	public Response getElectronics(){
		return Response.status(200).entity(mongoDao.getElectronicsProducts()).build();
	}
	
	@GET
	@Path("/homeappliancescatalog")
	@Produces("text/html")
	public Response getHomeAppliances(){
		return Response.status(200).entity(mongoDao.getHomeAppliancesProducts()).build();
	}
	
	@GET
	@Path("/cosmeticscatalog")
	@Produces("text/html")
	public Response getFashion(){
		return Response.status(200).entity(mongoDao.getFashionProducts()).build();
	}
	
	@GET
	@Path("/bookscatalog")
	@Produces("text/html")
	public Response getBooks(){
		return Response.status(200).entity(mongoDao.getBooksProducts()).build();
	}
	
	@GET
	@Path("/productcatalog/{product_id}")
	@Produces("text/html")
	public Response getProduct(@PathParam("product_id") String product_id){
	return Response.status(200).entity(mongoDao.getProduct(product_id)).build();
	}
}