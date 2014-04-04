/* Generated By:JJTree: Do not edit this line. RaiseErrorStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=TeiidNodeFactory,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.proc;

import org.teiid.core.types.DataTypeManagerService;
import org.teiid.designer.annotation.Removed;
import org.teiid.designer.query.sql.proc.IRaiseStatement;
import org.teiid.designer.runtime.version.spi.TeiidServerVersion.Version;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.symbol.Expression;

/**
 *
 */
@Removed(Version.TEIID_8_0)
public class RaiseErrorStatement extends Statement implements ExpressionStatement, IRaiseStatement<LanguageVisitor, Expression> {

    private Expression expression;

    /**
     * @param p
     * @param id
     */
    public RaiseErrorStatement(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * Return the type for this statement, this is one of the types
     * defined on the statement object.
     * @return The statement type
     */
    @Override
    public StatementType getType() {
        return StatementType.TYPE_ERROR;
    }

    @Override
    public Expression getExpression() {
        return expression;
    }
    
    /**
     * @param expression
     */
    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Class<?> getExpectedType() {
        return DataTypeManagerService.DefaultDataTypes.OBJECT.getTypeClass();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.expression == null) ? 0 : this.expression.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        RaiseErrorStatement other = (RaiseErrorStatement)obj;
        if (this.expression == null) {
            if (other.expression != null) return false;
        } else if (!this.expression.equals(other.expression)) return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public RaiseErrorStatement clone() {
        RaiseErrorStatement clone = new RaiseErrorStatement(this.parser, this.id);

        if(getExpression() != null)
            clone.setExpression(getExpression().clone());

        return clone;
    }

}
/* JavaCC - OriginalChecksum=e7907291ea67c15960482eabdc9a9c51 (do not edit this line) */
