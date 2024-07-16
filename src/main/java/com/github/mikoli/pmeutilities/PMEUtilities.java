package com.github.mikoli.pmeutilities;

import com.github.mikoli.pmeutilities.commands.CommandsHandler;
import com.github.mikoli.pmeutilities.customItems.CustomDurabilityUtil;
import com.github.mikoli.pmeutilities.customItems.RecipesRegister;
import com.github.mikoli.pmeutilities.listeners.*;
import com.github.mikoli.pmeutilities.otherMechanics.MiningCounter;

import com.github.mikoli.pmeutilities.otherMechanics.RingsManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PMEUtilities extends JavaPlugin {

    private final RingsManager ringsManager = new RingsManager(this);
    private final MiningCounter miningCounter = new MiningCounter();
    private final CommandsHandler commandsHandler = new CommandsHandler(this);
    private final RecipesRegister recipesRegister = new RecipesRegister(this);

    private static JavaPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        recipesRegister.registerRecipes();
        this.setCommandsExecutors();
        this.setEventsListeners();
        ringsManager.runTask();
    }

    @Override
    public void onDisable() {
        recipesRegister.unregisterRecipes();
    }

    public RingsManager getRingsManager() {
        return this.ringsManager;
    }

    public MiningCounter getMiningCounter() {
        return miningCounter;
    }

    private final PluginManager pluginManager = this.getServer().getPluginManager();
    private void setEventsListeners() {
        pluginManager.registerEvents(new SwapHandItemsListener(this), this);
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new InvClickListener(this), this);
        pluginManager.registerEvents(new ItemPickUpListener(this), this);
        pluginManager.registerEvents(new MiningMonitor(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(this), this);
        pluginManager.registerEvents(new PrepareItemCraftingListener(this), this);
        pluginManager.registerEvents(new ItemDamageListener(this), this);
        pluginManager.registerEvents(new PlayerDropItemListener(this), this);
        pluginManager.registerEvents(new PlayerInteractListener(this), this);
    }

    private void setCommandsExecutors() {
        this.getCommand("pmeutils").setExecutor(commandsHandler);
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
