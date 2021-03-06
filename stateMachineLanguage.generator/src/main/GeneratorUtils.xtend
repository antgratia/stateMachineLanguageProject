package main

import java.util.ArrayList
import java.util.List
import java.util.Random
import xtext.generator.SMLGenerator
import xtext.sML.Architecture
import xtext.sML.FeatureExtraction
import xtext.sML.Merge
import xtext.sML.SML
import xtext.sML.impl.SMLFactoryImpl
import xtext.sML.Convolution

class GeneratorUtils {
		var SMLFactoryImpl factory = new SMLFactoryImpl()
		
		var SMLGenerator smlGenerator = new SMLGenerator()
		
		var strAchitectureSimplify = ""
		
		static Random rand = new Random();
		
			
		static List<String> flatOrGLo = new ArrayList<String>(List.of("flatten", "global_avg_pooling", "global_max_pooling"));
		static List<String> poolOrNot = new ArrayList<String>(List.of("", "avg_pooling", "max_pooling"));
		static List<String> dropOrNot = new ArrayList<String>(List.of("", "", "", "", "dropout"));
		static List<String> convs = new ArrayList<String>(List.of("conv", "convbn", "bnconv"));
		static List<String> convOrMerge = new ArrayList<String>(List.of("conv", "conv", "merge"));
		static List<String> convOrEmpty = new ArrayList<String>(List.of("conv", "Empty"));
		
		static List<Integer> nbFeatureExtraction = new ArrayList<Integer>(List.of(3,4,5))
		static List<Integer> nbDense = new ArrayList<Integer>(List.of(1,2,3))
		static List<Integer> nbOtherZero = new ArrayList<Integer>(List.of(0,1,2))
		static List<Integer> nbOther = new ArrayList<Integer>(List.of(1,2))
		
		
		def generate(String filename, String expDir, String DBName){
		
			
			// init sentence
			var SML sml = factory.createSML()
			
			
			// creation architecture 
			var Architecture archi = factory.createArchitecture()
			archi.input = "input"
			archi.output = "output"
			sml.sml = archi
			
			
			// feature extration
			var nbfe = nbFeatureExtraction.get(rand.nextInt(nbFeatureExtraction.size()));
			for (var i=0; i<nbfe; i++){
				archi.fe.add(featureExtractionManagement)
			}
			
			// Interstice
			archi.inter = IntersticeManagement
			
			// classification
			var nbCla = nbDense.get(rand.nextInt(nbDense.size())); 
			for (var j=0; j<nbCla; j++){
				archi.class_.add(classificationManagement)
				
			} 
			
			//var SML sml = test
			
			
			// generate python file
			var strStride = smlGenerator.generate(sml, filename, expDir, DBName);
			
			var strReturnList = new ArrayList<String>()
			strReturnList.add(strAchitectureSimplify)
			strReturnList.add(strStride)
			
			return strReturnList
		}
		
		def test(){
			var SML sml = factory.createSML()
			
			var Architecture archi = factory.createArchitecture()
			archi.input = "input"
			archi.output = "output"
			sml.sml = archi
			
			var FeatureExtraction fe = factory.createFeatureExtraction()
			fe.conv = factory.createConvolution
			fe.conv.bnconv = "bnconv"
			
			var FeatureExtraction fe1 = factory.createFeatureExtraction()
			fe1.drop = "drop"
			
			archi.fe.add(fe)
			archi.fe.add(fe1)
			
			
			
			return sml
		}
		
		def featureExtractionManagement(){
			
			var FeatureExtraction fe = factory.createFeatureExtraction()
				
			var strConvOrMerge = convOrMerge.get(rand.nextInt(convOrMerge.size()))
			if(strConvOrMerge == "conv"){
				// === CONV
				fe.conv = convManagement
			}else{
				// === MERGE
				fe.merge = mergeManagement(false)
			}
			
			
			// === DROPOUT
			var strDropOrNot = dropOrNot.get(rand.nextInt(dropOrNot.size()));
			
			
			if(strDropOrNot === ""){
				// do nothing
			} else{
				fe.drop = strDropOrNot
				strAchitectureSimplify += "dropout "
			}
			
			
			// === POOL	
			var strPoolOrNot = poolOrNot.get(rand.nextInt(poolOrNot.size()));
			
			if(strPoolOrNot === ""){
				// do nothing
			} else{
				fe.pool = strPoolOrNot
				strAchitectureSimplify += "pooling "
			}
			
			
			
			return fe
		}
		
		def IntersticeManagement(){
			var inter = factory.createInterstice()
			var flatorGlo = factory.createFlattenOrGlobal()
			
			var strflatOrGLo = flatOrGLo.get(rand.nextInt(flatOrGLo.size()));
			
			if(strflatOrGLo == "flatten"){
				// === FLATTEN
				flatorGlo.flat = strflatOrGLo
				
			}else {
				// ==== GLOPOOL
				flatorGlo.gp = strflatOrGLo
			}
			
			inter.setFg(flatorGlo)
			return inter
		}
		
