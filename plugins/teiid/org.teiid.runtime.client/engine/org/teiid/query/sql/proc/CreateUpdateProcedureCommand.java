/* Generated By:JJTree: Do not edit this line. CreateUpdateProcedureCommand.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=TeiidNodeFactory,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.teiid.query.sql.proc;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.teiid.designer.annotation.Removed;
import org.teiid.designer.query.sql.proc.ICreateProcedureCommand;
import org.teiid.designer.runtime.version.spi.TeiidServerVersion.Version;
import org.teiid.query.parser.LanguageVisitor;
import org.teiid.query.parser.TeiidParser;
import org.teiid.query.sql.lang.Command;
import org.teiid.query.sql.lang.StoredProcedure;
import org.teiid.query.sql.symbol.ElementSymbol;
import org.teiid.query.sql.symbol.Expression;
import org.teiid.query.sql.symbol.GroupSymbol;

/**
 *
 */
@Removed(Version.TEIID_8_0)
public class CreateUpdateProcedureCommand extends Command
    implements ICreateProcedureCommand<Block, GroupSymbol, Expression, LanguageVisitor> {

    // top level block for the procedure
    private Block block;

    //whether it is update procedure or virtual stored procedure, default to update procedure
    private boolean isUpdateProcedure = true;

    private List<? extends Expression> projectedSymbols;

    //command that returns resultset. For virtual procedure only.
    private Command resultsCommand;

    // the command the user submitted against the virtual group being updated
    private Command userCommand;

    private GroupSymbol virtualGroup;

    // map between elements on the virtual groups and the elements in the
    // transformation query that define it.
    private Map<ElementSymbol, Expression> symbolMap;

    /**
     * @param p
     * @param id
     */
    public CreateUpdateProcedureCommand(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * Return type of command to make it easier to build switch statements by command type.
     * @return The type of this command
     */
    @Override
    public int getType() {
        return TYPE_UPDATE_PROCEDURE;   
    }

    /**
     * @return the block
     */
    @Override
    public Block getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    @Override
    public void setBlock(Block block) {
        this.block = block;
    }

    /**
     * @return the isUpdateProcedure
     */
    public boolean isUpdateProcedure() {
        return this.isUpdateProcedure;
    }

    /**
     * @param isUpdateProcedure the isUpdateProcedure to set
     */
    public void setUpdateProcedure(boolean isUpdateProcedure) {
        this.isUpdateProcedure = isUpdateProcedure;
    }

    /**
     * Get the ordered list of all elements returned by this query.  These elements
     * may be ElementSymbols or ExpressionSymbols but in all cases each represents a 
     * single column.
     * @return Ordered list of SingleElementSymbol
     */
    @Override
    public List getProjectedSymbols(){
        if(this.projectedSymbols != null){
            return this.projectedSymbols;
        }
        if(!isUpdateProcedure){
            if(this.resultsCommand == null){
                //user may have not entered any query yet
                return Collections.EMPTY_LIST;
            }
            List<? extends Expression> symbols = this.resultsCommand.getProjectedSymbols();
            if (this.resultsCommand instanceof StoredProcedure) {
                StoredProcedure sp = (StoredProcedure)this.resultsCommand;
                if (sp.isCallableStatement()) {
                    symbols = sp.getResultSetColumns();
                }
            }
            setProjectedSymbols(symbols);
            return this.projectedSymbols;
        }
        this.projectedSymbols = getUpdateCommandSymbol();
        return this.projectedSymbols;        
    }

    /**
     * @param projSymbols
     */
    public void setProjectedSymbols(List<? extends Expression> projSymbols) {
        projectedSymbols = projSymbols;
    }

    /**
     * @return Command
     */
    public Command getResultsCommand() {
        return resultsCommand;
    }

    /**
     * @param command
     */
    public void setResultsCommand(Command command) {
        resultsCommand = command;
    }

    /**
     * Get the user's command to which this obj which is the subcommand
     * @return The user's command
     */ 
    public Command getUserCommand() {
        return this.userCommand;    
    }

    /**
     * Set the user's command to which this obj which is the subcommand
     * @param command The user's command
     */
    public void setUserCommand(Command command) {
        this.userCommand = command;
    }

    /**
     * @return virtual group
     */
    public GroupSymbol getVirtualGroup() {
        return this.virtualGroup;
    }

    /**
     * @param virtualGroup
     */
    @Override
    public void setVirtualGroup(GroupSymbol virtualGroup) {
        this.virtualGroup = virtualGroup;
    }

    /**
     * Set the symbol map between elements on the virtual group being updated and the
     * elements on the transformation query.
     * @param symbolMap Map of virtual group elements -> elements that define those
     */
    public void setSymbolMap(Map<ElementSymbol, Expression> symbolMap) {
        this.symbolMap = symbolMap;
    }

    /**
     * Get the symbol map between elements on the virtual group being updated and the
     * elements on the transformation query.
     * @return Map of virtual group elements -> elements that define those
     */
    public Map<ElementSymbol, Expression> getSymbolMap() {
        return this.symbolMap;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (this.isUpdateProcedure ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CreateUpdateProcedureCommand other = (CreateUpdateProcedureCommand)obj;
        if (this.isUpdateProcedure != other.isUpdateProcedure) return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public CreateUpdateProcedureCommand clone() {
        CreateUpdateProcedureCommand clone = new CreateUpdateProcedureCommand(this.parser, this.id);

        clone.setUpdateProcedure(isUpdateProcedure());
        if(getBlock() != null)
            clone.setBlock(getBlock().clone());
        if(getSourceHint() != null)
            clone.setSourceHint(getSourceHint());
        if(getOption() != null)
            clone.setOption(getOption().clone());
        if (this.virtualGroup != null)
            clone.virtualGroup = this.virtualGroup.clone();

        this.copyMetadataState(clone);
        return clone;
    }

}
/* JavaCC - OriginalChecksum=f346ab2e5ff020b1b349d6d7fdcc5974 (do not edit this line) */
