package com.redhat.command.logging;

import com.redhat.command.CommandContext;
import com.redhat.command.AbstractCommand;

/**
 * Abstract base class if we want to log something as a message plus the thing
 * to log. As an example, we want to log "Here is the context" and the
 * pipeline context.
 *
 * @author sfloess
 */
public abstract class AbstractLogCommand<T extends CommandContext> extends AbstractCommand<T> {

    private String msg;

    protected abstract String computeMsgValue(T context);

    protected AbstractLogCommand() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    @Override
    public void accept(final T context) {
        logInfo(null == getMsg() ? "" : msg, ": ", computeMsgValue(context));
    }
}
