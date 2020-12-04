package com.redhat.command;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import com.redhat.command.CommandException;
import com.redhat.common.markup.json.AbstractJsonBase;
import com.redhat.common.markup.json.JsonUtils;
import java.io.IOException;

/**
 * Abstract base class for a command.
 *
 * @author sfloess
 */
public abstract class AbstractCommand<T extends CommandContext> extends AbstractJsonBase implements Command<T> {
    /**
     * Our name.
     */
    private String name;

    /**
     * Our description.
     */
    private String description;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processUnmanagedProperty(final String name, final Object value) {
        logIfDebug("Unamanged property:  [", name, " : ", value, "]");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the name of the processor.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the processor.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    public Command<T> cloneSelf() {
        try {
            return JsonUtils.cloneObject(this);
        } catch (final IOException ioException) {
            throw new CommandException(ioException);
        }
    }
}
