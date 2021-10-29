/**
 * generated by Xtext 2.25.0
 */
package xtext.sML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.sML.LeftRecu;
import xtext.sML.MergeRecu;
import xtext.sML.Right;
import xtext.sML.SMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge Recu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xtext.sML.impl.MergeRecuImpl#getDb <em>Db</em>}</li>
 *   <li>{@link xtext.sML.impl.MergeRecuImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link xtext.sML.impl.MergeRecuImpl#getVirg <em>Virg</em>}</li>
 *   <li>{@link xtext.sML.impl.MergeRecuImpl#getRight <em>Right</em>}</li>
 *   <li>{@link xtext.sML.impl.MergeRecuImpl#getFm <em>Fm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MergeRecuImpl extends MinimalEObjectImpl.Container implements MergeRecu
{
  /**
   * The default value of the '{@link #getDb() <em>Db</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDb()
   * @generated
   * @ordered
   */
  protected static final String DB_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDb() <em>Db</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDb()
   * @generated
   * @ordered
   */
  protected String db = DB_EDEFAULT;

  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected LeftRecu left;

  /**
   * The default value of the '{@link #getVirg() <em>Virg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVirg()
   * @generated
   * @ordered
   */
  protected static final String VIRG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVirg() <em>Virg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVirg()
   * @generated
   * @ordered
   */
  protected String virg = VIRG_EDEFAULT;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected Right right;

  /**
   * The default value of the '{@link #getFm() <em>Fm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFm()
   * @generated
   * @ordered
   */
  protected static final String FM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFm() <em>Fm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFm()
   * @generated
   * @ordered
   */
  protected String fm = FM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MergeRecuImpl()
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
    return SMLPackage.Literals.MERGE_RECU;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDb()
  {
    return db;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDb(String newDb)
  {
    String oldDb = db;
    db = newDb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__DB, oldDb, db));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LeftRecu getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(LeftRecu newLeft, NotificationChain msgs)
  {
    LeftRecu oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__LEFT, oldLeft, newLeft);
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
  public void setLeft(LeftRecu newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_RECU__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_RECU__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVirg()
  {
    return virg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVirg(String newVirg)
  {
    String oldVirg = virg;
    virg = newVirg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__VIRG, oldVirg, virg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Right getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(Right newRight, NotificationChain msgs)
  {
    Right oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__RIGHT, oldRight, newRight);
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
  public void setRight(Right newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_RECU__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SMLPackage.MERGE_RECU__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__RIGHT, newRight, newRight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getFm()
  {
    return fm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFm(String newFm)
  {
    String oldFm = fm;
    fm = newFm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SMLPackage.MERGE_RECU__FM, oldFm, fm));
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
      case SMLPackage.MERGE_RECU__LEFT:
        return basicSetLeft(null, msgs);
      case SMLPackage.MERGE_RECU__RIGHT:
        return basicSetRight(null, msgs);
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
      case SMLPackage.MERGE_RECU__DB:
        return getDb();
      case SMLPackage.MERGE_RECU__LEFT:
        return getLeft();
      case SMLPackage.MERGE_RECU__VIRG:
        return getVirg();
      case SMLPackage.MERGE_RECU__RIGHT:
        return getRight();
      case SMLPackage.MERGE_RECU__FM:
        return getFm();
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
      case SMLPackage.MERGE_RECU__DB:
        setDb((String)newValue);
        return;
      case SMLPackage.MERGE_RECU__LEFT:
        setLeft((LeftRecu)newValue);
        return;
      case SMLPackage.MERGE_RECU__VIRG:
        setVirg((String)newValue);
        return;
      case SMLPackage.MERGE_RECU__RIGHT:
        setRight((Right)newValue);
        return;
      case SMLPackage.MERGE_RECU__FM:
        setFm((String)newValue);
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
      case SMLPackage.MERGE_RECU__DB:
        setDb(DB_EDEFAULT);
        return;
      case SMLPackage.MERGE_RECU__LEFT:
        setLeft((LeftRecu)null);
        return;
      case SMLPackage.MERGE_RECU__VIRG:
        setVirg(VIRG_EDEFAULT);
        return;
      case SMLPackage.MERGE_RECU__RIGHT:
        setRight((Right)null);
        return;
      case SMLPackage.MERGE_RECU__FM:
        setFm(FM_EDEFAULT);
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
      case SMLPackage.MERGE_RECU__DB:
        return DB_EDEFAULT == null ? db != null : !DB_EDEFAULT.equals(db);
      case SMLPackage.MERGE_RECU__LEFT:
        return left != null;
      case SMLPackage.MERGE_RECU__VIRG:
        return VIRG_EDEFAULT == null ? virg != null : !VIRG_EDEFAULT.equals(virg);
      case SMLPackage.MERGE_RECU__RIGHT:
        return right != null;
      case SMLPackage.MERGE_RECU__FM:
        return FM_EDEFAULT == null ? fm != null : !FM_EDEFAULT.equals(fm);
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
    result.append(" (db: ");
    result.append(db);
    result.append(", virg: ");
    result.append(virg);
    result.append(", fm: ");
    result.append(fm);
    result.append(')');
    return result.toString();
  }

} //MergeRecuImpl
