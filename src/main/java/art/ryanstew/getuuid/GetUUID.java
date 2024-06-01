package art.ryanstew.getuuid;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GetUUID extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        saveConfig();

        Objects.requireNonNull(getCommand("getuuid")).setExecutor(new GetUUIDCommand(this));
    }


    @Override
    public void onDisable() { }


    public void sendFormattedMessage(CommandSender sender, String message, boolean prefixed)
    {
        if (prefixed)
            message = String.format("%s %s", getConfig().getString("prefix"), message);

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
