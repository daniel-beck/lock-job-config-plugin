package org.jenkinsci.plugins.lockjobconfig;

import hudson.Extension;
import hudson.Util;
import hudson.init.Initializer;
import hudson.model.Items;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.DoNotUse;

import java.util.Arrays;
import java.util.Collection;

public class ConfigLockJobProperty extends JobProperty<Job<?, ?>> {
    private String message;
    private String title;

    @Override
    public Collection<?> getJobOverrides() {
        return Arrays.asList(new Object[] {
                this
        });
    }

    @Initializer
    @Restricted(DoNotUse.class)
    public static void defineAliases() {
        Items.XSTREAM.alias("config-lock", ConfigLockJobProperty.class);
    }

    @Restricted(DoNotUse.class)
    public Job getOwner() {
        return owner;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (Util.fixEmptyAndTrim(message) == null) {
            return Messages.defaultMessage();
        }
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        if (Util.fixEmptyAndTrim(title) == null) {
            return Messages.defaultTitle();
        }
        return title;
    }

    @Extension
    public static class ConfigLockJobPropertyDescriptor extends JobPropertyDescriptor {
        @Override
        public String getDisplayName() {
            return "Lock Job Configuration";
        }
    }
}
