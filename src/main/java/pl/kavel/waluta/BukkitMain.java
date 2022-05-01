package pl.kavel.waluta;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kavel.waluta.handler.PlayerJoinHandler;
import pl.kavel.waluta.handler.PlayerMoveHandler;
import pl.kavel.waluta.service.UserService;

import java.util.Arrays;

public final class BukkitMain extends JavaPlugin {

    private static BukkitMain instance;
    private UserService userService;

    public static BukkitMain getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        this.userService = new UserService();
    }

    @Override
    public void onEnable() {
        Listener[] listeners = new Listener[]{

            new PlayerMoveHandler(),
            new PlayerJoinHandler(),
        };

        getCommand("dodaj").setExecutor(new DodajCommand());

        Arrays.stream(listeners).forEach(handler -> Bukkit.getPluginManager().registerEvents(handler, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public UserService getUserService() {
        return userService;
    }
}
