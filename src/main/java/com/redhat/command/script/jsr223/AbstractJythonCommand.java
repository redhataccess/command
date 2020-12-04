package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;

/**
 * Base class for executing a Jython script.
 *
 * @author sfloess
 */
public abstract class AbstractJythonCommand<T extends CommandContext> extends AbstractJsr223ScriptCommand<T> {
    /**
     * Default constructor.
     */
    protected AbstractJythonCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getScriptShortName() {
        return "python";
    }
}
