package com.redhat.command.factory;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sfloess
 */
public class CommandFactory<T extends CommandContext> {
    private final Map<String, Class<Command<T>>> defs;

    private Map<String, Class<Command<T>>> getDefs() {
        return defs;
    }

    public CommandFactory() {
        defs = new HashMap<>();
    }

    public void defineCommand(final String name, final Class<Command<T>> command) {
        getDefs().put(name, command);
    }
}
