/**
 * generated by Xtext 2.25.0
 */
package xtext.sML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conv Or Merge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.ConvOrMerge#getConvdrop <em>Convdrop</em>}</li>
 *   <li>{@link xtext.sML.ConvOrMerge#getMergeConv <em>Merge Conv</em>}</li>
 * </ul>
 *
 * @see xtext.sML.SMLPackage#getConvOrMerge()
 * @model
 * @generated
 */
public interface ConvOrMerge extends EObject
{
  /**
   * Returns the value of the '<em><b>Convdrop</b></em>' containment reference list.
   * The list contents are of type {@link xtext.sML.ConvDrop}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Convdrop</em>' containment reference list.
   * @see xtext.sML.SMLPackage#getConvOrMerge_Convdrop()
   * @model containment="true"
   * @generated
   */
  EList<ConvDrop> getConvdrop();

  /**
   * Returns the value of the '<em><b>Merge Conv</b></em>' containment reference list.
   * The list contents are of type {@link xtext.sML.MergeConv}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Merge Conv</em>' containment reference list.
   * @see xtext.sML.SMLPackage#getConvOrMerge_MergeConv()
   * @model containment="true"
   * @generated
   */
  EList<MergeConv> getMergeConv();


} // ConvOrMerge
