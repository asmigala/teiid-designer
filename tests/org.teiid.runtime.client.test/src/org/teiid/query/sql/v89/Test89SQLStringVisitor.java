/*
 * JBoss, Home of Professional Open Source.
*
* See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
*
* See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
*/
package org.teiid.query.sql.v89;

import org.teiid.designer.runtime.version.spi.ITeiidServerVersion;
import org.teiid.designer.runtime.version.spi.TeiidServerVersion.Version;
import org.teiid.query.sql.v88.Test88SQLStringVisitor;

/**
 *
 */
@SuppressWarnings( {"javadoc"} )
public class Test89SQLStringVisitor extends Test88SQLStringVisitor {

    protected Test89SQLStringVisitor(ITeiidServerVersion teiidVersion) {
        super(teiidVersion);
    }

    public Test89SQLStringVisitor() {
        this(Version.TEIID_8_9.get());
    }

}
