package com.redhat.command.script;

import com.redhat.command.AbstractCommand;
import com.redhat.command.CommandContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for doing Script related work.
 *
 * @author sfloess
 */
public abstract class AbstractScriptCommand<T extends CommandContext> extends AbstractCommand<T> {
    public static final String CONTEXT_SCRIPT_VAR = "context";

    /**
     * Taking the result, we lof both the script statement and the result.
     */
    Object logAndReturnScriptResult(final Object result, final String scriptStatement) {
        logIfDebug("Result of executing [", scriptStatement, "] = [", result, "]");

        return result;
    }

    /**
     * Override if you want to do any special processing with the result.
     */
    protected Object processScriptResult(final T context, final Object result) {
        return result;
    }

    /**
     * Override if you want to use different variables than context, queryParams
     * and all stageVars...
     */
    protected Map populateScriptVars(final T context, final Map scriptVars) {
        scriptVars.put(CONTEXT_SCRIPT_VAR, context);

        scriptVars.putAll(context.getVars().asMap());

        return scriptVars;
    }

    /**
     * Override if you want to take care of creating and populating the MVEL
     * variables.
     */
    protected Map createScriptVars(final T context) {
        return populateScriptVars(context, new HashMap<>());
    }

    /**
     * Execute the script statement. scriptVars will have all the variables for
     * your script's execution environment.
     */
    protected abstract Object executeScriptStatement(final T context, final Map scriptVars, final String scriptStatement);

    /**
     * Will execute script statement and return the result of execution.
     */
    protected Object executeScriptStatement(final T context, final String scriptStatement) {
        logIfDebug("Script statement to execute:  [", scriptStatement, "]");

        return logAndReturnScriptResult(processScriptResult(context, executeScriptStatement(context, createScriptVars(context), scriptStatement)), scriptStatement);
    }

    /**
     * Default constructor.
     */
    protected AbstractScriptCommand() {
    }
}
