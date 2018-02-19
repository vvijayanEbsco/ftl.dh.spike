package com.ebsco.ftl;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class MainProcess {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TemplateException {

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDirectoryForTemplateLoading(new File("C:\\EclipseWorkspaces\\DH_UI_transform_Workspace\\FTL\\src\\com\\ebsco\\resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        
        /* Create a data-model */
        Map root = new HashMap();
        root.put(
                "doc",
                freemarker.ext.dom.NodeModel.parse(new File("C:\\EclipseWorkspaces\\DH_UI_transform_Workspace\\FTL\\src\\com\\ebsco\\resources\\t918769.xml")));
        
		StringWriter out = new StringWriter();
		Template fmtemplate = cfg.getTemplate("test.ftl");
		try {
			fmtemplate.process(root, out);
		} finally {
		    out.close();
		}
		System.out.println(out.toString());
	}

}
