package com.redhat.command;

import com.redhat.common.function.ExtendedConsumer;

/**
 * Interface for classes that can process an object.
 *
 * @param <T> the type to process.
 *
 * @author sfloess
 */
public interface Command<T extends CommandContext> extends ExtendedConsumer<T> {
    /**
     * Will clone self.
     */
    default Command<T> cloneSelf() {
        return this;
    }

    /**
     * Performs the complete lifecycle on a clone: pre/accept/post.
     */
    default void lifeCycleAccept(final T context) {
        final Command command = cloneSelf();

        command.preApply(context);

        try {
            command.accept(context);
        } catch (final Exception exception) {
            command.postApplyFailure(context, exception);

            throw new CommandException(exception);
        }

        command.postApply(context);
    }
}
