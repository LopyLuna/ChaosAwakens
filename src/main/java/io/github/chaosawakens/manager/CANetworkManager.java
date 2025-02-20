package io.github.chaosawakens.manager;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.network.packets.s2c.AnimationFunctionalProgressPacket;
import io.github.chaosawakens.common.network.packets.s2c.AnimationStopPacket;
import io.github.chaosawakens.common.network.packets.s2c.AnimationTriggerPacket;
import io.github.chaosawakens.common.network.packets.s2c.EnforceAssetsPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class CANetworkManager {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(ChaosAwakens.prefix("channel"), () ->
					PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void registerPackets() {
		int networkId = 0;

		ChaosAwakens.debug("MANAGER [Networking]", "Registering Packets...");

		registerCTSPackets(networkId);
		registerSTCPackets(networkId);

		ChaosAwakens.debug("MANAGER [Networking]", "Successfully registered Packets!");
	}

	private static void registerCTSPackets(int id) {
		ChaosAwakens.debug("MANAGER [Networking]", "Registering C2S Packets...");

		ChaosAwakens.debug("MANAGER [Networking]", "Successfully registered C2S Packets!");
	}

	private static void registerSTCPackets(int id) {
		ChaosAwakens.debug("MANAGER [Networking]", "Registering S2C Packets...");

		CHANNEL.registerMessage(id++, AnimationTriggerPacket.class, AnimationTriggerPacket::encode, AnimationTriggerPacket::decode, AnimationTriggerPacket::onRecieve, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
		CHANNEL.registerMessage(id++, AnimationStopPacket.class, AnimationStopPacket::encode, AnimationStopPacket::decode, AnimationStopPacket::onRecieve, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
		CHANNEL.registerMessage(id++, AnimationFunctionalProgressPacket.class, AnimationFunctionalProgressPacket::encode, AnimationFunctionalProgressPacket::decode, AnimationFunctionalProgressPacket::onRecieve, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
		CHANNEL.registerMessage(id++, EnforceAssetsPacket.class, EnforceAssetsPacket::encode, EnforceAssetsPacket::decode, EnforceAssetsPacket::onRecieve);

		ChaosAwakens.debug("MANAGER [Networking]", "Successfully registered S2C Packets!");
	}

	/**
	 * Sends a packet from client to server. C2S.
	 * @param packet Packet to send to the server.
	 */
	public static void sendPacketToServer(Object packet) {
		CHANNEL.sendToServer(packet);
	}

	/**
	 * Sends a packet to all clients from the server. S2C.
	 * @param packet Packet to send to client.
	 */
	public static void sendPacketToClient(Object packet) {
		CHANNEL.sendTo(packet, Minecraft.getInstance().getConnection().getConnection(), NetworkDirection.PLAY_TO_CLIENT);
	}

	/**
	 * Sends a tracking entity/player packet to all tracking clients (as well as the {@code trackedEntity} from the server. S2C.
	 * @param packet Packet to send (S2C)
	 * @param trackedEntity Tracked Entity
	 */
	public static void sendEntityTrackingPacket(Object packet, Entity trackedEntity) {
		CHANNEL.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> trackedEntity), packet);
	}
}
