package rtest;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

public class GoogleVIS {
	public String returnGVIS() {
		RConnection r = null;
		String retStr = "";
		REXP x = null;
		try {
			r = new RConnection();
			r.eval("library(googleVis)");
			r.eval("fruits=data.frame(month=c('JAN','FEB','MAR'),apple=c(30,10,20),orange=c(20,40,30))");
			r.eval("a<-gvisLineChart(fruits)");
			x = r.eval("paste(a$html$chart, a$hmtl$caption, a$html$footer)");
			// x = c.eval("paste(a$html$chart,a$html$caption )");	
			retStr = x.asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
}
