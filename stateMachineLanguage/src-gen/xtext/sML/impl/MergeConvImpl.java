/**
 * generated by Xtext 2.26.0
 */
package xtext.sML.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import xtext.sML.ConvDrop;
import xtext.sML.Merge;
import xtext.sML.MergeConv;
import xtext.sML.SMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge Conv</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.impl.MergeConvImpl#getMerge <em>Merge</em>}</li>
 *   <li>{@link xtext.sML.impl.MergeConvImpl#getConvdrop <em>Convdrop</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MergeConvImpl extends MinimalEObjectImpl.Container implements MergeConv
{
  /**
   * The cached value of the '{@link #getMerge() <em>Merge</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMerge()
   * @generated
   * @ordered
   */
  protected Merge merge;

  /**
   * The cached value of the '{@link #getConvdrop() <em>Convdrop</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConvdrop()
   * @generated
   * @ordered
   */
  protected EList<ConvDrop> convdrop;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MergeConvImpl()
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
    return SMLPackage.Literals.MERGE_CONV;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Merge getMerge()
  {
    return merge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMerge(Merge newMerge, NotificationChain msgs)
  {
    Merge oldMerge = merge;
    merge = newMerge;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_CONV__MERGE, oldMerge, newMerge);
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
  public void setMerge(Merge newMerge)
  {
    if (newMerge != merge)
    {
      NotificationChain msgs = null;
      if (merge != null)
        msgs = ((InternalEObject)merge).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_CONV__MERGE, null, msgs);
      if (newMerge != null)
        msgs = ((InternalEObject)newMerge).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_CONV__MERGE, null, msgs);
      msgs = basicSetMerge(newMerge, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_CONV__MERGE, newMerge, newMerge));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ConvDrop> getConvdrop()
  {
    if (convdrop == null)
    {
      convdrop = new EObjectContainmentEList<ConvDrop>(ConvDrop.class, this, SMLPackage.MERGE_CONV__CONVDROP);
    }
    return convdrop;
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
      case SMLPackage.MERGE_CONV__MERGE:
        return basicSetMerge(null, msgs);
      case SMLPackage.MERGE_CONV__CONVDROP:
        return ((InternalEList<?>)getConvdrop()).basicRemove(otherEnd, msgs);
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
      case SMLPackage.MERGE_CONV__MERGE:
        return getMerge();
      case SMLPackage.MERGE_CONV__CONVDROP:
        return getConvdrop();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SMLPackage.MERGE_CONV__MERGE:
        setMerge((Merge)newValue);
        return;
      case SMLPackage.MERGE_CONV__CONVDROP:
        getConvdrop().clear();
        getConvdrop().addAll((Collection<? extends ConvDrop>)newValue);
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
      case SMLPackage.MERGE_CONV__MERGE:
        setMerge((Merge)null);
        return;
      case SMLPackage.MERGE_CONV__CONVDROP:
        getConvdrop().clear();
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
      case SMLPackage.MERGE_CONV__MERGE:
        return merge != null;
      case SMLPackage.MERGE_CONV__CONVDROP:
        return convdrop != null && !convdrop.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MergeConvImpl
