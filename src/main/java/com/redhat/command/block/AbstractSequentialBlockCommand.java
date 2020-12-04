package com.redhat.command.block;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;

public abstract class AbstractSequentialBlockCommand<T extends CommandContext> extends AbstractBlockCommand<T> {
    protected AbstractSequentialBlockCommand() {
    }

    @Override
    public void accept(final T context) {
        for (final Command command : getBlock()) {
            if (context.isDone()) {
                logInfo("Context denoteing processing complete - returning from block processing");

                return;
            }

            command.lifeCycleAccept(context);
        }
    }
}
