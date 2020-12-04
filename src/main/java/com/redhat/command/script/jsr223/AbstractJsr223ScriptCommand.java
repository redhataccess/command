package com.redhat.command.script.jsr223;

import com.redhat.command.CommandContext;
import com.redhat.command.CommandException;
import com.redhat.command.script.AbstractScriptCommand;
import java.util.Map;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Base class for executing a JSR compatible script.
 *
 * @author sfloess
 */
public abstract class AbstractJsr223ScriptCommand<T extends CommandContext> extends AbstractScriptCommand<T> {

    /**
     * Sets all variables from scriptVars into scriptContext.
     */
    void setVars(final Map scriptVars, final ScriptContext scriptContext) {
        scriptVars.forEach((k, v) -> scriptContext.setAttribute(k.toString(), v, ScriptContext.ENGINE_SCOPE));
    }

    /**
     * Sets all the variables from scriptVars into the script engine.
     */
    void setVars(final Map scriptVars, final ScriptEngine retVal) {
        setVars(scriptVars, retVal.getContext());
    }

    /**
     * Executes the script statement using script engine.
     */
    Object executeScriptStatement(final T context, final Map scriptVars, final ScriptEngine scriptEngine, final String scriptStatement) {
        setVars(scriptVars, scriptEngine);

        try {
            return scriptEngine.eval(scriptStatement);
        } catch (final Exception exception) {
            logError(exception, "Problem executing [", scriptStatement, "]");

            throw new CommandException("Problem executing [" + scriptStatement + "]", exception);
        }
    }

    /**
     * Will execute a JSR supported script statement and return the result of
     * execution.
     */
    protected Object executeScriptStatement(final T context, final Map scriptVars, final String scriptStatement) {
        return executeScriptStatement(context, scriptVars, new ScriptEngineManager().getEngineByName(getScriptShortName()), scriptStatement);
    }

    /**
     * Return the short name of the scriping language. As an example JavaScript,
     * Beanshell, Groovy, etc.
     */
    protected abstract String getScriptShortName();

    /**
     * Default constructor.
     */
    protected AbstractJsr223ScriptCommand() {
    }
}
