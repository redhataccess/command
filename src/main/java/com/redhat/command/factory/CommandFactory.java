package com.redhat.command.factory;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import com.redhat.common.markup.MarkupBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sfloess
 */
public class CommandFactory<T extends CommandContext> {
    private final Map<String, Command<T>> defs;

    private Map<String, Command<T>> getDefs() {
        return defs;
    }

    public CommandFactory() {
        defs = new HashMap<>();
    }

    public void defineCommandFromJson(final String name, final Class<Command<T>> command, final String json) {
        getDefs().put(name, MarkupBuilder.JSON.asType(json, command));
    }

    public void defineCommandFromXml(final String name, final Class<Command<T>> command, final String json) {
        getDefs().put(name, MarkupBuilder.XML.asType(json, command));
    }

    public void defineCommandFromYaml(final String name, final Class<Command<T>> command, final String json) {
        getDefs().put(name, MarkupBuilder.YAML.asType(json, command));
    }
}
