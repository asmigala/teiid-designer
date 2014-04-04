/* Generated By:JJTree: Do not edit this line. SetClauseList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.lang;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.teiid.designer.query.sql.lang.ISetClauseList;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.symbol.ElementSymbol;
import org.teiid.query.sql.symbol.Expression;

/**
 *
 */
public class SetClauseList extends SimpleNode implements ISetClauseList<LanguageVisitor> {

    private List<SetClause> setClauses = new ArrayList<SetClause>();

    /**
     * @param p
     * @param id
     */
    public SetClauseList(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * @return a non-updateable map representation
     */
    public LinkedHashMap<ElementSymbol, Expression> getClauseMap() {
        LinkedHashMap<ElementSymbol, Expression> result = new LinkedHashMap<ElementSymbol, Expression>();
        for (SetClause clause : this.setClauses) {
            result.put(clause.getSymbol(), clause.getValue());
        }
        return result;
    }

    /**
     * @return set clauses
     */
    public List<SetClause> getClauses() {
        return this.setClauses;
    }

    /**
     * @return clauses is empty
     */
    public boolean isEmpty() {
        return this.setClauses.isEmpty();
    }

    /**
     * @param clause
     */
    public void addClause(SetClause clause) {
        this.setClauses.add(clause);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.setClauses == null) ? 0 : this.setClauses.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        SetClauseList other = (SetClauseList)obj;
        if (this.setClauses == null) {
            if (other.setClauses != null) return false;
        } else if (!this.setClauses.equals(other.setClauses)) return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SetClauseList clone() {
        SetClauseList clone = new SetClauseList(this.parser, this.id);
        clone.getClauses().addAll(cloneList(getClauses()));
        return clone;
    }

}
/* JavaCC - OriginalChecksum=03e0d8ce7120831af6c8c5e5b956b453 (do not edit this line) */
