package xyz.mlserver.mod.mlserverdbdmod.listeners;

import net.minecraft.client.Minecraft;
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
            new ResourceLocation(MLServerDbDMod.MODID, "textures/dbdgui/icon.png"); // テクスチャの場所を指定
    private static final ResourceLocation WHITE_BORDER_TEXTURE =
            new ResourceLocation(MLServerDbDMod.MODID, "textures/dbdgui/unknown.png"); // 白い縁のテクスチャ

    @SubscribeEvent
    public static void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase != TickEvent.Phase.END || mc.currentScreen != null) return; // インベントリが開かれていないことを確認

        ScaledResolution scaledResolution = new ScaledResolution(mc);
        int screenWidth = scaledResolution.getScaledWidth();
        int screenHeight = scaledResolution.getScaledHeight();

        int iconSize = 32; // アイコンのサイズ
        int padding_right = 5; // アイコン間の余白
        int padding_bottom = 5; // アイコン間の余白

        int x, y, temp;

        int selectedSlotIndex = mc.player.inventory.currentItem;

        int slotIndex = 0;
        ItemStack itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - iconSize - padding_right;
            y = screenHeight - iconSize - padding_bottom;

            temp = iconSize / 2;

            x -= temp;
            y -= iconSize;

            drawIcon(x, y, iconSize, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 1;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - iconSize - padding_right;
            y = screenHeight - iconSize - padding_bottom;

            temp = iconSize / 2;

            y -= temp;

            drawIcon(x, y, iconSize, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 2;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - iconSize - padding_right;
            y = screenHeight - iconSize - padding_bottom;

            temp = iconSize / 2;

            x -= temp;

            drawIcon(x, y, iconSize, itemStack, slotIndex, selectedSlotIndex);
        }

        slotIndex = 3;
        itemStack = mc.player.inventory.getStackInSlot(slotIndex); // インベントリの0番目のスロットからアイテムを取得
        if (!itemStack.isEmpty()) { // アイテムが存在する場合
            // アイコンを描画する位置を計算
            x = screenWidth - iconSize - padding_right;
            y = screenHeight - iconSize - padding_bottom;

            temp = iconSize / 2;

            x -= iconSize;
            y -= temp;

            drawIcon(x, y, iconSize, itemStack, slotIndex, selectedSlotIndex);
        }
    }

    private static void drawIcon(int x, int y, int iconSize, ItemStack itemStack, int slotIndex, int selectedSlotIndex) {
        // ブレンドを有効にし、GUIの標準アイテムライティングを有効にします
        GlStateManager.enableBlend();
        RenderHelper.enableGUIStandardItemLighting();

         // 現在の行列を保存し、スケーリングを行います
        GlStateManager.pushMatrix();
        GlStateManager.scale(iconSize / 16.0F, iconSize / 16.0F, 1.0F);
         // スケーリングを考慮してアイテムをGUIに描画します
        mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int) (x / (iconSize / 16.0F)), (int) (y / (iconSize / 16.0F)));
         // 行列を元に戻します
        GlStateManager.popMatrix();

        // 標準アイテムライティングを無効にし、ブレンドを無効にします
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableBlend();

        // ホットバーが選択されている場合、白い枠を描画します
        if (slotIndex == selectedSlotIndex) {
            // スクリーンの幅と高さを取得します
            ScaledResolution scaledResolution = new ScaledResolution(mc);
            int screenWidth = scaledResolution.getScaledWidth();
            int screenHeight = scaledResolution.getScaledHeight();

            // 白い縁のテクスチャをバインドし、白い縁を描画します
            mc.getTextureManager().bindTexture(WHITE_BORDER_TEXTURE);
            mc.ingameGUI.drawTexturedModalRect(x, y, 0, 0, 16, 16);

            // テクスチャの回転を行います
            GlStateManager.pushMatrix();
            GlStateManager.scale(iconSize / 16.0F, iconSize / 16.0F, 1.0F);
            // 回転の中心を設定し、Z軸周りに45度回転します
            GlStateManager.translate(x + (float) screenWidth / 2, y + (float) screenHeight / 2, 0);
            GlStateManager.rotate(45, 0, 0, 1);
            GlStateManager.translate(-(x + (float) screenWidth / 2), -(y + (float) screenHeight / 2), 0);
            // 回転したテクスチャを描画します
            Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(x, y, 0, 0, (int) (x / (iconSize / 16.0F)), (int) (y / (iconSize / 16.0F)));
            GlStateManager.popMatrix();
            GlStateManager.enableBlend();
        }
    }

}
