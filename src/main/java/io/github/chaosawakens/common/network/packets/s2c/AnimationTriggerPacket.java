package io.github.chaosawakens.common.network.packets.s2c;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.api.animation.IAnimatableEntity;
import io.github.chaosawakens.api.animation.IAnimationBuilder;
import io.github.chaosawakens.api.network.ICAPacket;
import io.github.chaosawakens.common.util.ObjectUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.LogicalSidedProvider;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;

import java.util.Optional;
import java.util.function.Supplier;

public class AnimationTriggerPacket implements ICAPacket {
	private final int animatableOwnerID;
	private final String animationName;
	private final EDefaultLoopTypes loopType;
	private final String controllerName;
	private final boolean clearCache;
	
	public AnimationTriggerPacket(int animatableOwnerID, String animationName, EDefaultLoopTypes loopType, String controllerName, boolean clearCache) {
		this.animatableOwnerID = animatableOwnerID;
		this.animationName = animationName;
		this.loopType = loopType;
		this.controllerName = controllerName;
		this.clearCache = clearCache;
	}
	
	public static AnimationTriggerPacket decode(PacketBuffer buf) {
		return new AnimationTriggerPacket(buf.readInt(), buf.readUtf(), utfToLoopEnum(buf.readUtf()), buf.readUtf(), buf.readBoolean());
	}

	@Override
	public void encode(PacketBuffer buf) {
		buf.writeInt(animatableOwnerID);
		buf.writeUtf(animationName);
		buf.writeUtf(loopType.toString());
		buf.writeUtf(controllerName);
		buf.writeBoolean(clearCache);
	}
	
	private static EDefaultLoopTypes utfToLoopEnum(String name) { // Patch
		if (name.equals("LOOP")) return EDefaultLoopTypes.LOOP;
		else if (name.equals("HOLD_ON_LAST_FRAME")) return EDefaultLoopTypes.HOLD_ON_LAST_FRAME;
		else return EDefaultLoopTypes.PLAY_ONCE;
	}

	@Override
	public void onRecieve(Supplier<Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Optional<World> clientWorldHolder = LogicalSidedProvider.CLIENTWORLD.get(ctx.get().getDirection().getReceptionSide());
			
			clientWorldHolder.filter(ClientWorld.class::isInstance).ifPresent(curWorld -> {
				Entity target = curWorld.getEntity(animatableOwnerID);
				
				if (ObjectUtil.performNullityChecks(false, curWorld, target) && target instanceof IAnimatableEntity && !"None".equalsIgnoreCase(animationName)) {
					IAnimatableEntity targetAnimatable = (IAnimatableEntity) target;
					final IAnimationBuilder targetAnim = targetAnimatable.getCachedAnimationByName(animationName);
					
					if (targetAnim == null) {
						ChaosAwakens.LOGGER.warn("Attempted to send AnimationTriggerPacket for target entity of type {}, using an IAnimationBuilder instance for animation of name {}, but the target animation is null!", target.getClass().getSimpleName(), animationName);
						return;
					}
					targetAnimatable.playAnimation(targetAnim, clearCache);
				} else if (target != null) ChaosAwakens.LOGGER.warn("Attempted to send AnimationTriggerPacket for target entity of type {}, but the target entity class does not implement IAnimatableEntity!", target.getClass().getSimpleName());
			});
		});
		
		ctx.get().setPacketHandled(true);
	}
}
