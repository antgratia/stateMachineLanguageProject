/**
 * generated by Xtext 2.26.0
 */
package xtext.sML;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interstice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.Interstice#getFg <em>Fg</em>}</li>
 * </ul>
 *
 * @see xtext.sML.SMLPackage#getInterstice()
 * @model
 * @generated
 */
public interface Interstice extends EObject
{
  /**
   * Returns the value of the '<em><b>Fg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fg</em>' containment reference.
   * @see #setFg(FlattenOrGlobal)
   * @see xtext.sML.SMLPackage#getInterstice_Fg()
   * @model containment="true"
   * @generated
   */
  FlattenOrGlobal getFg();

  /**
   * Sets the value of the '{@link xtext.sML.Interstice#getFg <em>Fg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fg</em>' containment reference.
   * @see #getFg()
   * @generated
   */
  void setFg(FlattenOrGlobal value);

} // Interstice
