package org.drozda.util;

public final class EnvVarsImpl implements EnvVars {

    @Override
    public String getEnv(String varName) {
        if (varName == null) {
            return null;
        }
        return System.getenv(varName);
    }
}
