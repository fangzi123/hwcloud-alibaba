package com.wdhw.api.controller;

import java.util.Map;

public interface ApiProcessor {
    public String getApiType();
    public String process(Map Params);
}
