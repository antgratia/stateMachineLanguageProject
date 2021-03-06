/*
 * generated by Xtext 2.25.0
 */
package xtext.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import xtext.sML.SML

@ExtendWith(InjectionExtension)
@InjectWith(SMLInjectorProvider)
class SMLParsingTest {
	@Inject
	ParseHelper<SML> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			input conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void doubleDense() {
		val result = parseHelper.parse('''
			input conv avg_pooling flatten dense dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void doubleconv() {
		val result = parseHelper.parse('''
			input conv conv flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void poolingFollowPooling() {
		val result = parseHelper.parse('''
			input conv avg_pooling avg_pooling flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')

	}

	@Test
	def void inputFollowPooling() {
		val result = parseHelper.parse('''
			input avg_pooling conv flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void lenet() {
		val result = parseHelper.parse('''
			input conv max_pooling conv max_pooling flatten dense dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void max_pooling_avg_pooling() {
		val result = parseHelper.parse('''
			input conv avg_pooling conv max_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	// Beging language without input
	@Test
	def void beginConv() {
		val result = parseHelper.parse('''
			conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')

	}

	@Test
	def void beginDense() {
		val result = parseHelper.parse('''
			dense conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void beginPooling() {
		val result = parseHelper.parse('''
			conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void beginInterstice() {
		val result = parseHelper.parse('''
			flatten conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void beginOutput() {
		val result = parseHelper.parse('''
			output conv avg_pooling flatten dense output 
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	// end language without output
	@Test
	def void endDense() {
		val result = parseHelper.parse('''
			input conv conv flatten dense
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void endFlatten() {
		val result = parseHelper.parse('''
			input conv conv flatten
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void endconv() {
		val result = parseHelper.parse('''
			input conv conv flatten conv
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void endPooling() {
		val result = parseHelper.parse('''
			input conv conv flatten avg_pooling
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void endInput() {
		val result = parseHelper.parse('''
			input conv conv flatten input
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	// missing part
	@Test
	def void noFeatureExtraction() {
		val result = parseHelper.parse('''
			input flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void noClassification() {
		val result = parseHelper.parse('''
			input conv max_pooling flatten output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void noconv() {
		val result = parseHelper.parse('''
			input max_pooling flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}

	@Test
	def void noPooling() {
		val result = parseHelper.parse('''
			input conv flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void resnet18() {
		val result = parseHelper.parse('''
			input (conv bn) max_pooling [(conv bn) (conv bn), (conv bn)] [(conv bn) (conv bn), Empty] [(conv bn) (conv bn), (conv bn)] [(conv bn) (conv bn), Empty] [(conv bn) (conv bn), (conv bn)] [(conv bn) (conv bn), Empty] [(conv bn) (conv bn), (conv bn)] [(conv bn) (conv bn), Empty] avg_pooling flatten dense dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void densenet() {
		val result = parseHelper.parse('''
			input conv [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] (bn conv) dropout avg_pooling [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] [(bn conv) dropout, Empty] (bn conv) dropout avg_pooling global_avg_pooling dense output  		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void poolingInMerge() {
		val result = parseHelper.parse('''
			input [conv pooling] flatten dense output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(!errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void unet() {
		val result = parseHelper.parse('''
			input conv conv [max_pooling conv conv [ max_pooling conv conv [max_pooling conv conv dropout [ max_pooling conv conv dropout upconv conv, Empty] conv conv upconv conv, Empty] conv conv upconv conv, Empty] conv conv upconv conv, Empty] conv conv conv output
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void MergeMerge() {
		val result = parseHelper.parse('''
			input [[conv, conv], conv] flatten dense output		
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void MergeConvMerge() {
		val result = parseHelper.parse('''
			input [conv [conv, conv], conv] flatten dense output		
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	
	@Test
	def void MergeConvMergeConv() {
		val result = parseHelper.parse('''
			input [conv [conv, conv] conv, conv] flatten dense output		
		''')
		Assertions.assertNotNull(result)
		println(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: ?errors.join(", ")?''')
	}
	

}