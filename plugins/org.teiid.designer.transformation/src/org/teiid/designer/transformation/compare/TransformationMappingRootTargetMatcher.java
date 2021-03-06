/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.transformation.compare;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.mapping.Mapping;
import org.eclipse.emf.mapping.MappingFactory;
import org.teiid.designer.core.compare.AbstractEObjectMatcher;
import org.teiid.designer.core.compare.TwoPhaseEObjectMatcher;
import org.teiid.designer.metamodels.transformation.TransformationMappingRoot;



/** 
 * TransformationMappingRootTargetMatcher
 *
 * @since 8.0
 */
public class TransformationMappingRootTargetMatcher extends AbstractEObjectMatcher implements
                                                                                      TwoPhaseEObjectMatcher {

    /**
     * Construct an instance of CoreAnnotationMatcher.
     * 
     */
    public TransformationMappingRootTargetMatcher() {
        super();
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappingsForRoots(java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappingsForRoots(final List inputs, final List outputs,
                                    final Map inputsToOutputs, 
                                    final Mapping mapping, final MappingFactory factory) {
        // do nothing for roots ...
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappings(org.eclipse.emf.ecore.EReference, java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappings( final EReference reference, final List inputs, final List outputs, 
                             final Map inputsToOutputs, 
                             final Mapping mapping, final MappingFactory factory) {
        final Map inputRootsByTargetObject = new HashMap();

        // Loop over the inputs and find any of the above objects ...
        final Iterator iter = inputs.iterator();
        while (iter.hasNext()) {
            final TransformationMappingRoot root = (TransformationMappingRoot)iter.next();
            final EObject targetObject = root.getTarget();
            if ( targetObject != null ) {
                final Object outputTargetObject = inputsToOutputs.get(targetObject);
                inputRootsByTargetObject.put(outputTargetObject,root);
            }
        }

        // Loop over the outputs and find matches for any of the above objects ...
        final Iterator outputIter = outputs.iterator();
        while (outputIter.hasNext()) {
            final TransformationMappingRoot outputRoot = (TransformationMappingRoot)outputIter.next();
            final EObject outputTraget = outputRoot.getTarget();
            if ( outputTraget != null ) {
                final TransformationMappingRoot inputRoot = (TransformationMappingRoot)inputRootsByTargetObject.get(outputTraget);
                if ( inputRoot != null ) {
                    inputs.remove(inputRoot);
                    outputIter.remove();
                    addMapping(inputRoot,outputRoot,mapping,factory);
                    inputsToOutputs.put(inputRoot,outputRoot);
                }
            }
        }
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappingsForRoots(java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappingsForRoots(final List inputs, final List outputs, final Mapping mapping, final MappingFactory factory) {
        // do nothing for the first phase ...
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappings(org.eclipse.emf.ecore.EReference, java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappings(final EReference reference, final List inputs, final List outputs, final Mapping mapping, final MappingFactory factory) {
        // do nothing for the first phase ...
    }

}
