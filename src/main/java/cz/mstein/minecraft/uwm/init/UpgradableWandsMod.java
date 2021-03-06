package cz.mstein.minecraft.uwm.init;

import cz.mstein.minecraft.uwm.blocks.UWMBlocks;
import cz.mstein.minecraft.uwm.items.UWMItems;
import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import cz.mstein.minecraft.uwm.proxies.IProxy;
import cz.mstein.minecraft.uwm.recipies.UWMSmelting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.RegistryBuilder;

@Mod(modid=UWMReference.MODID, name=UWMReference.MODNAME, version=UWMReference.VERSION, acceptedMinecraftVersions=UWMReference.ACCEPTED_MINECRAFT_VERSIONS)
@Mod.EventBusSubscriber(modid=UWMReference.MODID)
public class UpgradableWandsMod {
	
	@SidedProxy(modId = UWMReference.MODID, clientSide = "cz.mstein.minecraft.uwm.proxies.ClientProxy", serverSide = "cz.mstein.minecraft.uwm.proxies.ServerProxy")
	public static IProxy proxy;
	
	@Instance
	public static UpgradableWandsMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":preInit");
		UWMItems.init();
		UWMBlocks.init();
		UWMSmelting.init();
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":init");
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":postInit");
		proxy.postInit(event);
	}
	@SubscribeEvent
	public static void registerRegistry(RegistryEvent.NewRegistry event) {
		new RegistryBuilder<WandGadget>()
			.setName(new ResourceLocation(UWMReference.MODID, UWMReference.GADGET_REGISTRY))
			.setType(WandGadget.class)
			.create();
	}
}