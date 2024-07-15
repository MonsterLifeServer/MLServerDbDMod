package xyz.mlserver.mod.mlserverdbdmod.listeners;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.mlserver.mod.mlserverdbdmod.MLServerDbDMod;
import xyz.mlserver.mod.mlserverdbdmod.utils.MLServerDbDModConfigCore;

public class ForgeConfigChangeListener {
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        // コンフィグが変更された時に呼ばれる。
        if (event.getModID().equals(MLServerDbDMod.MODID)) {
            MLServerDbDModConfigCore.syncConfig();
        }
    }
}
