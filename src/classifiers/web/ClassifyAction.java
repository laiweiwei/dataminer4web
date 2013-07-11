/**
 * 
 */
package classifiers.web;

import java.util.Map;

import javax.ws.rs.Path;

import org.eweb4j.mvc.MVC;
import org.eweb4j.mvc.action.annotation.Controller;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;
import weka.experiment.DatabaseUtils;
import weka.experiment.InstanceQuery;
import datasource.web.Datasource;

/**
 * @author Administrator
 *
 */
@Controller
@Path("")
public class ClassifyAction {
	
	@Path("/incrementalbayes/run")
	public String doget(Map<String,Object> model) throws Exception{
		  Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		  if(ds==null) ds=new Datasource("root","948738","weather_nominal");
		  
		  String m_DatabaseURL =new DatabaseUtils().getDatabaseURL();
		  DatabaseLoader loader=new DatabaseLoader();
		  loader.setSource(m_DatabaseURL, ds.getUsername(), ds.getPassword());
		  loader.setQuery("select * from "+ds.getTablename());
		  Instances structure = loader.getStructure();
	    structure.setClassIndex(structure.numAttributes() - 1);

	    // train NaiveBayes
	    NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
	    nb.buildClassifier(structure);
	    Instance current;
	    while ((current = loader.getNextInstance(structure)) != null)
	      nb.updateClassifier(current);

	    // output generated model
	    //System.out.println(nb);
	    model.put("run",nb.toString().replaceAll("\n", "<br>"));
	    return "forward:classifiers/view/run.jsp";
	    
	}
	
	@Path("/naivebayes/run")
	public String naivebayes(Map<String,Object> model) throws Throwable{
		Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		 if(ds==null) ds=new Datasource("root","948738","weather_nominal");
		InstanceQuery query = new InstanceQuery();
		query.setUsername(ds.getUsername());
		query.setPassword(ds.getPassword());
		query.setQuery("select * from "+ds.getTablename());
		// You can declare that your data set is sparse
		// query.setSparseData(true);
		Instances data = query.retrieveInstances();
		data.setClassIndex(data.numAttributes() - 1);

		//J48 tree = new J48();
		NaiveBayes tree = new NaiveBayes();
		// SMO tree = new SMO();

		tree.buildClassifier(data);
		String first = tree.toString();
		
		
		double index=tree.classifyInstance(data.instance(0));
		String attname = data.classAttribute().value((int) index);
		//System.out.println(attname);
		String run = "<p>建立分类树</p>"+first+"<hr>"+"<p>测试第一条记录的分类结果</p>"+index+":"+attname;
		model.put("run", run.replaceAll("\n", "<br>"));
		return "forward:classifiers/view/run.jsp";
	}
	
	@Path("/smo/run")
	public String smo(Map<String,Object> model) throws Throwable{
		Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		 if(ds==null) ds=new Datasource("root","948738","weather_nominal");
		InstanceQuery query = new InstanceQuery();
		query.setUsername(ds.getUsername());
		query.setPassword(ds.getPassword());
		query.setQuery("select * from "+ds.getTablename());
		// You can declare that your data set is sparse
		// query.setSparseData(true);
		Instances data = query.retrieveInstances();
		data.setClassIndex(data.numAttributes() - 1);

		//J48 tree = new J48();
		// NaiveBayes tree = new NaiveBayes();
		SMO tree = new SMO();

		tree.buildClassifier(data);
		String first = tree.toString();
		
		
		double index=tree.classifyInstance(data.instance(0));
		String attname = data.classAttribute().value((int) index);
		//System.out.println(attname);
		String run = "<p>建立分类树</p>"+first+"<hr>"+"<p>测试第一条记录的分类结果</p>"+index+":"+attname;
		model.put("run", run.replaceAll("\n", "<br>"));
		return "forward:classifiers/view/run.jsp";
	}
	
	@Path("/j48/run")
	public String j48(Map<String,Object> model) throws Throwable{
		Datasource ds =(Datasource)MVC.ctx().getSession().getAttribute("datasource");
		 if(ds==null) ds=new Datasource("root","948738","weather_nominal");
		InstanceQuery query = new InstanceQuery();
		query.setUsername(ds.getUsername());
		query.setPassword(ds.getPassword());
		query.setQuery("select * from "+ds.getTablename());
		// You can declare that your data set is sparse
		// query.setSparseData(true);
		Instances data = query.retrieveInstances();
		data.setClassIndex(data.numAttributes() - 1);

		J48 tree = new J48();
		// NaiveBayes tree = new NaiveBayes();
		// SMO tree = new SMO();

		tree.buildClassifier(data);
		String first = tree.toString();
		
		
		double index=tree.classifyInstance(data.instance(0));
		String attname = data.classAttribute().value((int) index);
		//System.out.println(attname);
		String run = "<p>建立分类树</p>"+first+"<hr>"+"<p>测试第一条记录的分类结果</p>"+index+":"+attname;
		model.put("run", run.replaceAll("\n", "<br>"));
		return "forward:classifiers/view/run.jsp";
	}
	

}
