/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.extension;

import java.io.File;

import org.teiid.designer.extension.definition.ModelExtensionAssistant;
import org.teiid.designer.extension.definition.ModelExtensionAssistantAdapter;
import org.teiid.designer.extension.definition.ModelExtensionDefinition;
import org.teiid.designer.extension.registry.ModelExtensionRegistry;

/**
 * 
 */
public class Factory implements Constants {

    public static ModelExtensionAssistant createAssistant() {
        return new ModelExtensionAssistantAdapter();
    }

    public static ModelExtensionRegistry createRegistry() throws Exception {
        ModelExtensionRegistry registry = new ModelExtensionRegistry(new File(MED_SCHEMA));
        registry.setMetamodelUris(Constants.Utils.getExtendableMetamodelUris());
        return registry;
    }

    public static ModelExtensionDefinition createDefinitionWithNoPropertyDefinitions() {
        return new ModelExtensionDefinition(createAssistant(),
                                            DEFAULT_NAMESPACE_PREFIX,
                                            DEFAULT_NAMESPACE_URI,
                                            DEFAULT_METAMODEL_URI,
                                            DEFAULT_MED_DESCRIPTION,
                                            DEFAULT_VERSION);
    }

}