		def classificationManagement(){
			var classif = factory.createClassification()
				
			// === DROPOUT
			var strDropOrNot = dropOrNot.get(rand.nextInt(dropOrNot.size()));
			
			if(strDropOrNot === ""){
				// do nothing
			} else{
				classif.drop = strDropOrNot
			}
			
			classif.d = "dense"
			
			return classif
		}

		def convManagement(){
			var strConv = convs.get(rand.nextInt(convs.size()));
			
			var conv = factory.createConvolution
			if(strConv == "conv"){
				conv.conv = strConv
				strAchitectureSimplify += "conv "
			}else if (strConv == "bnconv"){
				conv.bnconv = strConv
				strAchitectureSimplify += "bn conv "
			}else {
				conv.convbn = strConv
				strAchitectureSimplify += "conv bn "
			}
			
			return conv
		}
		
		def mergeManagement(boolean recu){
			var merge = factory.createMerge
			if(recu){
				merge.mergeBody.add(mergeBodyManagement(1))
			}else{
				var nbMerge = nbOther.get(rand.nextInt(nbOther.size())); 
				for(var i=0; i<nbMerge; i++){
					merge.mergeBody.add(mergeBodyManagement(nbMerge))
				}
			}
			
			return merge
		}
		
		def mergeBodyManagement(int nbMerge){
			var mergeBody = factory.createMergeBody
			
			// LEFT
			mergeBody.left = leftManagement
			
			// RIGHT
			mergeBody.right = rightManagement(nbMerge)
			
			return mergeBody
		}
		
		def leftManagement(){
			var left = factory.createLeft
			
			// === POOL	
			var strPoolOrNot = poolOrNot.get(rand.nextInt(poolOrNot.size()));
			
			if(strPoolOrNot === ""){
				// do nothing
			} else{
				left.p = strPoolOrNot
				strAchitectureSimplify += "pooling "
			}
			
			// conv or merge
			left.com = convOrMergeManagement
			
			
			// === POOL	
			strPoolOrNot = poolOrNot.get(rand.nextInt(poolOrNot.size()));
			
			if(strPoolOrNot === ""){
				// do nothing
			} else{
				left.pool = strPoolOrNot
				strAchitectureSimplify += "pooling "
			}
			
			
			return left
		}
		
		def rightManagement(int nbMerge){
			var right = factory.createRight
			var strConvOrEmpty = ""
			if(nbMerge > 1 ) strConvOrEmpty = "conv"
			else strConvOrEmpty = convOrEmpty.get(rand.nextInt(convOrEmpty.size()))
			
			var nb = nbOther.get(rand.nextInt(nbOther.size())); 
			
			if(strConvOrEmpty === "conv"){
				for (var i = 0; i<nb; i++){
					right.conv.add(convManagement)
				}
			}else{
				right.empty = strConvOrEmpty
			}
			
			
			
			return right
		}
		
		
		def convOrMergeManagement(){
			var com = factory.createConvOrMerge
			
			var strConvOrMerge = convOrMerge.get(rand.nextInt(convOrMerge.size()));
			if(strConvOrMerge == "conv"){
				// === CONV
				var nb = nbOther.get(rand.nextInt(nbOther.size())); 
			
				for(var i =0; i<nb; i++){
					com.convdrop.add(convDropManagement)
				}
			}else{
				// === MERGE
				var nbConv = nbOther.get(rand.nextInt(nbOther.size()))
				var nbMerge = nbOther.get(rand.nextInt(nbOther.size())); 
			
			
				for(var i=0; i<nbConv; i++){
					com.convdrop.add(convDropManagement)
				}
				for(var i=0; i<nbMerge; i++){
					com.mergeConv.add( mergeConvManagement	)
				}
			
			}
			
			return com
		}
		
		def convDropManagement(){
			var convDrop = factory.createConvDrop
			
			convDrop.conv = convManagement
			
			// === DROPOUT
			var strDropOrNot = dropOrNot.get(rand.nextInt(dropOrNot.size()));
			
			if(strDropOrNot === ""){
				// do nothing
			} else{
				convDrop.drop = strDropOrNot
				strAchitectureSimplify += "dropout "
			}
			
			
			return convDrop
		}
		
		
		def mergeConvManagement(){
			var mc = factory.createMergeConv
			
			// Merge
			mc.merge = mergeManagement(true) as Merge
			
			// Convdrop
			var nbConv = nbOtherZero.get(rand.nextInt(nbOtherZero.size()))
			for(var i=0; i<nbConv; i++){
				mc.convdrop.add(convDropManagement)
			}
		
			return mc
		}
}