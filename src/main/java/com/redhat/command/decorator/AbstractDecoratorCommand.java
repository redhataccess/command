package com.redhat.command.decorator;

import com.redhat.command.Command;
import com.redhat.command.CommandContext;
import com.redhat.command.AbstractCommand;

public abstract class AbstractDecoratorCommand<T extends CommandContext> extends AbstractCommand<T> {
    private Command<T> decoratee;

    public Command<T> setDecoratee(final String name, final Command<T> decoratee) {
        this.decoratee = decoratee;

        return decoratee;
    }

    public Command<T> getDecoratee() {
        return decoratee;
    }

    protected AbstractDecoratorCommand() {
    }
}
