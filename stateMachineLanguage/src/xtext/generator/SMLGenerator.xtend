/*
 * generated by Xtext 2.25.0
 */
package xtext.generator

import models.ArchiSkel
import models.BatchNormalisation
import models.Convolution
import models.Dense
import models.Dropout
import models.MergeSimple
import models.Pooling
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import utils.FonctionStringPy
import utils.GestionHpp
import utils.GestionWay
import xtext.sML.Architecture
import xtext.sML.Classification
import xtext.sML.FeatureExtraction
import xtext.sML.Interstice
import xtext.sML.Left
import xtext.sML.Merge
import xtext.sML.MergeBody
import xtext.sML.Right
import xtext.sML.SML
import java.io.PrintWriter

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class SMLGenerator extends AbstractGenerator {

	var fsp = new FonctionStringPy()
	
	var gestionWay = GestionWay.gestionWay;
	
	var archiskel = ArchiSkel.archiSkel
		
	// python directory
    var py_dir = "architecture_py/"
    
    // log directory
    var log_dir = "../architecture_log/"
    
    // png directory
    var png_dir = "../architecture_img/"
    
	var file_name = ""
    
	// entry for ui
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		gestionWay = GestionWay.gestionWay
		GestionHpp.destroy
		println(resource.URI)
		file_name = "architecture"
		for(elem : resource.allContents.toIterable.filter(Architecture)){
			fsa.generateFile(py_dir + file_name + '.py', elem.compile())
		}
	}
	
	// entry for generator
	def void generate(SML sml, String filename) {
		gestionWay = GestionWay.gestionWay
		GestionHpp.destroy
		file_name = filename.split("/").get(2).split('.py').get(0)
		
		//println("smlgenerator:  " + sml.sml)
		var archi = compile(sml.sml)
		//println(archi)
		
		var writer = new PrintWriter(filename, "UTF-8");
		writer.println(archi);
		writer.close();
	}
	
	
	private def compile(Architecture archi ){
		archiskel.createSkel(archi)

		
		var py_file = ""
		
		// write import
		py_file += fsp.strImport()
		
		// write dataset 
		py_file += fsp.writeMnistDataSet()
		
		// write init value 
		py_file += fsp.writeInitValue()
		
		//println(archi)
		
		// try	
    	py_file += "try:\n"
		
		py_file += gestionArchi(archi)
		
		py_file += fsp.writeTrain()
		
		py_file += fsp.gestionGood(log_dir, file_name)
		
		py_file += fsp.gestionError(log_dir, file_name)
		
		py_file += fsp.gestionFinally(file_name)
		
		
		return py_file
		
	}
	
	private def gestionArchi(Architecture a){
		var str_archi = "\tdef getModel():\n"
		
		// verify input not missing
		if (!a.input.empty){
			str_archi += fsp.writeInput("[28, 28, 1]", gestionWay.current)
		}else{
			throw new Exception("missing Input")
		}
		
		// verify feature extraction not missing
		if (!a.fe.empty){
			str_archi += gestionFE(a.fe)
			//println(a.fe)

		}else{
			throw new Exception("missing feature extra")
		}

		
		if (a.inter !== null && a.class_ !== null){
			str_archi += gestionInter(a.inter)
			str_archi += gestionDense(a.class_)
		}
		
		
		if(!a.output.empty){
			str_archi += String.format("\t\tmodel = Model(inputs=X_input, outputs=%s)\n", gestionWay.current)
			str_archi += "\t\treturn model\n\n"
			str_archi += "\tmodel = getModel()\n"
			
			// write : create png of the model
    		str_archi += String.format("\tplot_model(model, show_shapes=True, to_file=\"%s\")\n", 
    			png_dir+file_name+".png"
    		)
    		// write compiler
    		str_archi += "\tmodel.compile(optimizer='adam', loss=keras.losses.sparse_categorical_crossentropy, metrics=['accuracy'])\n\n"
    		
		}else{
			throw new Exception("missing output")
		}
		
		return str_archi
	}
	
	def gestionFE(EList<FeatureExtraction> list) {
		var fe_string = ""
		for (elem: list){
			if (elem.conv !== null){
				fe_string += gestionConv(elem.conv, gestionWay.current)

			}else if (elem.merge !== null){
				var MergeSimple ms = null
				fe_string += gestionMerge(elem.merge, ms, true)
				ms = null
			}else {
				throw new Exception("gestionFe errors")
			}
			
			if (elem.drop !== null)
				fe_string += unitDropout(gestionWay.current)
			if (elem.pool !== null)
				fe_string += unitPooling(elem.pool, gestionWay.current)
		}
		return	fe_string
	}
	
	
	def gestionConv(xtext.sML.Convolution conv, String x_or_shortcut) {
		if( conv.bnconv !== null)
			return unitBnConv(x_or_shortcut)
		else if (conv.convbn !== null)
			return unitConvBn(x_or_shortcut)
		else if (conv.conv !== null)
			return unitConv(x_or_shortcut)
		else return unitUpConv(x_or_shortcut)
	}
	
	def gestionConv(xtext.sML.Convolution conv, String x_or_shortcut, Convolution hppConv) {
		if( conv.bnconv !== null)
			return unitBnConv(x_or_shortcut, hppConv)
		else if (conv.convbn !== null)
			return unitConvBn(x_or_shortcut, hppConv)
		else if (conv.conv !== null)
			return unitConv(x_or_shortcut, hppConv)
		else return unitUpConv(x_or_shortcut)
	}
	
	def gestionMerge(Merge merge, MergeSimple mergeSimple, boolean isRecu) {
		var str_merge = ""
		var ms = mergeSimple
		
		if(merge.mergeBody.size <= 1){
			if(ms === null){
				ms = new MergeSimple(merge)
			}
			
			str_merge += gestionMergeBody(merge.mergeBody.get(0), ms, isRecu)
		}else {
			if(ms === null){
				ms = new MergeSimple(merge.mergeBody)
			}
			str_merge += gestionHighway(merge.mergeBody, ms, isRecu)
		}
		
		return str_merge
	}
	
	def gestionHighway(EList<MergeBody> listMerge, MergeSimple merge, boolean isRecu) {
		var str_highway = ""
		
		//init merge
		gestionWay.add
		str_highway += fsp.writeInitMerge(gestionWay.current, gestionWay.next)
		
		for (mb: listMerge){	
			// body merge (i.e Left & Right)
			str_highway += gestionLeft(mb.left, merge, false)
			str_highway += '\n'
			str_highway += gestionRight(mb.right, merge, false)
			
			// end merge (i.e Add/Concatenate)
			if (merge.add_or_concat == 'concat'){
				str_highway += fsp.writeConcat(gestionWay.current, gestionWay.next)
			}else{
				str_highway += fsp.writeAdd(gestionWay.current, gestionWay.next)
			}
			
		}
		gestionWay.removeLastFromList
		
		return str_highway
	}
	
	def gestionMergeBody(MergeBody mb, MergeSimple merge, boolean isRecu) {
		var strMergeBody = ""
	
		//init merge
		gestionWay.add
		strMergeBody += fsp.writeInitMerge(gestionWay.current, gestionWay.next)
		
		// body merge (i.e Left & Right)
		strMergeBody += gestionLeft(mb.left, merge, isRecu)
		strMergeBody += '\n'
		strMergeBody += gestionRight(mb.right, merge, isRecu)
		
		// end merge (i.e Add/Concatenate)
		if (merge.add_or_concat == 'concat'){
			strMergeBody += fsp.writeConcat(gestionWay.current, gestionWay.next)
		}else{
			strMergeBody += fsp.writeAdd(gestionWay.current, gestionWay.next)
		}
		gestionWay.removeLastFromList
		
		return strMergeBody
	}
	
	def gestionLeft(Left left, MergeSimple merge, boolean isRecu) {
		var strLeft = ""
		if (left.p !== null){
			if(isRecu) strLeft += unitPooling(left.p, gestionWay.next, merge.left.get(0) as Pooling)
			else strLeft += unitPooling(left.p, gestionWay.current, merge.left.get(0) as Pooling)
			merge.removeFirstLeft
		}
		
		if (left.com.convdrop !== null){
			for (convdrop: left.com.convdrop){
				if(isRecu) strLeft += gestionConv(convdrop.conv, gestionWay.next, merge.left.get(0) as Convolution)
				else strLeft += gestionConv(convdrop.conv, gestionWay.current, merge.left.get(0) as Convolution)
				merge.removeFirstLeft
				if(convdrop.drop !== null){
					if(isRecu) strLeft += unitDropout(gestionWay.next)
					else strLeft += unitDropout(gestionWay.current)
				}
			}
		}
		
		if(left.com.mergeConv !== null){
			
			for(mc : left.com.mergeConv){
				
				strLeft += gestionMerge(mc.merge, merge, true)
				
				if (mc.convdrop !== null){
					for (convdrop: mc.convdrop){
						if(isRecu) strLeft += gestionConv(convdrop.conv, gestionWay.next, merge.left.get(0) as Convolution)
						else strLeft += gestionConv(convdrop.conv, gestionWay.current, merge.left.get(0) as Convolution)
						merge.removeFirstLeft
						if(convdrop.drop !== null)
							if(isRecu)strLeft += unitDropout(gestionWay.next)
							else strLeft += unitDropout(gestionWay.current)
						}
				}
			}
		}
		
		if (left.pool !== null){
			if(isRecu) strLeft += unitPooling(left.pool, gestionWay.next, merge.left.get(0) as Pooling)
			else strLeft += unitPooling(left.pool, gestionWay.current, merge.left.get(0) as Pooling)
			merge.removeFirstLeft
		}
		
		return strLeft
	}
	
	def gestionRight(Right right, MergeSimple merge, boolean isRecu) {
		var strRight = ""
		
		if(right.conv !== null){
			for (conv: right.conv){
				if (isRecu)
					strRight += gestionConv(conv, gestionWay.current, merge.right.get(0) as Convolution)
				else strRight += gestionConv(conv, gestionWay.next, merge.right.get(0) as Convolution)
				merge.removeFirstRight
			}
		}
		
		return strRight
	}
	
	
	def gestionInter(Interstice inter) {
		var string_inter = ""
		
		if (inter.fg.flat !== null){
			string_inter += unitFlatten(gestionWay.current)
		}else{
			string_inter += unitGlobalPooling(inter.fg.gp, gestionWay.current)
		}
			
		return string_inter
	}
	
	def gestionDense(EList<Classification> list) {
		var strDense = ""
		var i = 0; 
		while (i<list.size()-1){
			if(list.get(i).drop !== null)
				strDense += unitDropout(gestionWay.current)
			strDense += unitDense(gestionWay.current, false)
			i++;
		}
		
		if(list.get(i).drop !== null)
				strDense += unitDropout(gestionWay.current)
		strDense += unitDense(gestionWay.current, true);
		
		return strDense
	}
	

	
	// ===== Units =====
	
	def unitConv(String X_or_shortcut){
		var Convolution conv = new Convolution
		conv.hyperparameters
		return fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut)
	}
	
	def unitConv(String X_or_shortcut, Convolution conv){
		return fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut)
	}
	
	def unitUpConv(String X_or_shortcut){
		return fsp.writeUpconv(X_or_shortcut, 2)
	}
	
	def unitBnConv(String X_or_shortcut){
		var BatchNormalisation bn = new BatchNormalisation
		bn.hyperparameters
		
		var Convolution conv = new Convolution
		conv.hyperparameters
		
		return fsp.writeBN(bn.epsilon, X_or_shortcut) + fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut)
	}
	
	def unitBnConv(String X_or_shortcut, Convolution conv){
		var BatchNormalisation bn = new BatchNormalisation
		bn.hyperparameters
		
		return fsp.writeBN(bn.epsilon, X_or_shortcut) + fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut)
	}
	
	def unitConvBn(String X_or_shortcut){
		var BatchNormalisation bn = new BatchNormalisation
		bn.hyperparameters
		
		var Convolution conv = new Convolution
		conv.hyperparameters
		
		return fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut) + fsp.writeBN(bn.epsilon, X_or_shortcut)
	}
	
	def unitConvBn(String X_or_shortcut, Convolution conv){
		var BatchNormalisation bn = new BatchNormalisation
		bn.hyperparameters
		
		return fsp.writeConv(conv.nbFilter, conv.kernel, conv.stride , conv.fct_activation, conv.padding, X_or_shortcut) + fsp.writeBN(bn.epsilon, X_or_shortcut)
	}
	
	def unitPooling(String pool, String X_or_shortcut){
		var Pooling p = new Pooling
		p.hyperparameters
		if(pool == "avg_pooling"){
			return fsp.writeAvgPooling(p.kernel,p.stride,p.padding, X_or_shortcut)
		}else{
			return fsp.writeMaxPooling(p.kernel,p.stride,p.padding, X_or_shortcut)
		}
	}
	
		def unitPooling(String pool, String X_or_shortcut, Pooling p){
		if(pool == "avg_pooling"){
			return fsp.writeAvgPooling(p.kernel,p.stride,p.padding, X_or_shortcut)
		}else{
			return fsp.writeMaxPooling(p.kernel,p.stride,p.padding, X_or_shortcut)
		}
	}
	
	def unitDropout(String X_or_shortcut){
		var Dropout dropout = new Dropout
		dropout.hyperparameters
		return fsp.writeDropout(dropout.dropoutRate, X_or_shortcut)
	}
	
	def unitDense(String X_or_shortcut, boolean last){
		var Dense dense = new Dense(last)
		dense.hyperparameters
		return fsp.writeDense(dense.units,dense.fctActivation, X_or_shortcut)
	}
	
	def unitFlatten(String X_or_shortcut){
		return fsp.writeFlatten(X_or_shortcut)
	}
	
	def unitGlobalPooling(String elem, String X_or_shortcut){
		if(elem == "global_avg_pooling"){
			return fsp.writeGloAvgPooling(X_or_shortcut)	
		}else {
			return fsp.writeGloMaxPooling(X_or_shortcut)
		}
	}
		
	
}