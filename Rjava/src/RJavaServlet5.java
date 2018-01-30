import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rtest.RCharts;
import rtest.WordCloud2;

@WebServlet("/rjava5")
public class RJavaServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");		
		if(action.equals("rcharts")) {
			RCharts rc = new RCharts();
			String data = request.getParameter("data");
			request.setAttribute("content", rc.returnRChart(data));
		} else if(action.equals("wc2")) {
			WordCloud2 wc = new WordCloud2();
			request.setAttribute("content", wc.returnWC2());
		} 
		request.getRequestDispatcher("/dynamicvisual.jsp").forward(request, response);
	}

}
