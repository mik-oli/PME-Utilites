package com.github.mikoli.pmeutilities;

import com.github.mikoli.pmeutilities.customCraftings.CustomRecipes;
import com.github.mikoli.pmeutilities.listeners.*;
import com.github.mikoli.pmeutilities.otherMechanics.MiningCounter;
import com.github.mikoli.pmeutilities.ringsMechanic.RingsManager;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PMEUtilities extends JavaPlugin {

    private final RingsManager ringsManager = new RingsManager(this);
    private final CustomRecipes customRecipes = new CustomRecipes(this);
    private final MiningCounter miningCounter = new MiningCounter();

    @Override
    public void onEnable() {
        this.setEventsListeners();
        ringsManager.runTask();
        customRecipes.registerArmorsCrafting();
    }

    @Override
    public void onDisable() {

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
        pluginManager.registerEvents(new InvDragListener(this), this);
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new InvClickListener(this), this);
        pluginManager.registerEvents(new ItemPickUpListener(this), this);
        pluginManager.registerEvents(new MiningMonitor(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(this), this);
        pluginManager.registerEvents(new PrepareItemCraftingListener(this), this);

    }
}
