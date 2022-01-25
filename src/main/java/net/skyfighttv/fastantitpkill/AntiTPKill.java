package net.skyfighttv.fastantitpkill;

import net.skyfighttv.fastantitpkill.utils.file.FileManager;
import net.skyfighttv.fastantitpkill.utils.file.Files;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public final class AntiTPKill extends BukkitRunnable {
    public final static HashMap<Player, Long> tpTime = new HashMap<>();
    private final int TIME;

    {
        YamlConfiguration config = FileManager.getValues().get(Files.Config);
        this.TIME = config.getInt("time");
    }

    @Override
    public void run() {
        if (!tpTime.isEmpty()) {
            new HashMap<>(tpTime).forEach((player, aLong) -> {
                if (((System.currentTimeMillis()/1000) - aLong) >= this.TIME)
                    tpTime.remove(player);
            });
        }
    }
}
