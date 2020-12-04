package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;

/**
 * Base class for executing a JSR compatible script.
 *
 * @author sfloess
 */
public abstract class AbstractJavascriptCommand<T extends CommandContext> extends AbstractJsr223ScriptCommand<T> {
    /**
     * Default constructor.
     */
    protected AbstractJavascriptCommand() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getScriptShortName() {
        return "nashorn";
    }
}
