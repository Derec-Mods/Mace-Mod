package mod.derex;

import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.INetHandler;
import net.minecraft.client.Minecraft;

import io.netty.channel.ChannelHandlerContext;
import io.netty.buffer.ByteBuf;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.FMLCommonHandler;

public class ChannelHandlerTestEnvironmentMod extends FMLIndexedMessageToMessageCodec<IPacketTestEnvironmentMod> {

	@Override
	public void encodeInto(ChannelHandlerContext ctx, IPacketTestEnvironmentMod packet, ByteBuf data) throws Exception {
		packet.writeBytes(data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data, IPacketTestEnvironmentMod packet) {
		packet.readBytes(data);
		switch (FMLCommonHandler.instance().getEffectiveSide()) {
			case CLIENT :
				packet.executeClient(Minecraft.getMinecraft().thePlayer);
				break;
			case SERVER :
				INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
				packet.executeServer(((NetHandlerPlayServer) netHandler).playerEntity);
				break;
		}
	}

}
