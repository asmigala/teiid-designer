/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.function.util;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.teiid.designer.metamodels.function.Function;
import org.teiid.designer.metamodels.function.FunctionPackage;
import org.teiid.designer.metamodels.function.FunctionParameter;
import org.teiid.designer.metamodels.function.ReturnParameter;
import org.teiid.designer.metamodels.function.ScalarFunction;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.teiid.designer.metamodels.function.FunctionPackage
 * @generated
 *
 * @since 8.0
 */
public class FunctionAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static FunctionPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = FunctionPackage.eINSTANCE;
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
    protected FunctionSwitch modelSwitch =
        new FunctionSwitch() {
            @Override
            public Object caseFunction(Function object) {
                return createFunctionAdapter();
            }
            @Override
            public Object caseScalarFunction(ScalarFunction object) {
                return createScalarFunctionAdapter();
            }
            @Override
            public Object caseFunctionParameter(FunctionParameter object) {
                return createFunctionParameterAdapter();
            }
            @Override
            public Object caseReturnParameter(ReturnParameter object) {
                return createReturnParameterAdapter();
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
     * Creates a new adapter for an object of class '{@link org.teiid.designer.metamodels.function.Function <em>Function</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.metamodels.function.Function
     * @generated
     */
    public Adapter createFunctionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.metamodels.function.ScalarFunction <em>Scalar Function</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.metamodels.function.ScalarFunction
     * @generated
     */
    public Adapter createScalarFunctionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.metamodels.function.FunctionParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.metamodels.function.FunctionParameter
     * @generated
     */
    public Adapter createFunctionParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.teiid.designer.metamodels.function.ReturnParameter <em>Return Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.teiid.designer.metamodels.function.ReturnParameter
     * @generated
     */
    public Adapter createReturnParameterAdapter() {
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

} //FunctionAdapterFactory
