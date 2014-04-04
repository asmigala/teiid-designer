/* Generated By:JJTree: Do not edit this line. XMLQuery.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.symbol;

import java.util.ArrayList;
import java.util.List;
import org.teiid.core.types.DataTypeManagerService;
import org.teiid.designer.query.sql.symbol.IXMLQuery;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.lang.SimpleNode;
import org.teiid.query.xquery.saxon.SaxonXQueryExpression;

/**
 *
 */
public class XMLQuery extends SimpleNode implements Expression, IXMLQuery<LanguageVisitor> {

    private XMLNamespaces namespaces;

    private String xquery;

    private List<DerivedColumn> passing = new ArrayList<DerivedColumn>();

    private Boolean emptyOnEmpty;

    private SaxonXQueryExpression xqueryExpression;

    /**
     * @param p
     * @param id
     */
    public XMLQuery(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * @return empty on empty
     */
    public Boolean getEmptyOnEmpty() {
        return emptyOnEmpty;
    }
    
    /**
     * @param emptyOnEmpty
     */
    public void setEmptyOnEmpty(Boolean emptyOnEmpty) {
        this.emptyOnEmpty = emptyOnEmpty;
    }
    
    /**
     * @return passing
     */
    public List<DerivedColumn> getPassing() {
        return passing;
    }

    /**
     * @param passing the passing to set
     */
    public void setPassing(List<DerivedColumn> passing) {
        this.passing = passing;
    }

    public void compileXqueryExpression() throws Exception {
        this.xqueryExpression = new SaxonXQueryExpression(xquery, namespaces, passing, null);
        this.xqueryExpression.useDocumentProjection(null);
    }
    
    public SaxonXQueryExpression getXQueryExpression() {
        return xqueryExpression;
    }

    /**
     * @return xquery
     */
    public String getXquery() {
        return xquery;
    }
    
    /**
     * @param xquery
     */
    public void setXquery(String xquery) {
        this.xquery = xquery;
    }
    
    /**
     * @return namespaces
     */
    public XMLNamespaces getNamespaces() {
        return namespaces;
    }
    
    /**
     * @param namespaces
     */
    public void setNamespaces(XMLNamespaces namespaces) {
        this.namespaces = namespaces;
    }

    @Override
    public Class<?> getType() {
        return DataTypeManagerService.DefaultDataTypes.XML.getTypeClass();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.emptyOnEmpty == null) ? 0 : this.emptyOnEmpty.hashCode());
        result = prime * result + ((this.namespaces == null) ? 0 : this.namespaces.hashCode());
        result = prime * result + ((this.passing == null) ? 0 : this.passing.hashCode());
        result = prime * result + ((this.xquery == null) ? 0 : this.xquery.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        XMLQuery other = (XMLQuery)obj;
        if (this.emptyOnEmpty == null) {
            if (other.emptyOnEmpty != null) return false;
        } else if (!this.emptyOnEmpty.equals(other.emptyOnEmpty)) return false;
        if (this.namespaces == null) {
            if (other.namespaces != null) return false;
        } else if (!this.namespaces.equals(other.namespaces)) return false;
        if (this.passing == null) {
            if (other.passing != null) return false;
        } else if (!this.passing.equals(other.passing)) return false;
        if (this.xquery == null) {
            if (other.xquery != null) return false;
        } else if (!this.xquery.equals(other.xquery)) return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public XMLQuery clone() {
        XMLQuery clone = new XMLQuery(this.parser, this.id);

        if(getPassing() != null)
            clone.setPassing(cloneList(getPassing()));
        if(getNamespaces() != null)
            clone.setNamespaces(getNamespaces().clone());
        clone.setEmptyOnEmpty(getEmptyOnEmpty());
        if(getXquery() != null)
            clone.setXquery(getXquery());

        return clone;
    }

}
/* JavaCC - OriginalChecksum=b931394cf8251b585a24b9099cf30d2c (do not edit this line) */
