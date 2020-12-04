package com.redhat.command.decorator;

import com.redhat.command.CommandContext;

/**
 * This step simply ignores processing anything.
 *
 * @author sfloess
 */
public class SkipCommand<T extends CommandContext> extends AbstractDecoratorCommand<T> {

    public SkipCommand() {
    }

    @Override
    public void accept(final T context) {
        logInfo("Skipping step [", getName(), "] -> [", super.getDecoratee(), "]");
    }
}
