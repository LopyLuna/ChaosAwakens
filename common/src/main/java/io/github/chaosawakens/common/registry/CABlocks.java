package io.github.chaosawakens.common.registry;

import com.google.common.collect.ImmutableList;
import io.github.chaosawakens.CAConstants;
import io.github.chaosawakens.api.asm.annotations.RegistrarEntry;
import io.github.chaosawakens.api.block.standard.BlockPropertyWrapper;
import io.github.chaosawakens.api.platform.CAServices;
import io.github.chaosawakens.util.ModelUtil;
import io.github.chaosawakens.util.PredicateUtil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

@RegistrarEntry
public final class CABlocks {
    private static final ObjectArrayList<Supplier<Block>> BLOCKS = new ObjectArrayList<>();
    private static final ObjectArrayList<Supplier<Item>> BLOCK_ITEMS = new ObjectArrayList<>();

    // Wood Sets
    public static final Supplier<Block> APPLE_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("apple_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.APPLE_LOGS, CATags.CAItemTags.APPLE_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/apple/apple_log"), CAConstants.prefix("wood/apple/apple_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("apple_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.APPLE_LOGS, CATags.CAItemTags.APPLE_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/apple/apple_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_APPLE_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_apple_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(APPLE_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.APPLE_LOGS, CATags.CAItemTags.APPLE_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/apple/stripped_apple_log"), CAConstants.prefix("wood/apple/stripped_apple_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_APPLE_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_apple_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(APPLE_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.APPLE_LOGS, CATags.CAItemTags.APPLE_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/apple/stripped_apple_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("apple_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/apple/apple_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("apple_stairs", () -> new StairBlock(APPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(APPLE_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/apple/apple_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("apple_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(APPLE_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/apple/apple_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("apple_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(APPLE_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/apple/apple_planks"), CAConstants.prefix("block/apple_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("apple_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(APPLE_PLANKS.get()).forceSolidOn(), CAWoodTypes.APPLE)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/apple/apple_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("apple_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(APPLE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.APPLE)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/apple/apple_door_top"), CAConstants.prefix("wood/apple/apple_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("apple_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(APPLE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.APPLE)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/apple/apple_trapdoor"), CAConstants.prefix("block/apple_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("apple_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(APPLE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.APPLE)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/apple/apple_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> APPLE_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("apple_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.APPLE, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/apple/apple_planks"), CAConstants.prefix("block/apple_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> CRYSTALWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("crystalwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.CRYSTALWOOD_LOGS, CATags.CAItemTags.CRYSTALWOOD_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/crystalwood/crystalwood_log"), CAConstants.prefix("wood/crystalwood/crystalwood_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("crystalwood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.CRYSTALWOOD_LOGS, CATags.CAItemTags.CRYSTALWOOD_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/crystalwood/crystalwood_log")))
            .build()
            .getParentBlock();
    /*   public static final Supplier<Block> STRIPPED_CRYSTALWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_crystalwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(CRYSTALWOOD_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
               .cachedBuilder()
               .withTags(ObjectArrayList.of(CATags.CABlockTags.CRYSTALWOOD_LOGS, CATags.CAItemTags.CRYSTALWOOD_LOGS))
               .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/crystalwood/stripped_crystalwood_log"), CAConstants.prefix("wood/crystalwood/stripped_crystalwood_log_top")))
               .build()
               .getParentBlock();
       public static final Supplier<Block> STRIPPED_CRYSTALWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_crystalwood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(CRYSTALWOOD.get()))))
               .cachedBuilder()
               .withTags(ObjectArrayList.of(CATags.CABlockTags.CRYSTALWOOD_LOGS, CATags.CAItemTags.CRYSTALWOOD_LOGS))
               .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/crystalwood/stripped_crystalwood_log")))
               .build()
               .getParentBlock(); */
    public static final Supplier<Block> CRYSTALWOOD_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("crystalwood_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/crystalwood/crystalwood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("crystalwood_stairs", () -> new StairBlock(CRYSTALWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRYSTALWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/crystalwood/crystalwood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("crystalwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CRYSTALWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/crystalwood/crystalwood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("crystalwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(CRYSTALWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/crystalwood/crystalwood_planks"), CAConstants.prefix("block/crystalwood_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("crystalwood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(CRYSTALWOOD_PLANKS.get()).forceSolidOn(), CAWoodTypes.CRYSTALWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/crystalwood/crystalwood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("crystalwood_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(CRYSTALWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.CRYSTALWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/crystalwood/crystalwood_door_top"), CAConstants.prefix("wood/crystalwood/crystalwood_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("crystalwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(CRYSTALWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.CRYSTALWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/crystalwood/crystalwood_trapdoor"), CAConstants.prefix("block/crystalwood_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("crystalwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(CRYSTALWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.CRYSTALWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/crystalwood/crystalwood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> CRYSTALWOOD_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("crystalwood_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.CRYSTALWOOD, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/crystalwood/crystalwood_planks"), CAConstants.prefix("block/crystalwood_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> DENSEWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("densewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DENSEWOOD_LOGS, CATags.CAItemTags.DENSEWOOD_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/densewood/densewood_log"), CAConstants.prefix("wood/densewood/densewood_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("densewood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DENSEWOOD_LOGS, CATags.CAItemTags.DENSEWOOD_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/densewood/densewood_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DENSEWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_densewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DENSEWOOD_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DENSEWOOD_LOGS, CATags.CAItemTags.DENSEWOOD_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/densewood/stripped_densewood_log"), CAConstants.prefix("wood/densewood/stripped_densewood_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DENSEWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_densewood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DENSEWOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DENSEWOOD_LOGS, CATags.CAItemTags.DENSEWOOD_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/densewood/stripped_densewood_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("densewood_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/densewood/densewood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("densewood_stairs", () -> new StairBlock(DENSEWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(DENSEWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/densewood/densewood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("densewood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(DENSEWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/densewood/densewood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("densewood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(DENSEWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/densewood/densewood_planks"), CAConstants.prefix("block/densewood_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("densewood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(DENSEWOOD_PLANKS.get()).forceSolidOn(), CAWoodTypes.DENSEWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/densewood/densewood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("densewood_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(DENSEWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.DENSEWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/densewood/densewood_door_top"), CAConstants.prefix("wood/densewood/densewood_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("densewood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(DENSEWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.DENSEWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/densewood/densewood_trapdoor"), CAConstants.prefix("block/densewood_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("densewood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(DENSEWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.DENSEWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/densewood/densewood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DENSEWOOD_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("densewood_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.DENSEWOOD, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/densewood/densewood_planks"), CAConstants.prefix("block/densewood_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> DUPLICATOR_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("duplicator_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((duplicatorLogBlock) -> duplicatorLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DUPLICATOR_LOGS, CATags.CAItemTags.DUPLICATOR_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/duplicator/duplicator_log"), CAConstants.prefix("wood/duplicator/duplicator_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("duplicator_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DUPLICATOR_LOGS, CATags.CAItemTags.DUPLICATOR_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/duplicator/duplicator_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DUPLICATOR_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_duplicator_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DUPLICATOR_LOG.get()).mapColor((duplicatorLogBlock) -> duplicatorLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_BROWN : MapColor.COLOR_BROWN))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DUPLICATOR_LOGS, CATags.CAItemTags.DUPLICATOR_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/duplicator/stripped_duplicator_log"), CAConstants.prefix("wood/duplicator/stripped_duplicator_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DUPLICATOR_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_duplicator_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DUPLICATOR_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DUPLICATOR_LOGS, CATags.CAItemTags.DUPLICATOR_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/duplicator/stripped_duplicator_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DEAD_DUPLICATOR_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("dead_duplicator_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((duplicatorLogBlock) -> duplicatorLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_BROWN : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DEAD_DUPLICATOR_LOGS, CATags.CAItemTags.DEAD_DUPLICATOR_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/duplicator/dead/dead_duplicator_log"), CAConstants.prefix("wood/duplicator/dead/dead_duplicator_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DEAD_DUPLICATOR_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("dead_duplicator_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DEAD_DUPLICATOR_LOGS, CATags.CAItemTags.DEAD_DUPLICATOR_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/duplicator/dead/dead_duplicator_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DEAD_DUPLICATOR_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_dead_duplicator_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DEAD_DUPLICATOR_LOG.get()).mapColor((duplicatorLogBlock) -> duplicatorLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DEAD_DUPLICATOR_LOGS, CATags.CAItemTags.DEAD_DUPLICATOR_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/duplicator/dead/stripped_dead_duplicator_log"), CAConstants.prefix("wood/duplicator/dead/stripped_dead_duplicator_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_DEAD_DUPLICATOR_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_dead_duplicator_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DEAD_DUPLICATOR_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.DEAD_DUPLICATOR_LOGS, CATags.CAItemTags.DEAD_DUPLICATOR_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/duplicator/dead/stripped_dead_duplicator_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("duplicator_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/duplicator/duplicator_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("duplicator_stairs", () -> new StairBlock(DUPLICATOR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(DUPLICATOR_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/duplicator/duplicator_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("duplicator_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(DUPLICATOR_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/duplicator/duplicator_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("duplicator_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(DUPLICATOR_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/duplicator/duplicator_planks"), CAConstants.prefix("block/duplicator_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("duplicator_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(DUPLICATOR_PLANKS.get()).forceSolidOn(), CAWoodTypes.DUPLICATOR)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/duplicator/duplicator_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("duplicator_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(DUPLICATOR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.DUPLICATOR)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/duplicator/duplicator_door_top"), CAConstants.prefix("wood/duplicator/duplicator_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("duplicator_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(DUPLICATOR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.DUPLICATOR)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/duplicator/duplicator_trapdoor"), CAConstants.prefix("block/duplicator_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("duplicator_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(DUPLICATOR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.DUPLICATOR)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/duplicator/duplicator_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> DUPLICATOR_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("duplicator_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.DUPLICATOR, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/duplicator/duplicator_planks"), CAConstants.prefix("block/duplicator_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> GINKGO_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("ginkgo_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.GINKGO_LOGS, CATags.CAItemTags.GINKGO_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/ginkgo/ginkgo_log"), CAConstants.prefix("wood/ginkgo/ginkgo_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("ginkgo_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.GINKGO_LOGS, CATags.CAItemTags.GINKGO_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/ginkgo/ginkgo_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_GINKGO_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_ginkgo_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(GINKGO_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.GINKGO_LOGS, CATags.CAItemTags.GINKGO_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/ginkgo/stripped_ginkgo_log"), CAConstants.prefix("wood/ginkgo/stripped_ginkgo_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_GINKGO_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_ginkgo_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(GINKGO_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.GINKGO_LOGS, CATags.CAItemTags.GINKGO_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/ginkgo/stripped_ginkgo_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("ginkgo_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/ginkgo/ginkgo_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("ginkgo_stairs", () -> new StairBlock(GINKGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GINKGO_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/ginkgo/ginkgo_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("ginkgo_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/ginkgo/ginkgo_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("ginkgo_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/ginkgo/ginkgo_planks"), CAConstants.prefix("block/ginkgo_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("ginkgo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get()).forceSolidOn(), CAWoodTypes.GINKGO)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/ginkgo/ginkgo_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("ginkgo_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(GINKGO_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.GINKGO)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/ginkgo/ginkgo_door_top"), CAConstants.prefix("wood/ginkgo/ginkgo_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("ginkgo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(GINKGO_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.GINKGO)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/ginkgo/ginkgo_trapdoor"), CAConstants.prefix("block/ginkgo_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("ginkgo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(GINKGO_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.GINKGO)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/ginkgo/ginkgo_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> GINKGO_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("ginkgo_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.GINKGO, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/ginkgo/ginkgo_planks"), CAConstants.prefix("block/ginkgo_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> MESOZOIC_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("mesozoic_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.MESOZOIC_LOGS, CATags.CAItemTags.MESOZOIC_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/mesozoic/mesozoic_log"), CAConstants.prefix("wood/mesozoic/mesozoic_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("mesozoic_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.MESOZOIC_LOGS, CATags.CAItemTags.MESOZOIC_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/mesozoic/mesozoic_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_MESOZOIC_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_mesozoic_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(MESOZOIC_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.MESOZOIC_LOGS, CATags.CAItemTags.MESOZOIC_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/mesozoic/stripped_mesozoic_log"), CAConstants.prefix("wood/mesozoic/stripped_mesozoic_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_MESOZOIC_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_mesozoic_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(MESOZOIC_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.MESOZOIC_LOGS, CATags.CAItemTags.MESOZOIC_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/mesozoic/stripped_mesozoic_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("mesozoic_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/mesozoic/mesozoic_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("mesozoic_stairs", () -> new StairBlock(MESOZOIC_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MESOZOIC_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/mesozoic/mesozoic_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("mesozoic_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(MESOZOIC_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/mesozoic/mesozoic_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("mesozoic_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(MESOZOIC_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/mesozoic/mesozoic_planks"), CAConstants.prefix("block/mesozoic_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("mesozoic_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(MESOZOIC_PLANKS.get()).forceSolidOn(), CAWoodTypes.MESOZOIC)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/mesozoic/mesozoic_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("mesozoic_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MESOZOIC_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.MESOZOIC)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/mesozoic/mesozoic_door_top"), CAConstants.prefix("wood/mesozoic/mesozoic_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("mesozoic_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MESOZOIC_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.MESOZOIC)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/mesozoic/mesozoic_trapdoor"), CAConstants.prefix("block/mesozoic_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("mesozoic_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MESOZOIC_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.MESOZOIC)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/mesozoic/mesozoic_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> MESOZOIC_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("mesozoic_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.MESOZOIC, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/mesozoic/mesozoic_planks"), CAConstants.prefix("block/mesozoic_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> PEACH_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("peach_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_ORANGE : MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.PEACH_LOGS, CATags.CAItemTags.PEACH_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/peach/peach_log"), CAConstants.prefix("wood/peach/peach_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("peach_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.PEACH_LOGS, CATags.CAItemTags.PEACH_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/peach/peach_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_PEACH_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_peach_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(PEACH_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.TERRACOTTA_ORANGE : MapColor.COLOR_ORANGE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.PEACH_LOGS, CATags.CAItemTags.PEACH_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/peach/stripped_peach_log"), CAConstants.prefix("wood/peach/stripped_peach_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_PEACH_WOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_peach_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(PEACH_WOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.PEACH_LOGS, CATags.CAItemTags.PEACH_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/peach/stripped_peach_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("peach_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/peach/peach_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("peach_stairs", () -> new StairBlock(PEACH_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEACH_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/peach/peach_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("peach_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEACH_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/peach/peach_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("peach_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(PEACH_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/peach/peach_planks"), CAConstants.prefix("block/peach_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("peach_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(PEACH_PLANKS.get()).forceSolidOn(), CAWoodTypes.PEACH)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/peach/peach_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("peach_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(PEACH_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.PEACH)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/peach/peach_door_top"), CAConstants.prefix("wood/peach/peach_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("peach_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(PEACH_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.PEACH)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/peach/peach_trapdoor"), CAConstants.prefix("block/peach_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("peach_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(PEACH_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.PEACH)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/peach/peach_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> PEACH_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("peach_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.PEACH, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/peach/peach_planks"), CAConstants.prefix("block/peach_button_inventory")))
            .build()
            .getParentBlock();

    public static final Supplier<Block> SKYWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("skywood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_BLUE : MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.SKYWOOD_LOGS, CATags.CAItemTags.SKYWOOD_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/skywood/skywood_log"), CAConstants.prefix("wood/skywood/skywood_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("skywood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.SKYWOOD_LOGS, CATags.CAItemTags.SKYWOOD_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/skywood/skywood_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_SKYWOOD_LOG = BlockPropertyWrapper.of(CABlockPropertyWrappers.LOG, registerBlock("stripped_skywood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(SKYWOOD_LOG.get()).mapColor((appleLogBlock) -> appleLogBlock.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_BLUE : MapColor.COLOR_LIGHT_BLUE))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.SKYWOOD_LOGS, CATags.CAItemTags.SKYWOOD_LOGS))
            .withCustomModelDefinitions(ModelUtil.rotatedPillarBlock(CAConstants.prefix("wood/skywood/stripped_skywood_log"), CAConstants.prefix("wood/skywood/stripped_skywood_log_top")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> STRIPPED_SKYWOOD = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOOD, registerBlock("stripped_skywood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(SKYWOOD.get()))))
            .cachedBuilder()
            .withTags(ObjectArrayList.of(CATags.CABlockTags.SKYWOOD_LOGS, CATags.CAItemTags.SKYWOOD_LOGS))
            .withCustomModelDefinition(ModelUtil.cubeColumn(CAConstants.prefix("wood/skywood/stripped_skywood_log")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_PLANKS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PLANKS, registerBlock("skywood_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("wood/skywood/skywood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_STAIRS = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_STAIRS, registerBlock("skywood_stairs", () -> new StairBlock(SKYWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SKYWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.stairs(CAConstants.prefix("wood/skywood/skywood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_SLAB = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_SLAB, registerBlock("skywood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SKYWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.slab(CAConstants.prefix("wood/skywood/skywood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_FENCE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE, registerBlock("skywood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(SKYWOOD_PLANKS.get()))))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fence(CAConstants.prefix("wood/skywood/skywood_planks"), CAConstants.prefix("block/skywood_fence_inventory")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_FENCE_GATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_FENCE_GATE, registerBlock("skywood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(SKYWOOD_PLANKS.get()).forceSolidOn(), CAWoodTypes.SKYWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.fenceGate(CAConstants.prefix("wood/skywood/skywood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_DOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_DOOR, registerBlock("skywood_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(SKYWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn(), CABlockSetTypes.SKYWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.door(CAConstants.prefix("wood/skywood/skywood_door_top"), CAConstants.prefix("wood/skywood/skywood_door_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_TRAPDOOR = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_TRAPDOOR, registerBlock("skywood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(SKYWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().forceSolidOn().isValidSpawn(PredicateUtil::neverSpawnOnBlock).ignitedByLava(), CABlockSetTypes.SKYWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.trapdoor(CAConstants.prefix("wood/skywood/skywood_trapdoor"), CAConstants.prefix("block/skywood_trapdoor_bottom")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_PRESSURE_PLATE = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_PRESSURE_PLATE, registerBlock("skywood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(SKYWOOD_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().pushReaction(PushReaction.DESTROY).strength(0.5F), CABlockSetTypes.SKYWOOD)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.pressurePlate(CAConstants.prefix("wood/skywood/skywood_planks")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> SKYWOOD_BUTTON = BlockPropertyWrapper.of(CABlockPropertyWrappers.WOODEN_BUTTON, registerBlock("skywood_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), CABlockSetTypes.SKYWOOD, 30, true)))
            .cachedBuilder()
            .withCustomModelDefinitions(ModelUtil.button(CAConstants.prefix("wood/skywood/skywood_planks"), CAConstants.prefix("block/skywood_button_inventory")))
            .build()
            .getParentBlock();

    // Mineral Blocks
    public static final Supplier<Block> TITANIUM_BLOCK = BlockPropertyWrapper.of(CABlockPropertyWrappers.BASIC_BLOCK_PICKAXE_DIAMOND, registerBlock("titanium_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(75.0F, 2400.0F).sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().fireResistant()))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("mineral/titanium_block")))
            .build()
            .getParentBlock();
    public static final Supplier<Block> URANIUM_BLOCK = BlockPropertyWrapper.of(CABlockPropertyWrappers.BASIC_BLOCK_PICKAXE_DIAMOND, registerBlock("uranium_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(60.0F, 1800.0F).sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().fireResistant()))
            .cachedBuilder()
            .withCustomModelDefinition(ModelUtil.cubeAll(CAConstants.prefix("mineral/uranium_block")))
            .build()
            .getParentBlock();


    private static Supplier<Block> registerBlock(String id, Supplier<Block> blockSup) {
        return registerBlock(id, blockSup, new Item.Properties());
    }

    private static Supplier<Block> registerBlock(String id, Supplier<Block> blockSup, Item.Properties blockItemProperties) {
        Supplier<Block> registeredBlock = registerItemlessBlock(id, blockSup);
        registerBlockItem(id, () -> new BlockItem(registeredBlock.get(), blockItemProperties));
        return registeredBlock;
    }

    private static Supplier<Block> registerBlock(String id, Supplier<Block> blockSup, Supplier<Item> itemSup) {
        Supplier<Block> registeredBlock = registerItemlessBlock(id, blockSup);
        registerBlockItem(id, itemSup);
        return registeredBlock;
    }

    private static Supplier<Block> registerItemlessBlock(String id, Supplier<Block> blockSup) {
        Supplier<Block> registeredBlockSup = CAServices.REGISTRAR.registerObject(CAConstants.prefix(id), blockSup, BuiltInRegistries.BLOCK); // Otherwise reference to the block sup is null cuz it needs to be registered b4hand
        BLOCKS.add(registeredBlockSup);
        return registeredBlockSup;
    }

    private static Supplier<Item> registerBlockItem(String id, Supplier<Item> itemSup) {
        Supplier<Item> registeredItemSup = CAServices.REGISTRAR.registerObject(CAConstants.prefix(id), itemSup, BuiltInRegistries.ITEM); // Otherwise reference to the item sup is null cuz it needs to be registered b4hand
        BLOCK_ITEMS.add(registeredItemSup);
        return registeredItemSup;
    }

    public static Supplier<Block> registerExternalBlock(String id, Supplier<Block> blockSup) {
        return registerBlock(id, blockSup);
    }

    public static ImmutableList<Supplier<Block>> getBlocks() {
        return ImmutableList.copyOf(BLOCKS);
    }

    public static ImmutableList<Supplier<Item>> getBlockItems() {
        return ImmutableList.copyOf(BLOCK_ITEMS);
    }
}