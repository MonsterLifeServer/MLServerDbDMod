package xyz.mlserver.mod.mlserverdbdmod.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import xyz.mlserver.mod.mlserverdbdmod.MLServerDbDMod;


@Mod.EventBusSubscriber(modid = MLServerDbDMod.MODID, value = Side.CLIENT)
public class ForgeInventoryItemRendererListener {

    public ForgeInventoryItemRendererListener() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/icon.png"); // テクスチャの場所を指定
    private static final ResourceLocation WHITE_BORDER_TEXTURE =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/unknown.png"); // 白い縁のテクスチャ

    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_100 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_0.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_87_5 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_1.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_75 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_2.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_62_5 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_3.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_50 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_4.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_37_5 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_5.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_25 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_6.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_12_5 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_7.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE_0 =
            new ResourceLocation(MLServerDbDMod.MODID + ":textures/dbdgui/item_progressbar/item_progress_bar_8.png");
    private static final ResourceLocation ITEM_PROGRESS_BAR_TEXTURE =
            new ResourceLocation(MLServerDbDMod.MODID,  "textures/gui/item_progress_bar.png");

    private static final int PARK_SIZE = 32; // アイコンのサイズ
    private static final int ITEM_SIZE = 28; // アイコンのサイズ
    private static final int ADDON_SIZE = 14; // アイコンのサイズ
    private static final int PADDING_RIGHT = 5;
    private static final int PADDING_BOTTOM = 5;
    private static final int PADDING_LEFT = 5; 
    
    
    @SubscribeEvent
    public static void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase != TickEvent.Phase.END || mc.currentScreen != null) return; // インベントリが開かれていないことを確認

        ScaledResolution scaledResolution = new ScaledResolution(mc);
        int screenWidth = scaledResolution.getScaledWidth();
        int screenHeight = scaledResolution.getScaledHeight();

        int x, y, temp;

        int selectedSlotIndex = mc.player.inventory.currentItem;

        int slotIndex = 0;
        ItemStack itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - PARK_SIZE - PADDING_RIGHT;
            y = screenHeight - PARK_SIZE - PADDING_BOTTOM;

            temp = PARK_SIZE / 2;

            x -= temp;
            y -= PARK_SIZE;

            drawIcon(x, y, PARK_SIZE, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 1;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - PARK_SIZE - PADDING_RIGHT;
            y = screenHeight - PARK_SIZE - PADDING_BOTTOM;

            temp = PARK_SIZE / 2;

            y -= temp;

            drawIcon(x, y, PARK_SIZE, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 2;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - PARK_SIZE - PADDING_RIGHT;
            y = screenHeight - PARK_SIZE - PADDING_BOTTOM;

            temp = PARK_SIZE / 2;

            x -= temp;

            drawIcon(x, y, PARK_SIZE, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 3;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - PARK_SIZE - PADDING_RIGHT;
            y = screenHeight - PARK_SIZE - PADDING_BOTTOM;

            temp = PARK_SIZE / 2;

            x -= PARK_SIZE;
            y -= temp;

            drawIcon(x, y, PARK_SIZE, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 8;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = PADDING_LEFT + (ITEM_SIZE / 2) - (ADDON_SIZE / 2);
            y = screenHeight - (PADDING_BOTTOM + ITEM_SIZE);

            drawIcon(x, y, ITEM_SIZE, itemStack, slotIndex, selectedSlotIndex);

            mc.getRenderManager().getFontRenderer().drawString("Your text", 100, 100, 0xFFFFFF);
        }

        slotIndex = 35;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex);
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = PADDING_LEFT + ITEM_SIZE + (ADDON_SIZE / 2);
            y = screenHeight - (PADDING_BOTTOM + ADDON_SIZE);

            drawIcon(x, y, ADDON_SIZE, itemStack, slotIndex, -1);
        }

        slotIndex = 26;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex);
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = PADDING_LEFT + ITEM_SIZE + (ADDON_SIZE / 2);
            y = screenHeight - (PADDING_BOTTOM + ADDON_SIZE + ADDON_SIZE);

            drawIcon(x, y, ADDON_SIZE, itemStack, slotIndex, -1);
        }
    }

    private static void drawIcon(int x, int y, int icon_size, ItemStack itemStack, int slotIndex, int selectedSlotIndex) {
        // ブレンドを有効にし、GUIの標準アイテムライティングを有効にします
        GlStateManager.enableBlend();
        RenderHelper.enableGUIStandardItemLighting();

         // 現在の行列を保存し、スケーリングを行います
        GlStateManager.pushMatrix();
        if (slotIndex == selectedSlotIndex) icon_size += 2;
        GlStateManager.scale(icon_size / 16.0F, icon_size / 16.0F, 1.0F);
         // スケーリングを考慮してアイテムをGUIに描画します
        mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int) (x / (icon_size / 16.0F)), (int) (y / (icon_size / 16.0F)));
         // 行列を元に戻します
        GlStateManager.popMatrix();

        // 標準アイテムライティングを無効にし、ブレンドを無効にします
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableBlend();
    }

}
