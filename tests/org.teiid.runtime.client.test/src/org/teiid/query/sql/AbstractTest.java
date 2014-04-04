/*
 * JBoss, Home of Professional Open Source.
*
* See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
*
* See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
*/
package org.teiid.query.sql;

import org.teiid.designer.runtime.version.spi.ITeiidServerVersion;
import org.teiid.query.parser.QueryParser;
import org.teiid.query.sql.lang.LanguageObject;

/**
 * @param <T>
 */
public abstract class AbstractTest<T extends LanguageObject> {

    protected ITeiidServerVersion teiidVersion;

    protected QueryParser parser;

    /**
     * @param teiidVersion
     */
    public AbstractTest(ITeiidServerVersion teiidVersion) {
        this.teiidVersion = teiidVersion;
        this.parser = new QueryParser(teiidVersion);
    }

    protected abstract AbstractTestFactory getFactory();
}
