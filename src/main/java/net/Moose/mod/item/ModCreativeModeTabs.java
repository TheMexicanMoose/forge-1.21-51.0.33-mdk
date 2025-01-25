package net.Moose.mod.item;

import net.Moose.mod.TutorialMod;
import net.Moose.mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.MossBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NOMINURITE_ITEMS_TAB = CREATIVE_MODE_TAB.register("nominurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModsItems.NOMINURITE.get()))
                    .title(Component.translatable("creativetab.moosestutorialmod.nominurite_items"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModsItems.NOMINURITE.get());
                        output.accept(ModsItems.RAW_NOMINURITE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> NOMINURITE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("nominurite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.NOMINURITE_BLOCK.get()))
                    .withTabsBefore(NOMINURITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.moosestutorialmod.nominurite_blocks"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModBlocks.NOMINURITE_BLOCK.get());
                        output.accept(ModBlocks.NOMINURITE_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
