/**
 * generated by Xtext 2.26.0
 */
package xtext.sML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Extraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.FeatureExtraction#getConv <em>Conv</em>}</li>
 *   <li>{@link xtext.sML.FeatureExtraction#getMerge <em>Merge</em>}</li>
 *   <li>{@link xtext.sML.FeatureExtraction#getDrop <em>Drop</em>}</li>
 *   <li>{@link xtext.sML.FeatureExtraction#getPool <em>Pool</em>}</li>
 * </ul>
 *
 * @see xtext.sML.SMLPackage#getFeatureExtraction()
 * @model
 * @generated
 */
public interface FeatureExtraction extends EObject
{
  /**
   * Returns the value of the '<em><b>Conv</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conv</em>' containment reference.
   * @see #setConv(Convolution)
   * @see xtext.sML.SMLPackage#getFeatureExtraction_Conv()
   * @model containment="true"
   * @generated
   */
  Convolution getConv();

  /**
   * Sets the value of the '{@link xtext.sML.FeatureExtraction#getConv <em>Conv</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conv</em>' containment reference.
   * @see #getConv()
   * @generated
   */
  void setConv(Convolution value);

  /**
   * Returns the value of the '<em><b>Merge</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Merge</em>' containment reference.
   * @see #setMerge(Merge)
   * @see xtext.sML.SMLPackage#getFeatureExtraction_Merge()
   * @model containment="true"
   * @generated
   */
  Merge getMerge();

  /**
   * Sets the value of the '{@link xtext.sML.FeatureExtraction#getMerge <em>Merge</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Merge</em>' containment reference.
   * @see #getMerge()
   * @generated
   */
  void setMerge(Merge value);

  /**
   * Returns the value of the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Drop</em>' attribute.
   * @see #setDrop(String)
   * @see xtext.sML.SMLPackage#getFeatureExtraction_Drop()
   * @model
   * @generated
   */
  String getDrop();

  /**
   * Sets the value of the '{@link xtext.sML.FeatureExtraction#getDrop <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Drop</em>' attribute.
   * @see #getDrop()
   * @generated
   */
  void setDrop(String value);

  /**
   * Returns the value of the '<em><b>Pool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pool</em>' attribute.
   * @see #setPool(String)
   * @see xtext.sML.SMLPackage#getFeatureExtraction_Pool()
   * @model
   * @generated
   */
  String getPool();

  /**
   * Sets the value of the '{@link xtext.sML.FeatureExtraction#getPool <em>Pool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pool</em>' attribute.
   * @see #getPool()
   * @generated
   */
  void setPool(String value);

} // FeatureExtraction
