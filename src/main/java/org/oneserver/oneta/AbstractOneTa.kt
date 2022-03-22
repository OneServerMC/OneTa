package org.oneserver.oneta

import net.md_5.bungee.api.plugin.Command
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin

abstract class AbstractOneTa : Plugin()
{
    /**
     * イベントリスナーを登録
     *
     * @param listeners Listenerを実装しているクラス
     */
    protected fun registerListeners(vararg listeners: Listener)
    {
        listeners.forEach { proxy.pluginManager.registerListener(this, it) }
    }

    /**
     * コマンドを登録
     *
     * @param commands Commandを継承しているクラス
     */
    protected fun registerCommands(vararg commands: Command)
    {
        commands.forEach { proxy.pluginManager.registerCommand(this, it) }
    }
}