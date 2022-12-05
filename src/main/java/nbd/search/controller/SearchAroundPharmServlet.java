package nbd.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import nbd.search.model.service.SearchService;
import nbd.search.model.vo.Search;

/**
 * Servlet implementation class SearchAroundPharmServlet
 */
@WebServlet(name = "SearchAroundPharm", urlPatterns = { "/searchAroundPharm.do" })
public class SearchAroundPharmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAroundPharmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 2.값추출
		String searchRoad = request.getParameter("addr");
		System.out.println(searchRoad);
		// 3.비즈니스로직
		SearchService service = new SearchService();
		ArrayList<Search> list = service.searchRoad(searchRoad);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		new Gson().toJson(list,out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
