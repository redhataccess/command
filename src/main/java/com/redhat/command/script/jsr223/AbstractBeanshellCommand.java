package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;

/**
 * Base class for executing a Beanshell script.
 *
 * @author sfloess
 */
public abstract class AbstractBeanshellCommand<T extends CommandContext> extends AbstractJsr223ScriptCommand<T> {
    /**
     * Default constructor.
     */
    protected AbstractBeanshellCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getScriptShortName() {
        return "beanshell";
    }
}
