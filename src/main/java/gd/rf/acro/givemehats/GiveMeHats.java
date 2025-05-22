package gd.rf.acro.givemehats;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import gd.rf.acro.givemehats.items.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.util.ArrayList;
import java.util.List;

public class GiveMeHats implements ModInitializer {

	
	public static final ItemGroup TAB = FabricItemGroup.builder()
			.icon(() -> new ItemStack(GiveMeHats.BOWLER_HAT_ITEM))
			.displayName(Text.of("GiveMeHats"))
			.build();
	
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM_GROUP, new Identifier("givemehats", "tab"), TAB);
		ConfigUtils.checkConfigs();
		genHatsList();
		registerItems();



		System.out.println("May you find fine hats!");


	}

	public static final BowlerHatItem BOWLER_HAT_ITEM = new BowlerHatItem(new Item.Settings());
	public static final BunnyEarsItem BUNNY_EARS_ITEM = new BunnyEarsItem(new FabricItemSettings());
	public static final SantaHatItem SANTAR_HAT_ITEM = new SantaHatItem(new Item.Settings());
	public static final SlimeHatItem SLIME_HAT_ITEM = new SlimeHatItem(new Item.Settings());
	public static final CowboyHatItem COWBOY_HAT_ITEM = new CowboyHatItem(new Item.Settings());
	public static final SailorHatItem SAILOR_HAT_ITEM = new SailorHatItem(new Item.Settings());
	public static final FloatingHatItem FLOATING_HAT_ITEM = new FloatingHatItem(new Item.Settings());
	public static final TopHatItem TOP_HAT_ITEM = new TopHatItem(new Item.Settings());
	public static final TopestHatItem TOPEST_HAT_ITEM = new TopestHatItem(new Item.Settings());
	public static final FezHatItem FEZ_HAT_ITEM = new FezHatItem(new Item.Settings());
	public static final DeerStalkerHatItem DEER_STALKER_HAT_ITEM = new DeerStalkerHatItem(new Item.Settings());
	public static final CatEarsItem CAT_EARS_HAT_ITEM = new CatEarsItem(new Item.Settings());
	public static final FoxEarsItem FOX_EARS_HAT_ITEM = new FoxEarsItem(new Item.Settings());
	public static final ElectricMouseEarsItem ELECTRIC_MOUSE_EARS_HAT_ITEM = new ElectricMouseEarsItem(new Item.Settings());
	public static final CrownItem CROWN_ITEM = new CrownItem(new Item.Settings());
	public static final RussianHatItem RUSSIAN_HAT_ITEM = new RussianHatItem(new Item.Settings());
	public static final StriderHatItem STRIDER_HAT_ITEM = new StriderHatItem(new Item.Settings());
	public static final WoolrusHatItem WOOLRUS_HAT_ITEM = new WoolrusHatItem(new Item.Settings());
	public static final BunnySpaceHelmet BUNNY_SPACE_HELMET = new BunnySpaceHelmet(new Item.Settings());
	public static final IrishHatItem IRISH_HAT_ITEM = new IrishHatItem(new Item.Settings());
	public static final GolemBucketItem GOLEM_BUCKET_ITEM = new GolemBucketItem(new Item.Settings());
	public static final JojoHatItem JOJO_HAT_ITEM = new JojoHatItem(new Item.Settings());
	public static final WolfEarsItem WOLF_EARS_ITEM = new WolfEarsItem(new Item.Settings());
	public static final WitchHatItem WITCH_HAT_ITEM = new WitchHatItem(new Item.Settings());
	public static final VikingHatItem VIKING_HAT_ITEM = new VikingHatItem(new Item.Settings());
	public static final DwarvenHatItem DWARVEN_HAT_ITEM = new DwarvenHatItem(new Item.Settings());
	public static final HippieVibesItem HIPPIE_VIBES_ITEM = new HippieVibesItem(new Item.Settings());
	public static final HaloItem HALO_ITEM = new HaloItem(new Item.Settings());
    public static final MikuHatBrElectricianItem MIKU_HAT_BR_ELECTRICIAN_ITEM = new MikuHatBrElectricianItem(new Item.Settings());
    public static final MikuHatReindeerItem MIKU_HAT_REINDEER_ITEM = new MikuHatReindeerItem(new Item.Settings());
    public static final MikuHatBrSpItem MIKU_HAT_BR_SP_ITEM = new MikuHatBrSpItem(new Item.Settings());
    public static final MikuHatFrogItem MIKU_HAT_FROG_ITEM = new MikuHatFrogItem(new Item.Settings());
    public static final MikuHatFrankensteinItem MIKU_HAT_FRANKENSTEIN_ITEM = new MikuHatFrankensteinItem(new Item.Settings());
    public static final MikuHatBrBraidItem MIKU_HAT_BR_BRAID_ITEM = new MikuHatBrBraidItem(new Item.Settings());
    public static final MikuHatBrAmItem MIKU_HAT_BR_AM_ITEM = new MikuHatBrAmItem(new Item.Settings());
    public static final MikuHatDevilItem MIKU_HAT_DEVIL_ITEM = new MikuHatDevilItem(new Item.Settings());
    public static final MikuHatMichaelMyersItem MIKU_HAT_MICHAEL_MYERS_ITEM = new MikuHatMichaelMyersItem(new Item.Settings());
    public static final MikuHatBrFutFlaItem MIKU_HAT_BR_FUT_FLA_ITEM = new MikuHatBrFutFlaItem(new Item.Settings());
    public static final MikuHatUraotomeloversItem MIKU_HAT_URAOTOMELOVERS_ITEM = new MikuHatUraotomeloversItem(new Item.Settings());
    public static final MikuHatGhostfaceItem MIKU_HAT_GHOSTFACE_ITEM = new MikuHatGhostfaceItem(new Item.Settings());
    public static final MikuHatHachuneGunItem MIKU_HAT_HACHUNE_GUN_ITEM = new MikuHatHachuneGunItem(new Item.Settings());
    public static final MikuHatJasonItem MIKU_HAT_JASON_ITEM = new MikuHatJasonItem(new Item.Settings());
    public static final MikuHatBrItem MIKU_HAT_BR_ITEM = new MikuHatBrItem(new Item.Settings());
    public static final MikuHatHelloplanetItem MIKU_HAT_HELLOPLANET_ITEM = new MikuHatHelloplanetItem(new Item.Settings());
    public static final MikuHatVampireItem MIKU_HAT_VAMPIRE_ITEM = new MikuHatVampireItem(new Item.Settings());
    public static final MikuHatPatataItem MIKU_HAT_PATATA_ITEM = new MikuHatPatataItem(new Item.Settings());
    public static final AikoHatItem AIKO_HAT_ITEM = new AikoHatItem(new Item.Settings());
    public static final MikuHatHachuneItem MIKU_HAT_HACHUNE_ITEM = new MikuHatHachuneItem(new Item.Settings());
    public static final MikuHatXmasTreeItem MIKU_HAT_XMAS_TREE_ITEM = new MikuHatXmasTreeItem(new Item.Settings());
    public static final MikuHatSantaElfItem MIKU_HAT_SANTA_ELF_ITEM = new MikuHatSantaElfItem(new Item.Settings());
    public static final MikuHatBrBeachItem MIKU_HAT_BR_BEACH_ITEM = new MikuHatBrBeachItem(new Item.Settings());
    public static final MikuHatBrGoItem MIKU_HAT_BR_GO_ITEM = new MikuHatBrGoItem(new Item.Settings());
    public static final MikuHatBrBaDrumItem MIKU_HAT_BR_BA_DRUM_ITEM = new MikuHatBrBaDrumItem(new Item.Settings());
    public static final MikuHatBikItem MIKU_HAT_BIK_ITEM = new MikuHatBikItem(new Item.Settings());
    public static final MikuHatSantaItem MIKU_HAT_SANTA_ITEM = new MikuHatSantaItem(new Item.Settings());
    public static final MikuHatBrRsItem MIKU_HAT_BR_RS_ITEM = new MikuHatBrRsItem(new Item.Settings());
    public static final MikuHatZatsuneItem MIKU_HAT_ZATSUNE_ITEM = new MikuHatZatsuneItem(new Item.Settings());
    public static final MikuHatGhostItem MIKU_HAT_GHOST_ITEM = new MikuHatGhostItem(new Item.Settings());
    public static final MikuHatMummyItem MIKU_HAT_MUMMY_ITEM = new MikuHatMummyItem(new Item.Settings());
    public static final MikuHatItem MIKU_HAT_ITEM = new MikuHatItem(new Item.Settings());
    public static final MikuHatPatatiItem MIKU_HAT_PATATI_ITEM = new MikuHatPatatiItem(new Item.Settings());
    public static final MikuHatBrFutCamItem MIKU_HAT_BR_FUT_CAM_ITEM = new MikuHatBrFutCamItem(new Item.Settings());
    public static final MikuHatSenbonzakuraItem MIKU_HAT_SENBONZAKURA_ITEM = new MikuHatSenbonzakuraItem(new Item.Settings());
    public static final MikuHatBrBaItem MIKU_HAT_BR_BA_ITEM = new MikuHatBrBaItem(new Item.Settings());
    public static final MikuHatPersonadancingItem MIKU_HAT_PERSONADANCING_ITEM = new MikuHatPersonadancingItem(new Item.Settings());
    public static final MikuHatInfinityItem MIKU_HAT_INFINITY_ITEM = new MikuHatInfinityItem(new Item.Settings());
    public static final MikuHatBrSchoolPeItem MIKU_HAT_BR_SCHOOL_PE_ITEM = new MikuHatBrSchoolPeItem(new Item.Settings());
    public static final MikuHatBrBrownBroItem MIKU_HAT_BR_BROWN_BRO_ITEM = new MikuHatBrBrownBroItem(new Item.Settings());
    public static final MikuHatBrFutCrvgItem MIKU_HAT_BR_FUT_CRVG_ITEM = new MikuHatBrFutCrvgItem(new Item.Settings());
    public static final MikuHatClownItem MIKU_HAT_CLOWN_ITEM = new MikuHatClownItem(new Item.Settings());
    public static final MikuHatPumpkinItem MIKU_HAT_PUMPKIN_ITEM = new MikuHatPumpkinItem(new Item.Settings());
    public static final MikuHatMushroomItem MIKU_HAT_MUSHROOM_ITEM = new MikuHatMushroomItem(new Item.Settings());
    public static final MikuHatBrMgItem MIKU_HAT_BR_MG_ITEM = new MikuHatBrMgItem(new Item.Settings());
    public static final MikuHatBrPaItem MIKU_HAT_BR_PA_ITEM = new MikuHatBrPaItem(new Item.Settings());
    public static final MikuHatWerewomanItem MIKU_HAT_WEREWOMAN_ITEM = new MikuHatWerewomanItem(new Item.Settings());
    public static final MikuHatBrBikOrangeItem MIKU_HAT_BR_BIK_ORANGE_ITEM = new MikuHatBrBikOrangeItem(new Item.Settings());
    public static final MikuHatWitchItem MIKU_HAT_WITCH_ITEM = new MikuHatWitchItem(new Item.Settings());

	public static List<Item> LOADED_HATS;
	public static void genHatsList()
	{
		LOADED_HATS = new ArrayList<>();
		if(ConfigUtils.config.getOrDefault("enable_bowlerhat","1").equals("1"))
		{LOADED_HATS.add( BOWLER_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_bunnyears","1").equals("1"))
		{LOADED_HATS.add( BUNNY_EARS_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_bunnyspacehelmet","1").equals("1"))
		{LOADED_HATS.add( BUNNY_SPACE_HELMET);}
		if(ConfigUtils.config.getOrDefault("enable_catears","1").equals("1"))
		{LOADED_HATS.add( CAT_EARS_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_cowboyhat","1").equals("1"))
		{LOADED_HATS.add( COWBOY_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_crown","1").equals("1"))
		{LOADED_HATS.add( CROWN_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_deerstalkerhat","1").equals("1"))
		{LOADED_HATS.add( DEER_STALKER_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_electricmouseears","1").equals("1"))
		{LOADED_HATS.add( ELECTRIC_MOUSE_EARS_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_fez","1").equals("1"))
		{LOADED_HATS.add( FEZ_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_floatinghat","1").equals("1"))
		{LOADED_HATS.add( FLOATING_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_foxears","1").equals("1"))
		{LOADED_HATS.add( FOX_EARS_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_golembucket","1").equals("1"))
		{LOADED_HATS.add( GOLEM_BUCKET_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_irishhat","1").equals("1"))
		{LOADED_HATS.add( IRISH_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_jojohat","1").equals("1"))
		{LOADED_HATS.add( JOJO_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_russianhat","1").equals("1"))
		{LOADED_HATS.add( RUSSIAN_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_sailorhat","1").equals("1"))
		{LOADED_HATS.add( SAILOR_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_santahat","1").equals("1"))
		{LOADED_HATS.add( SANTAR_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_slimehat","1").equals("1"))
		{LOADED_HATS.add( SLIME_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_striderhat","1").equals("1"))
		{LOADED_HATS.add( STRIDER_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_tophat","1").equals("1"))
		{LOADED_HATS.add( TOP_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_topesthat","1").equals("1"))
		{LOADED_HATS.add( TOPEST_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_witchhat","1").equals("1"))
		{LOADED_HATS.add( WITCH_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_wolfears","1").equals("1"))
		{LOADED_HATS.add( WOLF_EARS_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_woolrushat","1").equals("1"))
		{LOADED_HATS.add( WOOLRUS_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_vikinghat","1").equals("1"))
		{LOADED_HATS.add( VIKING_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_dwarvenhat","1").equals("1"))
		{LOADED_HATS.add( DWARVEN_HAT_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_hippievibes","1").equals("1"))
		{LOADED_HATS.add( HIPPIE_VIBES_ITEM);}
		if(ConfigUtils.config.getOrDefault("enable_halo","1").equals("1"))
		{LOADED_HATS.add( HALO_ITEM);}

        LOADED_HATS.add(MIKU_HAT_BR_ELECTRICIAN_ITEM);
        LOADED_HATS.add(MIKU_HAT_REINDEER_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_SP_ITEM);
        LOADED_HATS.add(MIKU_HAT_FROG_ITEM);
        LOADED_HATS.add(MIKU_HAT_FRANKENSTEIN_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BRAID_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_AM_ITEM);
        LOADED_HATS.add(MIKU_HAT_DEVIL_ITEM);
        LOADED_HATS.add(MIKU_HAT_MICHAEL_MYERS_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_FUT_FLA_ITEM);
        LOADED_HATS.add(MIKU_HAT_URAOTOMELOVERS_ITEM);
        LOADED_HATS.add(MIKU_HAT_GHOSTFACE_ITEM);
        LOADED_HATS.add(MIKU_HAT_HACHUNE_GUN_ITEM);
        LOADED_HATS.add(MIKU_HAT_JASON_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_ITEM);
        LOADED_HATS.add(MIKU_HAT_HELLOPLANET_ITEM);
        LOADED_HATS.add(MIKU_HAT_VAMPIRE_ITEM);
        LOADED_HATS.add(MIKU_HAT_PATATA_ITEM);
        LOADED_HATS.add(AIKO_HAT_ITEM);
        LOADED_HATS.add(MIKU_HAT_HACHUNE_ITEM);
        LOADED_HATS.add(MIKU_HAT_XMAS_TREE_ITEM);
        LOADED_HATS.add(MIKU_HAT_SANTA_ELF_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BEACH_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_GO_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BA_DRUM_ITEM);
        LOADED_HATS.add(MIKU_HAT_BIK_ITEM);
        LOADED_HATS.add(MIKU_HAT_SANTA_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_RS_ITEM);
        LOADED_HATS.add(MIKU_HAT_ZATSUNE_ITEM);
        LOADED_HATS.add(MIKU_HAT_GHOST_ITEM);
        LOADED_HATS.add(MIKU_HAT_MUMMY_ITEM);
        LOADED_HATS.add(MIKU_HAT_ITEM);
        LOADED_HATS.add(MIKU_HAT_PATATI_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_FUT_CAM_ITEM);
        LOADED_HATS.add(MIKU_HAT_SENBONZAKURA_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BA_ITEM);
        LOADED_HATS.add(MIKU_HAT_PERSONADANCING_ITEM);
        LOADED_HATS.add(MIKU_HAT_INFINITY_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_SCHOOL_PE_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BROWN_BRO_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_FUT_CRVG_ITEM);
        LOADED_HATS.add(MIKU_HAT_CLOWN_ITEM);
        LOADED_HATS.add(MIKU_HAT_PUMPKIN_ITEM);
        LOADED_HATS.add(MIKU_HAT_MUSHROOM_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_MG_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_PA_ITEM);
        LOADED_HATS.add(MIKU_HAT_WEREWOMAN_ITEM);
        LOADED_HATS.add(MIKU_HAT_BR_BIK_ORANGE_ITEM);
        LOADED_HATS.add(MIKU_HAT_WITCH_ITEM);
	}

	private String cc2uc(String value)
	{
		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";
		return value.replaceAll(regex, replacement).toLowerCase();
	}

	private void registerItems()
	{

		for(Item hat: LOADED_HATS)
		{
			Registry.register(Registries.ITEM,new Identifier("givemehats",cc2uc(hat.getClass().getSimpleName().replace("Item",""))),hat);
			ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(TAB).get()).register(content -> {
				content.add(hat);
			});
			TrinketRendererRegistry.registerRenderer(hat, (TrinketRenderer) hat);

		}

	}

	public static void translateToFace(MatrixStack matrices, EntityModel<? extends LivingEntity> model,
									   LivingEntity entity, float headYaw, float headPitch) {

		if (entity.isInSwimmingPose() || entity.isFallFlying()) {
			if(model instanceof PlayerEntityModel)
			{
				PlayerEntityModel<AbstractClientPlayerEntity> ctx = (PlayerEntityModel<AbstractClientPlayerEntity>) model;
				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ctx.head.roll));
			}
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
		} else {

			if (entity.isInSneakingPose() && !model.riding) {
				matrices.translate(0.0F, 0.25F, 0.0F);
			}
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(headPitch));
		}
		matrices.translate(0.0F, -0.25F, -0.3F);
	}
	
}
