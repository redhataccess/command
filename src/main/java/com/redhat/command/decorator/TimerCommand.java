package com.redhat.command.decorator;

import com.redhat.command.CommandContext;
import com.redhat.common.utils.Strings;

public class TimerCommand<T extends CommandContext> extends AbstractDecoratorCommand<T> {

    private String var;

    void setVar(final T context, final long totalTime) {
        context.getVars().set(getVar(), totalTime);

        logIfDebug("timer [", getVar(), "] -> [", totalTime, "]");
    }

    void setVar(final T context, final long startTime, final long endTime) {
        setVar(context, endTime - startTime);
    }

    void accept(final T context, final long startTime) {
        getDecoratee().lifeCycleAccept(context);

        setVar(context, startTime, System.currentTimeMillis());
    }

    public TimerCommand() {
        this.var = Strings.generateUniqueStringForPrefix("timer");
    }

    public String getVar() {
        return var;
    }

    public void setVar(final String var) {
        this.var = var;
    }

    @Override
    public void accept(final T context) {
        accept(context, System.currentTimeMillis());
    }
}
