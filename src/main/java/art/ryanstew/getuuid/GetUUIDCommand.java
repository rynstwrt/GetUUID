package art.ryanstew.getuuid;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class GetUUIDCommand implements CommandExecutor
{

    private static final String RELOAD_PERMISSION = "getuuid.reload";

    private final GetUUID plugin;


    public GetUUIDCommand(GetUUID plugin)
    {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args)
    {
        if (args.length != 1)
        {
            String commandArguments = sender.hasPermission(RELOAD_PERMISSION) ? "<player name/reload>" : "<player name>";
            plugin.sendFormattedMessage(sender, String.format("&cIncorrect usage! Usage: /getuuid %s.", commandArguments), true);
            return true;
        }

        if (args[0].equalsIgnoreCase("reload") && sender.hasPermission(RELOAD_PERMISSION))
        {
            plugin.reloadConfig();
            plugin.saveConfig();
            plugin.sendFormattedMessage(sender, "&aSuccessfully reloaded the config!", true);
            return true;
        }

        OfflinePlayer offlinePlayer = plugin.getServer().getOfflinePlayer(args[0]);
        plugin.sendFormattedMessage(sender, String.format("&7That player's UUID is &a%s&7!", offlinePlayer.getUniqueId()), true);
        return true;
    }
}
