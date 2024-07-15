package xyz.mlserver.mod.mlserverdbdmod.listeners;

import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.mlserver.mod.mlserverdbdmod.utils.GuiConfigMLServerDbDMod;

public class ForgeGuiOpenListener {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(GuiOpenEvent event) {
        if (event.getGui() instanceof GuiIngameMenu) {
            System.out.println("GuiOpenEvent for GuiIngameModOptions");
            event.setGui(new GuiConfigMLServerDbDMod(null));
        }
    }
}
