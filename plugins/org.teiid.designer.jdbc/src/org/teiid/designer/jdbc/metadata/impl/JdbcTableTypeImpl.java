/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.jdbc.metadata.impl;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.teiid.designer.jdbc.JdbcException;
import org.teiid.designer.jdbc.JdbcPlugin;
import org.teiid.designer.jdbc.metadata.JdbcDatabase;
import org.teiid.designer.jdbc.metadata.JdbcNode;
import org.teiid.designer.jdbc.metadata.JdbcTableType;

/**
 * JdbcTableTypeImpl
 *
 * @since 8.0
 */
public class JdbcTableTypeImpl extends JdbcNodeImpl implements JdbcTableType {
    static final String SQL_SERVER_DB_METADATA = "SQLServerDatabaseMetaData"; //$NON-NLS-1$
    
    /**
     * Construct an instance of JdbcTableTypeImpl.
     * 
     */
    public JdbcTableTypeImpl( final JdbcNode parent, final String typeName ) {
        super(TABLE_TYPE,typeName,parent);
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.impl.JdbcNodeImpl#computeChildren()
     */
    @Override
    protected JdbcNode[] computeChildren() throws JdbcException {
        // Create the children ...
        final DatabaseMetaData metadata = getJdbcDatabase().getDatabaseMetaData();
        final List children = new ArrayList();
        
        final String schemaName = getSchemaName(this);
        final String catalogName = getCatalogName(this);
        
        boolean isSqlServer = metadata.getClass().getName().endsWith(SQL_SERVER_DB_METADATA);

        // Get the tables for this type ...
        ResultSet resultSet = null;
        try {
            final String[] tableTypes = new String[]{getName()};

            resultSet = metadata.getTables(catalogName,schemaName,WILDCARD_PATTERN,tableTypes);
            while (resultSet != null && resultSet.next()) {
                final String tableName = resultSet.getString(3);
                final String remarks = resultSet.getString(5);
                final JdbcTableImpl table = new JdbcTableImpl(this,tableName);
                table.setRemarks(remarks);
                children.add(table);
            }
        } catch (Throwable t) {
            if (!isSqlServer) {
                final Object[] params = new Object[] {metadata.getClass().getName(), getJdbcDatabase()};
                final String msg = JdbcPlugin.Util.getString("JdbcTableTypeImpl.Unexpected_exception_while_calling_getTables()_and_processing_results", params); //$NON-NLS-1$
                JdbcPlugin.Util.log(IStatus.WARNING, t, msg);
            }
        } finally {
            if ( resultSet != null ) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    JdbcPlugin.Util.log(e);
                }
            }
        }
      
        // Convert the list to an array and return ...
        return (JdbcNode[])children.toArray(new JdbcNode[children.size()]);
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.impl.JdbcNodeImpl#getTypeName()
     */
    @Override
	public String getTypeName() {
        return JdbcPlugin.Util.getString("JdbcTableTypeImpl.TableTypeName"); //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#getFullyQualifiedName()
     */
    @Override
	public String getFullyQualifiedName() {
        return getParent().getFullyQualifiedName();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#getPathInSource()
     */
    @Override
    public IPath getPathInSource() {
        return null;
    }
    
    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#getPathInSource(boolean, boolean)
     */
    @Override
	public IPath getPathInSource( final boolean includeCatalog, final boolean includeSchema) {
        return null;
    }
    
    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#getParentDatabaseObject(boolean, boolean)
     */
    @Override
    public JdbcNode getParentDatabaseObject(final boolean includeCatalog, final boolean includeSchema) {
        return null;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#isDatabaseObject()
     */
    @Override
    public boolean isDatabaseObject() {
        return false;
    }
    
    /* (non-Javadoc)
     * @See org.teiid.designer.jdbc.metadata.JdbcNode#getJdbcDatabase()
     */
    @Override
	public JdbcDatabase getJdbcDatabase() {
        return getParent().getJdbcDatabase();
    }
}
