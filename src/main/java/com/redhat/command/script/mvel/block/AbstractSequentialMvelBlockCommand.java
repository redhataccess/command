package com.redhat.command.script.mvel.block;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import java.util.List;

public abstract class AbstractSequentialMvelBlockCommand<T extends CommandContext> extends AbstractMvelBlockCommand<T> {
    protected AbstractSequentialMvelBlockCommand() {
    }

    protected void doAcceptBlock(final T context, final List<Command<T>> block) {
        for (final Command command : getBlock()) {
            if (context.isDone()) {
                logInfo("Context denoteing processing complete - returning from block processing");

                return;
            }

            command.lifeCycleAccept(context);
        }
    }

    @Override
    public void accept(final T context) {
        doAcceptBlock(context, getBlock());
    }
}
