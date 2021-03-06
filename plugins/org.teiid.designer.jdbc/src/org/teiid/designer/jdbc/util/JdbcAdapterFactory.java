/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.jdbc.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.teiid.designer.jdbc.JdbcDriver;
import org.teiid.designer.jdbc.JdbcDriverContainer;
import org.teiid.designer.jdbc.JdbcImportOptions;
import org.teiid.designer.jdbc.JdbcImportSettings;
import org.teiid.designer.jdbc.JdbcPackage;
import org.teiid.designer.jdbc.JdbcSource;
import org.teiid.designer.jdbc.JdbcSourceContainer;
import org.teiid.designer.jdbc.JdbcSourceProperty;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.teiid.designer.jdbc.JdbcPackage
 * @generated
 *
 * @since 8.0
 */
public class JdbcAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static JdbcPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = JdbcPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch the delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcSwitch modelSwitch =
        new JdbcSwitch() {
            @Override
            public Object caseJdbcSourceProperty(JdbcSourceProperty object) {
                return createJdbcSourcePropertyAdapter();
            }
            @Override
            public Object caseJdbcDriver(JdbcDriver object) {
                return createJdbcDriverAdapter();
            }
            @Override
            public Object caseJdbcSource(JdbcSource object) {
                return createJdbcSourceAdapter();
            }
            @Override
            public Object caseJdbcDriverContainer(JdbcDriverContainer object) {
                return createJdbcDriverContainerAdapter();
            }
            @Override
            public Object caseJdbcSourceContainer(JdbcSourceContainer object) {
                return createJdbcSourceContainerAdapter();
            }
            @Override
            public Object caseJdbcImportSettings(JdbcImportSettings object) {
                return createJdbcImportSettingsAdapter();
            }
            @Override
            public Object caseJdbcImportOptions(JdbcImportOptions object) {
                return createJdbcImportOptionsAdapter();
            }
            @Override
            public Object defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcSourceProperty <em>Source Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcSourceProperty
     * @generated
     */
    public Adapter createJdbcSourcePropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcDriver
     * @generated
     */
    public Adapter createJdbcDriverAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcSource
     * @generated
     */
    public Adapter createJdbcSourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcDriverContainer <em>Driver Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcDriverContainer
     * @generated
     */
    public Adapter createJdbcDriverContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcSourceContainer <em>Source Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcSourceContainer
     * @generated
     */
    public Adapter createJdbcSourceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcImportSettings <em>Import Settings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcImportSettings
     * @generated
     */
    public Adapter createJdbcImportSettingsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.jdbc.JdbcImportOptions <em>Import Options</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.jdbc.JdbcImportOptions
     * @generated
     */
    public Adapter createJdbcImportOptionsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //JdbcAdapterFactory
