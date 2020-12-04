package com.redhat.command.script.mvel;

import com.redhat.command.CommandContext;
import com.redhat.command.script.AbstractScriptCommand;
import java.util.Map;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;

/**
 * Base class for doing MVEL related work.
 *
 * @author sfloess
 */
public abstract class AbstractMvelCommand<T extends CommandContext> extends AbstractScriptCommand<T> {

    protected AbstractMvelCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object executeScriptStatement(final T context, final Map scriptVars, final String scriptStatement) {
        return MVEL.executeExpression(MVEL.compileExpression(scriptStatement, new ParserContext()), scriptVars);
    }
}
