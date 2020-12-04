package com.redhat.command.logging;

import com.redhat.command.CommandContext;
import com.redhat.command.AbstractCommand;

/**
 * This class is a little different than the other AbstractLogStep subclasses.
 * Here we simply want to log a message itself with no computation.
 *
 * @author sfloess
 */
public class LogMsgCommand<T extends CommandContext> extends AbstractCommand<T> {

    private String msg;

    public LogMsgCommand() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    @Override
    public void accept(final T context) {
        logInfo("msg [", getMsg(), "]");
    }
}
