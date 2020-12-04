package com.redhat.command.script.mvel.block.condition.loop;

import com.redhat.command.CommandContext;
import com.redhat.command.script.mvel.block.condition.AbstractMvelConditionCommand;

/**
 * Acts as a basic do-while loop.
 *
 * @author sfloess
 */
public class DoWhileCommand<T extends CommandContext> extends AbstractMvelConditionCommand<T> {

    public DoWhileCommand() {
    }

    public String getWhile() {
        return super.getCondition();
    }

    public void setWhile(final String condition) {
        super.setCondition(condition);
    }

    @Override
    public void accept(final T context) {
        ensureCondition("Missing while element!");
        ensureBlock();

        do {
            logInfo("Vars:      ", context.getVars().asMap());

            doAcceptBlock(context, getBlock());
        } while (!context.isDone() && isConditionMet(executeScriptStatement(context, getWhile())));
    }
}
