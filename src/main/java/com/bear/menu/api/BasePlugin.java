package com.bear.menu.api;

/**
 * 基本插件的实现
 */
public class BasePlugin implements Plugin {

    public String rootcommands = null;


    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getRootCommands() {
        return rootcommands;
    }
}
