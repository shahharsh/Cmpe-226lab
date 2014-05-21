package edu.sjsu.cmpe226.lab.dto;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import edu.sjsu.cmpe226.lab.domain.Book;
import edu.sjsu.cmpe226.lab.domain.Cosmetics;
import edu.sjsu.cmpe226.lab.domain.Product;
import edu.sjsu.cmpe226.lab.domain.Homeappliance;
import edu.sjsu.cmpe226.lab.domain.Electronics;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class FreeMarker {
	private Template template;
	private Configuration cfg;

	public FreeMarker() {
		// TODO Auto-generated constructor stub

		/*
		 * 1. Configure FreeMarker
		 * 
		 * You should do this ONLY ONCE, when your application starts, then
		 * reuse the same Configuration object elsewhere.
		 */
		cfg = new Configuration();

		// Where do we load the templates from:
		cfg.setClassForTemplateLoading(FreeMarker.class, "templates");

		// Some other recommended settings:
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

	}

	public void setCategoryTemplate() {
		// Get the template to print all products of a category or home-page
		template = null;
		try {
			template = cfg.getTemplate("productcatalog.ftl");
			System.out.println("category template fetched...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while fetching category freemarker template");
		}
	}

	public void setElectronicProductTemplate() {
		// TODO Auto-generated method stub
		template = null;
		try {
			template = cfg.getTemplate("electroniccatalog.ftl");
			System.out.println("electronic product template fetched...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while fetching fashion product freemarker template");
		}
	}

	public void setHomeApplianceProductTemplate() {
		// TODO Auto-generated method stub
		template = null;
		try {
			template = cfg.getTemplate("homeappliancecatalog.ftl");
			System.out.println("home appliance product template fetched...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while fetching fashion product freemarker template");
		}
	}

	public void setFashionProductTemplate() {
		// TODO Auto-generated method stub
		template = null;
		try {
			template = cfg.getTemplate("cosmeticcatalog.ftl");
			System.out.println("cosmetics product template fetched...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while fetching fashion product freemarker template");
		}
	}

	public void setBookProductTemplate() {
		// TODO Auto-generated method stub
		template = null;
		try {
			template = cfg.getTemplate("bookcatalog.ftl");
			System.out.println("book template fetched...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while fetching fashion product freemarker template");
		}
	}

	public String writeHTMLOutput(List products) {
		
		Map<String, Object> input = new HashMap<String, Object>();
		
		input.put("itemslist", products);
		
		Writer out = new StringWriter();
		try {
			
			template.process(input, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Template processing exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException processing template");
		}
		if(products.isEmpty())
		{
			String search=out+ "Sorry!!! no reuslts found";
			return search;
		}
		return out.toString();
	}

	public String writeHTMLOutput(Cosmetics np) {
		// TODO Auto-generated method stub
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("product", np);
				Writer out = new StringWriter();
		try {
			template.process(input, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Template processing exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException processing template");
		}
		return out.toString();

	}

	public String writeHTMLOutput(Book b) {
		// TODO Auto-generated method stub
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("product", b);
		Writer out = new StringWriter();
		try {
			template.process(input, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Template processing exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException processing template");
		}
		
		return out.toString();
	}

	public String writeHTMLOutput(Electronics t) {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("product", t);
		Writer out = new StringWriter();
		try {
			template.process(input, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Template processing exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException processing template");
		}
		return out.toString();
	}

	public String writeHTMLOutput(Homeappliance r) {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("product", r);
		
		Writer out = new StringWriter();
		try {
			template.process(input, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Template processing exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException processing template");
		}
		
		return out.toString();
	}

}