package rtest;
import org.rosuda.REngine.Rserve.RConnection;
public class RCharts {
	public String returnRChart(String value)  {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(rCharts)");
			r.eval("product<-data.frame(apple=c(" + value + "))");
			r.eval("gg<-nPlot(~apple, data=product, type='pieChart', width='400', height='300')");
			r.eval(" out<- capture.output(gg$show('inline'));");
			r.eval("str <- ''");
			r.eval(" for(i in 1:length(out)){ str<-paste(str, out[i], '\n'); }");
			return r.eval("str").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}
}
