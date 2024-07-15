package xyz.mlserver.mod.mlserverdbdmod.utils;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import xyz.mlserver.mod.mlserverdbdmod.MLServerDbDMod;

public class GuiConfigMLServerDbDMod extends GuiConfig {
    public GuiConfigMLServerDbDMod(GuiScreen parent) {
        super(parent,
                new ConfigElement(
                        MLServerDbDModConfigCore.cfg.getCategory(Configuration.CATEGORY_GENERAL))
                        .getChildElements(),
                MLServerDbDMod.MODID,
                false,
                false,
                "Play Magic Beans Any Way You Want");
        titleLine2 = MLServerDbDModConfigCore.cfg.getConfigFile().getAbsolutePath();
    }

    @Override
    public void initGui() {
        // You can add buttons and initialize fields here
        super.initGui();
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        // You can process any additional buttons you may have added here
        super.actionPerformed(button);
    }
}
