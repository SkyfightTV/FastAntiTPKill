package net.skyfighttv.fastantitpkill;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    {
        instance = this;
    }

    @Override
    public void onEnable() {
        new AntiTPKill().runTaskTimerAsynchronously(this, 40, 40);

        getServer().getPluginManager().registerEvents(new AntiTPKillListeners(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
