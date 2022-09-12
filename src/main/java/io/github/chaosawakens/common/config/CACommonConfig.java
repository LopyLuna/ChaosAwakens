package io.github.chaosawakens.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

import io.github.chaosawakens.common.util.EnumUtils;

public class CACommonConfig {
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = commonSpecPair.getRight();
		COMMON = commonSpecPair.getLeft();
	}

	public static class Common {
		public final ConfigValue<Integer> ultimateSwordDamage;
		public final ConfigValue<Integer> ultimateAxeDamage;
		public final ConfigValue<Integer> ultimatePickaxeDamage;
		public final ConfigValue<Integer> ultimateShovelDamage;
		public final ConfigValue<Integer> ultimateHoeDamage;
		public final ConfigValue<Double> ultimateBowArrowBaseDamage;
		public final ConfigValue<Double> ultimateBowArrowDamageMultiplier;
		public final ConfigValue<Integer> emeraldSwordDamage;
		public final ConfigValue<Integer> emeraldAxeDamage;
		public final ConfigValue<Integer> emeraldPickaxeDamage;
		public final ConfigValue<Integer> emeraldShovelDamage;
		public final ConfigValue<Integer> emeraldHoeDamage;
		public final ConfigValue<Integer> rubySwordDamage;
		public final ConfigValue<Integer> rubyAxeDamage;
		public final ConfigValue<Integer> rubyPickaxeDamage;
		public final ConfigValue<Integer> rubyShovelDamage;
		public final ConfigValue<Integer> rubyHoeDamage;
		public final ConfigValue<Integer> amethystSwordDamage;
		public final ConfigValue<Integer> amethystAxeDamage;
		public final ConfigValue<Integer> amethystPickaxeDamage;
		public final ConfigValue<Integer> amethystShovelDamage;
		public final ConfigValue<Integer> amethystHoeDamage;
		public final ConfigValue<Integer> tigersEyeSwordDamage;
		public final ConfigValue<Integer> tigersEyeAxeDamage;
		public final ConfigValue<Integer> tigersEyePickaxeDamage;
		public final ConfigValue<Integer> tigersEyeShovelDamage;
		public final ConfigValue<Integer> tigersEyeHoeDamage;
		public final ConfigValue<Integer> copperSwordDamage;
		public final ConfigValue<Integer> copperAxeDamage;
		public final ConfigValue<Integer> copperPickaxeDamage;
		public final ConfigValue<Integer> copperShovelDamage;
		public final ConfigValue<Integer> copperHoeDamage;
		public final ConfigValue<Integer> tinSwordDamage;
		public final ConfigValue<Integer> tinAxeDamage;
		public final ConfigValue<Integer> tinPickaxeDamage;
		public final ConfigValue<Integer> tinShovelDamage;
		public final ConfigValue<Integer> tinHoeDamage;
		public final ConfigValue<Integer> silverSwordDamage;
		public final ConfigValue<Integer> silverAxeDamage;
		public final ConfigValue<Integer> silverPickaxeDamage;
		public final ConfigValue<Integer> silverShovelDamage;
		public final ConfigValue<Integer> silverHoeDamage;
		public final ConfigValue<Integer> platinumSwordDamage;
		public final ConfigValue<Integer> platinumAxeDamage;
		public final ConfigValue<Integer> platinumPickaxeDamage;
		public final ConfigValue<Integer> platinumShovelDamage;
		public final ConfigValue<Integer> platinumHoeDamage;
		public final ConfigValue<Integer> crystalWoodSwordDamage;
		public final ConfigValue<Integer> crystalWoodAxeDamage;
		public final ConfigValue<Integer> crystalWoodPickaxeDamage;
		public final ConfigValue<Integer> crystalWoodShovelDamage;
		public final ConfigValue<Integer> crystalWoodHoeDamage;
		public final ConfigValue<Integer> kyaniteSwordDamage;
		public final ConfigValue<Integer> kyaniteAxeDamage;
		public final ConfigValue<Integer> kyanitePickaxeDamage;
		public final ConfigValue<Integer> kyaniteShovelDamage;
		public final ConfigValue<Integer> kyaniteHoeDamage;
		public final ConfigValue<Integer> catsEyeSwordDamage;
		public final ConfigValue<Integer> catsEyeAxeDamage;
		public final ConfigValue<Integer> catsEyePickaxeDamage;
		public final ConfigValue<Integer> catsEyeShovelDamage;
		public final ConfigValue<Integer> catsEyeHoeDamage;
		public final ConfigValue<Integer> pinkTourmSwordDamage;
		public final ConfigValue<Integer> pinkTourmAxeDamage;
		public final ConfigValue<Integer> pinkTourmPickaxeDamage;
		public final ConfigValue<Integer> pinkTourmShovelDamage;
		public final ConfigValue<Integer> pinkTourmHoeDamage;
		public final ConfigValue<Integer> nightmareSwordDamage;
		public final ConfigValue<Integer> basiliskSwordDamage;
		public final ConfigValue<Integer> experienceSwordDamage;
		public final ConfigValue<Integer> poisonSwordDamage;
		public final ConfigValue<Integer> ratSwordDamage;
		public final ConfigValue<Integer> fairySwordDamage;
		public final ConfigValue<Integer> mantisClawDamage;
		public final ConfigValue<Integer> bigHammerDamage;
		public final ConfigValue<Integer> prismaticReaperDamage;

		public final ConfigValue<Integer> attitudeAdjusterDamage;
		public final ConfigValue<Integer> berthaDamage;
		public final ConfigValue<Integer> battleAxeDamage;
		public final ConfigValue<Integer> queenBattleAxeDamage;
		public final ConfigValue<Integer> royalGuardianSwordDamage;
		public final ConfigValue<Integer> slayerChainsawDamage;

		public final ConfigValue<Integer> attitudeAdjusterExplosionSize;
		public final ConfigValue<Integer> attitudeAdjusterExplosionType;
		public final ConfigValue<Boolean> attitudeAdjusterExplosionFire;
		public final ConfigValue<Integer> rayGunExplosionSize;
		public final ConfigValue<Integer> rayGunExplosionType;
		public final ConfigValue<Boolean> rayGunExplosionFire;
		public final ConfigValue<Integer> thunderStaffExplosionSize;
		public final ConfigValue<Integer> thunderStaffExplosionType;
		public final ConfigValue<Boolean> thunderStaffExplosionFire;

		public final ConfigValue<Boolean> enableAutoEnchanting;
		
		public final ConfigValue<EnumUtils.ElytraDamageType> enderDragonScaleArmorElytraDamageType; 

		public final ConfigValue<Boolean> crystalWorldRequiresEmptyInventory;
		public final ConfigValue<Boolean> enableBrownAntTeleport;
		public final ConfigValue<Boolean> enableRainbowAntTeleport;
		public final ConfigValue<Boolean> enableRedAntTeleport;
		public final ConfigValue<Boolean> enableUnstableAntTeleport;
		public final ConfigValue<Boolean> enableTermiteTeleport;
		public final ConfigValue<Boolean> enableButterflyTeleport;

		public final ConfigValue<Boolean> wanderingTraderSellsUraniumAndTitanium;
		public final ConfigValue<Boolean> wanderingTraderSellsTriffidGoo;
		public final ConfigValue<Integer> roboWarriorExplosionSize;
		public final ConfigValue<Integer> roboWarriorExplosionType;
		public final ConfigValue<Boolean> roboWarriorExplosionFire;

		public final ConfigValue<Boolean> enableOreGen;
		public final ConfigValue<Boolean> enableFossilGen;
		public final ConfigValue<Boolean> enableTrollOreGen;
		public final ConfigValue<Boolean> enableDzMineralOreGen;
		public final ConfigValue<Boolean> spawnDzOresInOverworld;
		public final ConfigValue<Boolean> enableNestGen;

		public final ConfigValue<Boolean> enableMarbleGen;
		public final ConfigValue<Boolean> enableLimestoneGen;

		public final ConfigValue<Boolean> enableOreRubyGen;
		public final ConfigValue<Boolean> enableOreTigersEyeGen;
		public final ConfigValue<Boolean> enableOreAmethystGen;
		public final ConfigValue<Boolean> enableOreTitaniumGen;
		public final ConfigValue<Boolean> enableOreUraniumGen;
		public final ConfigValue<Boolean> enableOreSaltGen;
		public final ConfigValue<Boolean> enableOreAluminumGen;
		public final ConfigValue<Boolean> enableOreCopperGen;
		public final ConfigValue<Boolean> enableOreTinGen;
		public final ConfigValue<Boolean> enableOreSilverGen;
		public final ConfigValue<Boolean> enableOrePlatinumGen;
		public final ConfigValue<Boolean> enableOreSunstoneGen;
		public final ConfigValue<Boolean> enableOreBloodstoneGen;

		public final ConfigValue<Boolean> enableEnchantedAnimalBreeding;

		public final ConfigValue<Boolean> generateAcaciaEntTree;
		public final ConfigValue<Boolean> generateBirchEntTree;
		public final ConfigValue<Boolean> generateCrimsonEntTree;
		public final ConfigValue<Boolean> generateDarkOakEntTree;
		public final ConfigValue<Boolean> generateJungleEntTree;
		public final ConfigValue<Boolean> generateOakEntTree;
		public final ConfigValue<Boolean> generateSpruceEntTree;
		public final ConfigValue<Boolean> generateWarpedEntTree;
		public final ConfigValue<Boolean> generateWaspNest;

		public final ConfigValue<Boolean> holidayTextures;

		public final ConfigValue<Boolean> enableDragonEggRespawns;
		public final ConfigValue<Boolean> enderDragonHeadDrop;

		public final ConfigValue<Boolean> terraforgedCheckMsg;

		public final ConfigValue<EnumUtils.SpawnEggSpawner> spawnEggsSpawnersSurvival;

		public final ConfigValue<Boolean> showUpdateMessage;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("Log messages");
			terraforgedCheckMsg = builder.define("Terraforged check message active", true);
			builder.pop();
			builder.push("Attack Damage");
//			builder.comment("Set damages are of the Sword \n Axe is +2 damage, Shovel is -1 damage and Pickaxe is -2 damage \n Hoes are always 1 damage");
			builder.push("Ultimate Weapons/Tools");
			ultimateSwordDamage = builder.define("Damage of the Ultimate Sword", 40);
			ultimateAxeDamage = builder.define("Damage of the Ultimate Axe", 42);
			ultimatePickaxeDamage = builder.define("Damage of the Ultimate Pickaxe", 38);
			ultimateShovelDamage = builder.define("Damage of the Ultimate Shovel", 39);
			ultimateHoeDamage = builder.define("Damage of the Ultimate Hoe", 1);
			ultimateBowArrowBaseDamage = builder
					.comment("How much damage the Ultimate bow will add up to the base arrow damage")
					.define("Additional Damage of the Ultimate Bow Arrows", 5D);
			ultimateBowArrowDamageMultiplier = builder.define("Damage Multiplier of the Ultimate Bow's Power Enchantment", 0.5);
			builder.pop();
			builder.push("Emerald Weapons/Tools");
			emeraldSwordDamage = builder.define("Damage of the Emerald Sword", 10);
			emeraldAxeDamage = builder.define("Damage of the Emerald Axe", 12);
			emeraldPickaxeDamage = builder.define("Damage of the Emerald Pickaxe", 8);
			emeraldShovelDamage = builder.define("Damage of the Emerald Shovel", 9);
			emeraldHoeDamage = builder.define("Damage of the Emerald Hoe", 1);
			builder.pop();
			builder.push("Ruby Weapons/Tools");
			rubySwordDamage = builder.define("Damage of the Ruby Sword", 20);
			rubyAxeDamage = builder.define("Damage of the Ruby Axe", 22);
			rubyPickaxeDamage = builder.define("Damage of the Ruby Pickaxe", 18);
			rubyShovelDamage = builder.define("Damage of the Ruby Shovel", 19);
			rubyHoeDamage = builder.define("Damage of the Ruby Hoe", 1);
			builder.pop();
			builder.push("Amethyst Weapons/Tools");
			amethystSwordDamage = builder.define("Damage of the Amethyst Sword", 15);
			amethystAxeDamage = builder.define("Damage of the Amethyst Axe", 17);
			amethystPickaxeDamage = builder.define("Damage of the Amethyst Pickaxe", 13);
			amethystShovelDamage = builder.define("Damage of the Amethyst Shovel", 14);
			amethystHoeDamage = builder.define("Damage of the Amethyst Hoe", 1);
			builder.pop();
			builder.push("Tiger's Eye Weapons/Tools");
			tigersEyeSwordDamage = builder.define("Damage of the Tiger's Eye Sword", 12);
			tigersEyeAxeDamage = builder.define("Damage of the Tiger's Eye Axe", 14);
			tigersEyePickaxeDamage = builder.define("Damage of the Tiger's Eye Pickaxe", 10);
			tigersEyeShovelDamage = builder.define("Damage of the Tiger's Eye Shovel", 11);
			tigersEyeHoeDamage = builder.define("Damage of the Tiger's Eye Hoe", 1);
			builder.pop();
			builder.push("Crystal Wood Weapons/Tools");
			crystalWoodSwordDamage = builder.define("Damage of the Crystal Wood Sword", 5);
			crystalWoodAxeDamage = builder.define("Damage of the Crystal Wood Axe", 9);
			crystalWoodPickaxeDamage = builder.define("Damage of the Crystal Wood Pickaxe", 3);
			crystalWoodShovelDamage = builder.define("Damage of the Crystal Wood Shovel", 3);
			crystalWoodHoeDamage = builder.define("Damage of the Crystal Wood Hoe", 1);
			builder.pop();
			builder.push("Kyanite Weapons/Tools");
			kyaniteSwordDamage = builder.define("Damage of the Kyanite Sword", 6);
			kyaniteAxeDamage = builder.define("Damage of the Kyanite Axe", 9);
			kyanitePickaxeDamage = builder.define("Damage of the Kyanite Pickaxe", 4);
			kyaniteShovelDamage = builder.define("Damage of the Kyanite Shovel", 4);
			kyaniteHoeDamage = builder.define("Damage of the Kyanite Hoe", 1);
			builder.pop();
			builder.push("Cat's Eye Weapons/Tools");
			catsEyeSwordDamage = builder.define("Damage of the Cat's Eye Sword", 12);
			catsEyeAxeDamage = builder.define("Damage of the Cat's Eye Axe", 14);
			catsEyePickaxeDamage = builder.define("Damage of the Cat's Eye Pickaxe", 10);
			catsEyeShovelDamage = builder.define("Damage of the Cat's Eye Shovel", 11);
			catsEyeHoeDamage = builder.define("Damage of the Cat's Eye Hoe", 1);
			builder.pop();
			builder.push("Pink Tourmaline Weapons/Tools");
			pinkTourmSwordDamage = builder.define("Damage of the Pink Tourmaline Sword", 11);
			pinkTourmAxeDamage = builder.define("Damage of the Pink Tourmaline Axe", 13);
			pinkTourmPickaxeDamage = builder.define("Damage of the Pink Tourmaline Pickaxe", 9);
			pinkTourmShovelDamage = builder.define("Damage of the Pink Tourmaline Shovel", 10);
			pinkTourmHoeDamage = builder.define("Damage of the Pink Tourmaline Hoe", 1);
			builder.pop();
			builder.push("Copper Weapons/Tools");
			copperSwordDamage = builder.define("Damage of the Copper Sword", 5);
			copperAxeDamage = builder.define("Damage of the Copper Axe", 9);
			copperPickaxeDamage = builder.define("Damage of the Copper Pickaxe", 3);
			copperShovelDamage = builder.define("Damage of the Copper Shovel", 4);
			copperHoeDamage = builder.define("Damage of the Copper Hoe", 1);
			builder.pop();
			builder.push("Tin Weapons/Tools");
			tinSwordDamage = builder.define("Damage of the Tin Sword", 6);
			tinAxeDamage = builder.define("Damage of the Tin Axe", 9);
			tinPickaxeDamage = builder.define("Damage of the Tin Pickaxe", 4);
			tinShovelDamage = builder.define("Damage of the Tin Shovel", 4);
			tinHoeDamage = builder.define("Damage of the Tin Hoe", 1);
			builder.pop();
			builder.push("Silver Weapons/Tools");
			silverSwordDamage = builder.define("Damage of the Silver Sword", 6);
			silverAxeDamage = builder.define("Damage of the Silver Axe", 9);
			silverPickaxeDamage = builder.define("Damage of the Silver Pickaxe", 4);
			silverShovelDamage = builder.define("Damage of the Silver Shovel", 5);
			silverHoeDamage = builder.define("Damage of the Silver Hoe", 1);
			builder.pop();
			builder.push("Platinum Weapons/Tools");
			platinumSwordDamage = builder.define("Damage of the Platinum Sword", 10);
			platinumAxeDamage = builder.define("Damage of the Platinum Axe", 12);
			platinumPickaxeDamage = builder.define("Damage of the Platinum Pickaxe", 8);
			platinumShovelDamage = builder.define("Damage of the Platinum Shovel", 9);
			platinumHoeDamage = builder.define("Damage of the Platinum Hoe", 1);
			builder.pop();
			builder.push("Misc Weapons/Tools");
			nightmareSwordDamage = builder.define("Damage of the Nightmare Sword", 30);
			basiliskSwordDamage = builder.define("Damage of the Basilisk Sword", 25);
			experienceSwordDamage = builder.define("Damage of the Experience Sword", 10);
			poisonSwordDamage = builder.define("Damage of the Poison Sword", 10);
			ratSwordDamage = builder.define("Damage of the Rat Sword", 10);
			fairySwordDamage = builder.define("Damage of the Fairy Sword", 10);
			mantisClawDamage = builder.define("Damage of the Mantis Claw", 10);
			bigHammerDamage = builder.define("Damage of the Big Hammer", 15);
			prismaticReaperDamage = builder.define("Damage of the Prismatic Reaper", 29);
			builder.pop();
			builder.push("Big Weapons/Tools");
			attitudeAdjusterDamage = builder.define("Damage of the Attitude Adjuster", 65);
			berthaDamage = builder.define("Damage of the Big Bertha", 500);
			battleAxeDamage = builder.define("Damage of the Battle Axe", 50);
			queenBattleAxeDamage = builder.define("Damage of the Queen Scale Battle Axe", 666);
			royalGuardianSwordDamage = builder.define("Damage of the Royal Guardian Sword", 750);
			slayerChainsawDamage = builder.define("Damage of the Slayer Chainsaw", 40);
			builder.pop();
			builder.pop();
			builder.push("Functionality");
			builder.push("Armor");
			builder.push("Ender Dragon Scale Armor");
			builder.comment("How the elytra on the Ender Dragon Scale Armor will get damaged," + "\n"
			               + "where ARMOR means per hit, and ELYTRA means that it'll get damage every tick or so as you fly (basically the same as a normal elytra)");
			enderDragonScaleArmorElytraDamageType = builder.define("Ender Dragon Scale Armor elytra damage type", EnumUtils.ElytraDamageType.ARMOR);
			builder.pop();
			builder.pop();
			builder.push("Tools/Weapons");
			builder.push("Explosions");
			builder.push("Attitude Adjuster");
			attitudeAdjusterExplosionSize = builder.define("Attitude Adjuster explosion size", 4);
			attitudeAdjusterExplosionType = builder
					.comment("0 = NONE - The Attitude Adjuster will not affect the terrain." + "\n"
							+ "1 = BREAK - The Attitude Adjuster will drop some blocks that it breaks." + "\n"
							+ "2 = DESTROY - The Attitude Adjuster will destroy blocks and never drop them.")
					.defineInRange("Attitude Adjuster explosion type", 2, 0, 2);
			attitudeAdjusterExplosionFire = builder.define("Fire from Attitude Adjuster explosion", false);
			builder.pop();
			builder.push("Ray Gun");
			rayGunExplosionSize = builder.define("Ray Gun explosion size", 6);
			rayGunExplosionType = builder
					.comment("0 = NONE - The Ray Gun will not affect the terrain." + "\n"
							+ "1 = BREAK - The Ray Gun will drop some blocks that it breaks." + "\n"
							+ "2 = DESTROY - The Ray Gun will destroy blocks and never drop them.")
					.defineInRange("Ray Gun explosion type", 2, 0, 2);
			rayGunExplosionFire = builder.define("Fire from Ray Gun explosion", false);
			builder.pop();
			builder.push("Thunder Staff");
			thunderStaffExplosionSize = builder.define("Thunder Staff explosion size", 4);
			thunderStaffExplosionType = builder
					.comment("0 = NONE - The Thunder Staff will not affect the terrain." + "\n"
							+ "1 = BREAK - The Thunder Staff will drop some blocks that it breaks. (May not work due to lightning)" + "\n"
							+ "2 = DESTROY - The Thunder Staff will destroy blocks and never drop them.")
					.defineInRange("Thunder Staff explosion type", 2, 0, 2);
			thunderStaffExplosionFire = builder.define("Fire from Thunder Staff explosion", true);
			builder.pop();
			builder.pop();
			enableAutoEnchanting = builder
					.comment("If disabled, auto-enchanted items will be able to be enchanted manually.")
					.define("Auto-enchant specific tools and weapons", true);
			builder.pop();
			builder.push("Breeding");
			enableEnchantedAnimalBreeding = builder
					.comment("Will Enchanted Animals be Breedable?")
					.define("Enchanted Animal Breeding", false);
			builder.pop();
			builder.push("Textures");
			holidayTextures = builder
					.comment("Will holiday special textures be obtainable?")
					.define("Obtainable Holiday Textures", true);
			builder.pop();
			builder.push("Ender Dragon");
			enableDragonEggRespawns = builder
					.comment("Will the Ender Dragon Egg respawn after the first death?")
					.define("Ender Dragon Egg Respawn", true);
			enderDragonHeadDrop = builder
					.comment("Will the Ender Dragon drop her head?")
					.define("Ender Dragon Head Drop", true);
			builder.pop();
			builder.push("Update Checker");
			showUpdateMessage = builder
					.comment("Send messages when there is a new update?")
					.define("Show Update Messages", true);
			builder.pop();
			builder.push("Spawners");
			spawnEggsSpawnersSurvival = builder
					.comment("NO_SPAWN_EGGS = " + EnumUtils.SpawnEggSpawner.NO_SPAWN_EGGS.getDescription() + "\n"
							+ "NO_CHAOS_AWAKENS = " + EnumUtils.SpawnEggSpawner.NO_CHAOS_AWAKENS.getDescription() + "\n"
							+ "ALL_SPAWN_EGGS = " + EnumUtils.SpawnEggSpawner.ALL_SPAWN_EGGS.getDescription() + "\n"
							+ "TAG_BLACKLIST = " + EnumUtils.SpawnEggSpawner.TAG_BLACKLIST.getDescription() + "\n"
							+ "TAG_WHITELIST = " + EnumUtils.SpawnEggSpawner.TAG_WHITELIST.getDescription())
					.defineEnum("Spawn Eggs on Spawners in Survival?", EnumUtils.SpawnEggSpawner.NO_SPAWN_EGGS);
			builder.pop();
			builder.pop();
			builder.push("World Generation");
			enableOreGen = builder.define("Enable ore generation", true);
			builder.push("Specific Ore Spawning");
			enableOreSaltGen = builder.define("Salt ore generation", true);
			enableOreAmethystGen = builder.define("Amethyst ore generation", true);
			enableOreRubyGen = builder.define("Ruby ore generation", true);
			enableOreTigersEyeGen = builder.define("Tiger's Eye ore generation", true);
			enableOreTitaniumGen = builder.define("Titanium ore generation", true);
			enableOreUraniumGen = builder.define("Uranium ore generation", true);
			enableOreCopperGen = builder.define("Copper ore generation", true);
			enableOreTinGen = builder.define("Tin ore generation", true);
			enableOreSilverGen = builder.define("Silver ore generation", true);
			enableOrePlatinumGen = builder.define("Platinum ore generation", true);
			enableOreSunstoneGen = builder.define("Sunstone ore generation", true);
			enableOreBloodstoneGen = builder.define("Bloodstone ore generation", true);
			enableOreAluminumGen = builder.define("Aluminum ore generation", true);
			builder.pop();
			enableFossilGen = builder.define("Enable fossil generation", true);
			enableMarbleGen = builder.define("Enable marble generation in the mining dimension", true);
			enableLimestoneGen = builder.define("Enable limestone generation in the mining dimension", true);
			enableTrollOreGen = builder.define("Enable infested ore generation", true);
			enableDzMineralOreGen = builder.define("Enable DZ ore generation", true);
			spawnDzOresInOverworld = builder
					.comment("Will DZ ores spawn in the Overworld?")
					.define("Overworld DZ Ores", false);
			enableNestGen = builder
					.comment("Will Nests spawn in the Overworld or the Ant Dimensions?")
					.define("Ant Nest generation", true);
			builder.push("Structures");
			generateAcaciaEntTree = builder
					.comment("Will Acacia Ent Trees be generated?")
					.define("Generate Acacia Ent Trees", true);
			generateBirchEntTree = builder
					.comment("Will Birch Ent Trees be generated?")
					.define("Generate Birch Ent Trees", true);
			generateCrimsonEntTree = builder
					.comment("Will Crimson Ent Trees be generated?")
					.define("Generate Crimson Ent Trees", true);
			generateDarkOakEntTree = builder
					.comment("Will Dark Oak Ent Trees be generated?")
					.define("Generate Dark Oak Ent Trees", true);
			generateJungleEntTree = builder
					.comment("Will Jungle Ent Trees be generated?")
					.define("Generate Jungle Ent Trees", true);
			generateOakEntTree = builder
					.comment("Will Oak Ent Trees be generated?")
					.define("Generate Oak Ent Trees", true);
			generateSpruceEntTree = builder
					.comment("Will Spruce Ent Trees be generated?")
					.define("Generate Spruce Ent Trees", true);
			generateWarpedEntTree = builder
					.comment("Will Warped Ent Trees be generated?")
					.define("Generate Warped Ent Trees", true);
			generateWaspNest = builder
					.comment("Will Wasp Nests be generated?")
					.define("Generate Wasp Nests", true);
			builder.pop();
			builder.pop();
			builder.push("Dimensions");
			crystalWorldRequiresEmptyInventory = builder
					.comment("Disable the requirement of needing an empty inventory to enter the Crystal World (Termite Dimension)?")
					.define("Crystal World Requires Empty Inventory", true);
			enableBrownAntTeleport = builder
					.comment("Will the Brown Ant teleport you to its Dimension?")
					.define("Brown Ant Teleport", true);
			enableRainbowAntTeleport = builder
					.comment("Will the Rainbow Ant teleport you to its Dimension?")
					.define("Rainbow Ant Teleport", true);
			enableRedAntTeleport = builder
					.comment("Will the Red Ant teleport you to its Dimension?")
					.define("Red Ant Teleport", true);
			enableUnstableAntTeleport = builder
					.comment("Will the Unstable Ant teleport you to its Dimension?")
					.define("Unstable Ant Teleport", true);
			enableTermiteTeleport = builder
					.comment("Will the Termite teleport you to its Dimension?")
					.define("Termite Teleport", true);
			enableButterflyTeleport = builder
					.comment("Will the Butterfly teleport you to its Dimension?")
					.define("Butterfly Teleport", true);
			builder.pop();
			builder.push("Entity");
			builder.push("Wandering Trader");
			wanderingTraderSellsTriffidGoo = builder
					.comment("Can the Wandering Trader sell Triffid Goo?")
					.define("Triffid Goo from Wandering Trader?", true);
			wanderingTraderSellsUraniumAndTitanium = builder
					.comment("Can the Wandering Trader sell Uranium and Titanium?")
					.define("Uranium and Titanium from Wandering Trader?", false);
			builder.pop();
			builder.push("Robo Warrior");
			roboWarriorExplosionSize = builder.define("Robo Warrior explosion size", 6);
			roboWarriorExplosionType = builder
					.comment("0 = NONE - The Robo Warrior will not affect the terrain." + "\n"
							+ "1 = BREAK - The Robo Warrior will drop some blocks that it breaks." + "\n"
							+ "2 = DESTROY - The Robo Warrior will destroy blocks and never drop them.")
					.defineInRange("Ray Gun explosion type", 2, 0, 2);
			roboWarriorExplosionFire = builder.define("Fire from Robo Warrior explosion", false);
			builder.pop();
			builder.pop();
		}
	}
}
