package com.redhat.command;

import com.redhat.common.function.ExtendedConsumerException;

/**
 *
 * @author sfloess
 */
public class CommandException extends ExtendedConsumerException {
    public CommandException() {
        super();
    }

    public CommandException(final String message) {
        super(message);
    }

    public CommandException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommandException(final Throwable cause) {
        super(cause);
    }
}
