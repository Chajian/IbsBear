package com.bear.menu.api;

/**
 * 插件
 */
public interface Plugin{

    public void  onEnable();

    public void onDisable();

    public String getName();

    public String getRootCommands();

}
