package xyz.mlserver.mod.mlserverdbdmod.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.mlserver.mod.mlserverdbdmod.MLServerDbDMod;

import java.io.File;

public class MLServerDbDModConfigCore {
    public static final String GENERAL = "General";
    private static final String WhitelistMods = GENERAL + ".WhitelistMods";
    private static String whitelistModsJsonPath = "./config/mlservermodchecker/";
    private static String whitelistModsJsonFileName = "whitelist_mods.json";
    public static Configuration cfg;

    // config variables
    //  General
    //  Setting
    public static String default_language = "ja_JP";

    public static void loadConfig(FMLPreInitializationEvent event) {
        // net.minecraftforge.common.config.Configurationのインスタンスを生成する。
        cfg = new Configuration(event.getSuggestedConfigurationFile(), MLServerDbDMod.VERSION, true);
        // whitelistModsJsonPathが存在しない場合は作成する。
        if (!new File(whitelistModsJsonPath).exists()) {
            new File(whitelistModsJsonPath).mkdirs();
        }
//        whitelist_mods_gson = new Gson();
//        whitelist_mods_gson.toJson(whitelist_mods, List.class);
        // 初期化する。
        initConfig();
        // コンフィグファイルの内容を変数と同期させる。
        syncConfig();
    }


    /** コンフィグを初期化する。 */
    private static void initConfig() {
        // カテゴリのコメントなどを設定する。
        // General
        cfg.addCustomCategoryComment(GENERAL, "A settings of " + MLServerDbDMod.NAME + ".");
        cfg.setCategoryLanguageKey(GENERAL, "config.mlservermodchecker.config.general");
        // Whitelist Mods
        cfg.addCustomCategoryComment(WhitelistMods, "The settings of whitelist mods.");
        cfg.setCategoryLanguageKey(WhitelistMods, "config.mlservermodchecker.config.whitelistMods");
        cfg.setCategoryRequiresMcRestart(WhitelistMods, true);
    }


    /** コンフィグを同期する。 */
    public static void syncConfig() {
        // 各項目の設定値を反映させる。
        // General
        cfg.save();
    }
}
