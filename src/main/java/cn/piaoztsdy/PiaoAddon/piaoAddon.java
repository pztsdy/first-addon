package cn.piaoztsdy.PiaoAddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class piaoAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // 从 config.yml 中读取插件配置
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // 你可以在这里添加自动更新功能
        }

        /*
         * 1. 创建分类
         * 分类的显示物品将使用以下物品
         */
        ItemStack itemGroupItem = new CustomItemStack(Material.DIAMOND, "&4PiaoAddon");

        // 给你的分类提供一个独一无二的ID
        NamespacedKey itemGroupId = new NamespacedKey(this, "addon_category");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         * 2. 创建一个 SlimefunItemStack
         * 这个类是 ItemStack 的扩展，拥有多个构造函数
         * 重要：每个物品都得有一个独一无二的ID
         */
        SlimefunItemStack slimefunItem = new SlimefunItemStack("COOL_DIAMOND", Material.DIAMOND, "&4炫酷的钻石", "&c+20% 炫酷");
        SlimefunItemStack slimefunItem2 = new SlimefunItemStack("GREAT_DIAMOND_SWORD", Material.DIAMOND_SWORD, "&4炫酷的钻石剑", "&c+20% 炫酷\n&7+40% 强势");

        /*
         * 3. 创建配方
         * 这个配方是一个拥有9个ItemStack的数组。
         * 它代表了一个3x3的有序合成配方。
         * 该配方所需的机器将在后面通过RecipeType指定。
         */
        ItemStack[] recipe = { new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.DIAMOND), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD) };
        ItemStack[] recipe2 = { new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND), null, new ItemStack(Material.DIAMOND_SWORD), null, new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND), new ItemStack(Material.DIAMOND) };

        /*
         * 4. 注册物品
         * 现在，你只需要注册物品
         * RecipeType.ENHANCED_CRAFTING_TABLE 代表
         * 该物品将在增强型工作台中合成。
         * 来自粘液科技本体的配方类型将会自动将配方添加到对应的机器中。
         */
        // 注册炫酷的钻石
        SlimefunItem item = new SlimefunItem(itemGroup, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);
        // 注册炫酷的钻石剑
        SlimefunItem itemSword = new SlimefunItem(itemGroup, slimefunItem2, RecipeType.ENHANCED_CRAFTING_TABLE, recipe2);
        itemSword.register(this);
    }

    @Override
    public void onDisable() {
        // 禁用插件的逻辑...
    }

    @Override
    public String getBugTrackerURL() {
        // 你可以在这里返回你的问题追踪器的网址，而不是 null
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * 你需要返回对你插件的引用。
         * 如果这是你插件的主类，只需要返回 "this" 即可。
         */
        return this;
    }

}
