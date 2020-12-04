package com.redhat.command.block;

import com.redhat.command.CommandContext;
import com.redhat.common.utils.Strings;

public class LoopCommand<T extends CommandContext> extends AbstractSequentialBlockCommand<T> {

    private String var;
    private int times;

    int ensureTimes(final int times) {
        if (times < 0) {
            logError("Cannot set a negative number of times!");
            throw new IllegalArgumentException("Cannot use a negative number of times!");
        }

        return times;
    }

    public LoopCommand() {
        this.var = Strings.generateUniqueStringForPrefix("loop");
        this.times = 0;
    }

    public String getVar() {
        return var;
    }

    public void setVar(final String var) {
        this.var = var;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(final int times) {
        this.times = ensureTimes(times);
    }

    @Override
    public void accept(final T context) {
        logInfo("Executing for [", getTimes(), "] iterations");

        for (int index = 0; index < getTimes() && !context.isDone(); index++) {
            context.getVars().set(getVar(), index);

            super.accept(context);
        }
    }
}
