/**
 * 
 */
package datasource.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eweb4j.mvc.MVC;
import org.eweb4j.mvc.action.annotation.Controller;

import dwzcons.CallBackJson;


/**
 * @author Administrator
 *
 */
@Controller
@Path("")
public class DatasourceAction {

	/**
	 * @param args
	 */
@Path("datasource")
public String datasource(){
	return "forward:datasource/view/datasourceform.jsp";
      }
@Path("datasourceform")
@POST
public String datasourceform(){
	String username = MVC.ctx().getRequest().getParameter("username");
	String password = MVC.ctx().getRequest().getParameter("password");
	String tablename = MVC.ctx().getRequest().getParameter("tablename");
	Datasource ds = new Datasource(username,password,tablename);
	MVC.ctx().getRequest().getSession().setAttribute("datasource", ds);
	return new CallBackJson("设置成功","").toString();
}

}
