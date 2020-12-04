package com.redhat.command.script.mvel.block.condition.loop;

import com.redhat.command.CommandContext;
import com.redhat.command.script.mvel.block.condition.AbstractMvelConditionCommand;

/**
 * Acts as a basic while loop.
 *
 * @author sfloess
 */
public class WhileCommand<T extends CommandContext> extends AbstractMvelConditionCommand<T> {

    public WhileCommand() {
    }

    @Override
    public void accept(final T context) {
        ensureCondition();
        ensureBlock();

        while (!context.isDone() && isConditionMet(executeScriptStatement(context, getCondition()))) {
            doAcceptBlock(context, getBlock());
        }
    }
}
