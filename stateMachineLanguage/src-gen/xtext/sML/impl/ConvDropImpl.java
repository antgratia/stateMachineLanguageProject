/**
 * generated by Xtext 2.26.0
 */
package xtext.sML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.sML.ConvDrop;
import xtext.sML.Convolution;
import xtext.sML.SMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conv Drop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.impl.ConvDropImpl#getConv <em>Conv</em>}</li>
 *   <li>{@link xtext.sML.impl.ConvDropImpl#getDrop <em>Drop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConvDropImpl extends MinimalEObjectImpl.Container implements ConvDrop
{
  /**
   * The cached value of the '{@link #getConv() <em>Conv</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConv()
   * @generated
   * @ordered
   */
  protected Convolution conv;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConvDropImpl()
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
    return SMLPackage.Literals.CONV_DROP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Convolution getConv()
  {
    return conv;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConv(Convolution newConv, NotificationChain msgs)
  {
    Convolution oldConv = conv;
    conv = newConv;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SMLPackage.CONV_DROP__CONV, oldConv, newConv);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConv(Convolution newConv)
  {
    if (newConv != conv)
    {
      NotificationChain msgs = null;
      if (conv != null)
        msgs = ((InternalEObject)conv).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SMLPackage.CONV_DROP__CONV, null, msgs);
      if (newConv != null)
        msgs = ((InternalEObject)newConv).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SMLPackage.CONV_DROP__CONV, null, msgs);
      msgs = basicSetConv(newConv, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.CONV_DROP__CONV, newConv, newConv));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.CONV_DROP__DROP, oldDrop, drop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SMLPackage.CONV_DROP__CONV:
        return basicSetConv(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SMLPackage.CONV_DROP__CONV:
        return getConv();
      case SMLPackage.CONV_DROP__DROP:
        return getDrop();
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
      case SMLPackage.CONV_DROP__CONV:
        setConv((Convolution)newValue);
        return;
      case SMLPackage.CONV_DROP__DROP:
        setDrop((String)newValue);
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
      case SMLPackage.CONV_DROP__CONV:
        setConv((Convolution)null);
        return;
      case SMLPackage.CONV_DROP__DROP:
        setDrop(DROP_EDEFAULT);
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
      case SMLPackage.CONV_DROP__CONV:
        return conv != null;
      case SMLPackage.CONV_DROP__DROP:
        return DROP_EDEFAULT == null ? drop != null : !DROP_EDEFAULT.equals(drop);
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
    result.append(')');
    return result.toString();
  }

} //ConvDropImpl
