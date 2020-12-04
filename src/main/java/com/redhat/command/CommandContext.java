package com.redhat.command;

import com.redhat.common.var.Variables;

/**
 * Defines what a command will operate upon.
 *
 * @author sfloess
 */
public interface CommandContext {
    /**
     * Return our command variables.
     */
    Variables getVars();

    /**
     * Store the result of a pipeline run.
     *
     * @param result the result of a pipeline run.
     */
    public <T> void setResult(T result);

    /**
     * The result of a command run.
     */
    public <T> T getResult();

    /**
     * To stop a command running, set this to true.
     *
     * @param isDone
     */
    public void setIsDone(boolean isDone);

    /**
     * Is the command done executing?
     *
     * @param isDone
     */
    boolean isDone();
}
