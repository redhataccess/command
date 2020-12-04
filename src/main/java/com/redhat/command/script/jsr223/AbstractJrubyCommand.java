package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;

/**
 * Base class for executing a Jruby script.
 *
 * @author sfloess
 */
public abstract class AbstractJrubyCommand<T extends CommandContext> extends AbstractJsr223ScriptCommand<T> {
    /**
     * Default constructor.
     */
    protected AbstractJrubyCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getScriptShortName() {
        return "ruby";
    }
}
