package mod.derex;

import net.minecraft.entity.player.EntityPlayer;

import io.netty.buffer.ByteBuf;

public interface IPacketTestEnvironmentMod {

	public void readBytes(ByteBuf bytes);

	public void writeBytes(ByteBuf bytes);

	public void executeClient(EntityPlayer player);

	public void executeServer(EntityPlayer player);

}
