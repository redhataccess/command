package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;

/**
 * Base class for executing a Groovy script.
 *
 * @author sfloess
 */
public abstract class AbstractGroovyCommand<T extends CommandContext> extends AbstractJsr223ScriptCommand<T> {
    /**
     * Default constructor.
     */
    protected AbstractGroovyCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getScriptShortName() {
        return "groovy";
    }
}
