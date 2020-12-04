package com.redhat.command.script.mvel.block.condition;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Acts as a basic if/else statement. While silly the then block can be empty
 *
 * @author sfloess
 */
public class IfCommand<T extends CommandContext> extends AbstractMvelConditionCommand<T> {
    private List<Command<T>> elseBlock;

    T runBlock(final T context, final List<Command<T>> blockToRun, final String blockType) {
        logInfo("Exectuting [", blockType, "]");

        doAcceptBlock(context, blockToRun);

        return context;
    }

    T runBlock(final T context, final boolean testCondition) {
        return runBlock(context, testCondition ? getThen() : getElse(), testCondition ? "if" : "else");
    }

    public IfCommand() {
        elseBlock = new ArrayList<>();
    }

    public void setThen(final List<Command<T>> thenBlock) {
        setBlock(thenBlock);
    }

    public List<Command<T>> getThen() {
        return getBlock();
    }

    public void setElse(final List<Command<T>> elseBlock) {
        this.elseBlock = elseBlock;
    }

    public List<Command<T>> getElse() {
        return elseBlock;
    }

    @Override
    public void accept(final T context) {
        ensureCondition("Missing 'then' block for if element!");

        runBlock(context, isConditionMet(executeScriptStatement(context, getCondition())));
    }
}
