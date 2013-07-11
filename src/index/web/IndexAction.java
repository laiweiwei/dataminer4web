/**
 * 
 */
package index.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eweb4j.mvc.action.annotation.Controller;

/**
 * @author xiaoqitian
 *
 */
@Controller
public class IndexAction {

	@Path("")
	@GET
	public String doget(){
		return "forward:index/view/main.jsp";
	}
	@Path("/about")
	@GET
	public String about(){
		return "forward:index/view/about.jsp";
	}
	
}
