/* Generated By:JJTree: Do not edit this line. Select.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.lang;

import java.util.ArrayList;
import java.util.List;
import org.teiid.designer.query.sql.lang.ISelect;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidNodeFactory.ASTNodes;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.symbol.ElementSymbol;
import org.teiid.query.sql.symbol.Expression;
import org.teiid.query.sql.symbol.ExpressionSymbol;
import org.teiid.query.sql.symbol.MultipleElementSymbol;
import org.teiid.query.sql.symbol.Symbol;

/**
 *
 */
public class Select extends SimpleNode implements ISelect<Expression, LanguageVisitor> {

    /** The set of symbols for the data elements to be selected. */
    private List<Expression> symbols = new ArrayList<Expression>();

    /** Flag for whether duplicate removal should be performed on the results */
    private boolean distinct;

    /**
     * @param p
     * @param id
     */
    public Select(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * Returns an ordered list of the symbols in the select.
     * @return list of SelectSymbol in SELECT
     */
    @Override
    public List<Expression> getSymbols() {
        return symbols;
    }

    /**
     * Remove all current symbols
     */
    public void clearSymbols() {
        symbols.clear();
    }

    /**
     * @param symbol New symbol
     */
    @Override
    public void addSymbol( Expression symbol ) {
        if (!(symbol instanceof Symbol) && !(symbol instanceof MultipleElementSymbol)) {
            ExpressionSymbol exSymbol = parser.createASTNode(ASTNodes.EXPRESSION_SYMBOL);
            exSymbol.setName("expr" + (this.symbols.size() + 1)); //$NON-NLS-1$
            exSymbol.setExpression(symbol);
            symbol = exSymbol;
        }

        this.symbols.add(symbol);
    }

    /**
     * Sets an ordered list of the symbols in the select.
     * @param symbols list of SelectSymbol in SELECT
     */
    @Override
    public void setSymbols(List<? extends Expression> symbols) {
        this.symbols = new ArrayList<Expression>(symbols);
    }    

    /**
     * Returns the select symbol at the specified index.
     * @param index Index to get
     * @return The variable identifier at the index
     */
    public Expression getSymbol( int index ) {
        return symbols.get(index);
    }

    /**
     * Checks if a symbol is in the Select.
     * @param symbol Symbol to check for
     * @return True if the Select contains the symbol
     */
    public boolean containsSymbol( Expression symbol ) {
        return symbols.contains(symbol);
    }

    /**
     * Set whether select is distinct.
     * @param isDistinct True if SELECT is distinct
     */
    @Override
    public void setDistinct(boolean isDistinct) {
        this.distinct = isDistinct;
    }

    /**
     * Checks whether the select is distinct
     * @return True if select is distinct
     */
    @Override
    public boolean isDistinct() {
        return this.distinct;
    }

    /**
     * Get the ordered list of all elements returned by this select.  These elements
     * may be ElementSymbols or ExpressionSymbols but in all cases each represents a 
     * single column.
     * @return Ordered list of SingleElementSymbol
     */
    public List<Expression> getProjectedSymbols() { 
        ArrayList<Expression> projectedSymbols = new ArrayList<Expression>();
        for (Expression symbol : symbols) {
            if(symbol instanceof MultipleElementSymbol) { 
                List<ElementSymbol> multiSymbols = ((MultipleElementSymbol)symbol).getElementSymbols();
                if(multiSymbols != null) { 
                    projectedSymbols.addAll(multiSymbols);
                }
            } else {
                projectedSymbols.add(symbol);
            }
        }       
        return projectedSymbols;
    }

    /**
     * Checks for a Select * clause
     * @return True if Select * is used
     */
    @Override
    public boolean isStar() {
        return (symbols.size() == 1 && symbols.get(0) instanceof MultipleElementSymbol && ((MultipleElementSymbol)symbols.get(0)).getGroup() == null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (this.distinct ? 1231 : 1237);
        result = prime * result + ((this.symbols == null) ? 0 : this.symbols.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Select other = (Select)obj;
        if (this.distinct != other.distinct) return false;
        if (this.symbols == null) {
            if (other.symbols != null) return false;
        } else if (!this.symbols.equals(other.symbols)) return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Select clone() {
        Select clone = new Select(this.parser, this.id);

        clone.setDistinct(isDistinct());
        if(getSymbols() != null)
            clone.setSymbols(cloneList(getSymbols()));

        return clone;
    }

}
/* JavaCC - OriginalChecksum=4c7be18eb854a0b784d1768f36c4d687 (do not edit this line) */
