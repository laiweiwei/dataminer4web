/**
 * 
 */
package associations.web;

import java.util.Map;

import javax.ws.rs.Path;

import org.eweb4j.mvc.MVC;
import org.eweb4j.mvc.action.annotation.Controller;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.experiment.InstanceQuery;
import datasource.web.Datasource;
import dwzcons.CallBackJson;

/**
 * @author Administrator
 *
 */
@Controller
@Path("")
public class AssociationAction {
	//the source code mainly from http://weka.wikispaces.com/Use+WEKA+in+your+Java+code
	
	@Path("/associations/run")
	public String doget(Map<String,Object> model) throws Exception{
		  Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		  String[] options = (String[])MVC.ctx().getSession().getAttribute("associations_para");
		  //the code below just for debug,you can use your own username and password,tablename
		  if(ds==null) ds=new Datasource("root","948738","weather_nominal"); 
		  InstanceQuery query = new InstanceQuery();
		  query.setUsername(ds.getUsername());
		  query.setPassword(ds.getPassword());
		  query.setQuery("select * from "+ds.getTablename());
		  // You can declare that your data set is sparse
		  // query.setSparseData(true);
		Instances data = query.retrieveInstances();
	    data.setClassIndex(data.numAttributes() - 1);

	    // build associator
	    Apriori apriori = new Apriori();
	    if(options!=null && options.length!=0) apriori.setOptions(options);
	    apriori.setClassIndex(data.classIndex());
	    apriori.buildAssociations(data);

	    // output associator
	    //System.out.println(apriori);
	    String run = apriori.toString().replaceAll("\n", "<br>");
	    model.put("run",run);
	    //System.out.println(run);
	    return "forward:associations/view/run.jsp";
	    
	}
	
	
	@Path("/associations/para")
	//sorry that i have not complete the para function,you can build your own code 
	public String dopara(String para) throws Exception{
		//String[] options = weka.core.Utils.splitOptions(para);
		
		return "forward:associations/view/paraform.jsp";
	}
	@Path("/associations/paraform")
	public String doparaform(String para) throws Exception{
		if(para!=null) {
		String[] options = weka.core.Utils.splitOptions(para);
		MVC.ctx().getSession().setAttribute("associations_para", options);
		}else{
			MVC.ctx().getSession().setAttribute("associations_para", null);
		}
		return new CallBackJson("setting successful","200").toString();
	}

}
