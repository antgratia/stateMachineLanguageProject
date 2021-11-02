/**
 * generated by Xtext 2.25.0
 */
package xtext.sML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.sML.Classification;
import xtext.sML.SMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.impl.ClassificationImpl#getDrop <em>Drop</em>}</li>
 *   <li>{@link xtext.sML.impl.ClassificationImpl#getD <em>D</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassificationImpl extends MinimalEObjectImpl.Container implements Classification
{
  /**
   * The default value of the '{@link #getDrop() <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDrop()
   * @generated
   * @ordered
   */
  protected static final String DROP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDrop() <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDrop()
   * @generated
   * @ordered
   */
  protected String drop = DROP_EDEFAULT;

  /**
   * The default value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected static final String D_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getD() <em>D</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getD()
   * @generated
   * @ordered
   */
  protected String d = D_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassificationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SMLPackage.Literals.CLASSIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDrop()
  {
    return drop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDrop(String newDrop)
  {
    String oldDrop = drop;
    drop = newDrop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.CLASSIFICATION__DROP, oldDrop, drop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getD()
  {
    return d;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setD(String newD)
  {
    String oldD = d;
    d = newD;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.CLASSIFICATION__D, oldD, d));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SMLPackage.CLASSIFICATION__DROP:
        return getDrop();
      case SMLPackage.CLASSIFICATION__D:
        return getD();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SMLPackage.CLASSIFICATION__DROP:
        setDrop((String)newValue);
        return;
      case SMLPackage.CLASSIFICATION__D:
        setD((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SMLPackage.CLASSIFICATION__DROP:
        setDrop(DROP_EDEFAULT);
        return;
      case SMLPackage.CLASSIFICATION__D:
        setD(D_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SMLPackage.CLASSIFICATION__DROP:
        return DROP_EDEFAULT == null ? drop != null : !DROP_EDEFAULT.equals(drop);
      case SMLPackage.CLASSIFICATION__D:
        return D_EDEFAULT == null ? d != null : !D_EDEFAULT.equals(d);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (drop: ");
    result.append(drop);
    result.append(", d: ");
    result.append(d);
    result.append(')');
    return result.toString();
  }

} //ClassificationImpl
