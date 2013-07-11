/**
 * 
 */
package clusterers.web;

import java.util.Map;

import javax.ws.rs.Path;

import org.eweb4j.mvc.MVC;
import org.eweb4j.mvc.action.annotation.Controller;

import weka.clusterers.SimpleKMeans;
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
public class ClusterersAction {
	
	
	@Path("/kmeans/run")
	public String naivebayes(Map<String,Object> model) throws Throwable{
		Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		 String[] options = (String[])MVC.ctx().getSession().getAttribute("clusterers_para");
		 if(ds==null) ds=new Datasource("root","948738","weather_nominal");
		InstanceQuery query = new InstanceQuery();
		query.setUsername(ds.getUsername());
		query.setPassword(ds.getPassword());
		query.setQuery("select * from "+ds.getTablename());
		// You can declare that your data set is sparse
		// query.setSparseData(true);
		  Instances data = query.retrieveInstances();
		    //data.setClassIndex(data.numAttributes() - 1);
			
		    SimpleKMeans clusterer = new SimpleKMeans();
		    if(options!=null && options.length!=0) clusterer.setOptions(options);
		    // set further options for EM, if necessary...
		    clusterer.buildClusterer(data);
		    Instances tempIns = clusterer.getClusterCentroids();

	        //System.out.println("CentroIds: " + tempIns);
		    String tempins= "<p>CentroIds</p>"+tempIns;


		    //System.out.println(clusterer);
		    String run=tempins+"<hr>"+clusterer.toString();
		
		
	
		model.put("run", run.replaceAll("\n", "<br>"));
		return "forward:clusterers/view/run.jsp";
	}
	
	@Path("/kmeans/para")
	public String dopara(){
		return "forward:clusterers/view/paraform.jsp";
	}
	@Path("/kmeans/paraform")
	public String doparaform(String para) throws Exception{
		if(para!=null) {
		String[] options = weka.core.Utils.splitOptions(para);
		MVC.ctx().getSession().setAttribute("clusterers_para", options);
		}else{
			MVC.ctx().getSession().setAttribute("clusterers_para", null);
		}
		return new CallBackJson("setting successful","200").toString();
	}
	

}
