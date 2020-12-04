package com.redhat.command.script.mvel.block;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import com.redhat.command.script.mvel.AbstractMvelCommand;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMvelBlockCommand<T extends CommandContext> extends AbstractMvelCommand<T> {
    private List<Command<T>> block;

    protected void ensureBlock() {
        if (null == getBlock()) {
            logError("Block cannot be missing!");

            throw new IllegalArgumentException("Missing block!");
        }
    }

    protected AbstractMvelBlockCommand() {
    }

    public void setBlock(final List<Command<T>> block) {
        this.block = block;
    }

    public List<Command<T>> getBlock() {
        return new ArrayList<>(block);
    }
}
