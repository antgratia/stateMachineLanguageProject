/**
 * generated by Xtext 2.26.0
 */
package xtext.sML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SML</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.SML#getSml <em>Sml</em>}</li>
 * </ul>
 *
 * @see xtext.sML.SMLPackage#getSML()
 * @model
 * @generated
 */
public interface SML extends EObject
{
  /**
   * Returns the value of the '<em><b>Sml</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sml</em>' containment reference.
   * @see #setSml(Architecture)
   * @see xtext.sML.SMLPackage#getSML_Sml()
   * @model containment="true"
   * @generated
   */
  Architecture getSml();

  /**
   * Sets the value of the '{@link xtext.sML.SML#getSml <em>Sml</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sml</em>' containment reference.
   * @see #getSml()
   * @generated
   */
  void setSml(Architecture value);

} // SML
