package com.redhat.command.script.mvel;

import com.redhat.command.CommandContext;

/**
 * Allows for defining variables in a dynamic way.
 * <p>
 * As an example: { "var1": 10, "var2": 20, "var3": "var1 + var2" }
 *
 * @author sfloess
 */
public class DynamicVarCommand<T extends CommandContext> extends AbstractMvelCommand<T> {

    public DynamicVarCommand() {
    }

    @Override
    public void accept(final T context) {
        logIfDebug("Processing MVEL dynamic variables using: ", getAdditionalProperties());

        for (final String key : getOrderedAdditionalProperties()) {
            logInfo("Key:  ", key);
            logInfo("Pipeline vars:  ", context.getVars().asMap());
            context.getVars().set(key, executeScriptStatement(context, getAdditionalProperties().get(key).toString()));
        }
    }
}
