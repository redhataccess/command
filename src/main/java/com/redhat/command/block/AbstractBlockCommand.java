package com.redhat.command.block;

import com.redhat.command.AbstractCommand;
import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import java.util.List;

public abstract class AbstractBlockCommand<T extends CommandContext> extends AbstractCommand<T> {
    private List<Command<T>> block;

    protected AbstractBlockCommand() {
    }

    public List<Command<T>> getBlock() {
        return block;
    }

    public void setBlock(final List<Command<T>> block) {
        this.block = block;
    }
}
