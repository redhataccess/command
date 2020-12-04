package com.redhat.command.logging;

import com.redhat.command.CommandContext;

public class LogContextCommand<T extends CommandContext> extends AbstractLogCommand<T> {

    @Override
    protected String computeMsgValue(final T context) {
        return context.getVars().asMap().toString();
    }
}
