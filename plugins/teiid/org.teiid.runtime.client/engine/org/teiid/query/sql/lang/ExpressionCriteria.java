/* Generated By:JJTree: Do not edit this line. ExpressionCriteria.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.lang;

import org.teiid.designer.query.sql.lang.IExpressionCriteria;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.symbol.Expression;

/**
 *
 */
public class ExpressionCriteria extends Criteria implements IExpressionCriteria<LanguageVisitor> {

    private Expression expression;

    /**
     * @param p
     * @param id
     */
    public ExpressionCriteria(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
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
        ExpressionCriteria other = (ExpressionCriteria)obj;
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
    public ExpressionCriteria clone() {
        ExpressionCriteria clone = new ExpressionCriteria(this.parser, this.id);

        if(getExpression() != null)
            clone.setExpression(getExpression().clone());

        return clone;
    }

}
/* JavaCC - OriginalChecksum=ac75024b68d2274a23c0fca3d91ba8f4 (do not edit this line) */
