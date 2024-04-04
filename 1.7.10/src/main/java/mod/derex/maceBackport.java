package mod.derex;

import net.minecraftforge.common.util.EnumHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class mace_backport {

	public mace_backport() {
	}

	public static Item block;
	public static Object instance;

	public void load() {
		ItemStack stack = new ItemStack(block, 1);
		GameRegistry.addRecipe(stack,
				new Object[]{"X1X", "X4X", "X7X", Character.valueOf('1'), new ItemStack(Blocks.iron_block, 1), Character.valueOf('4'),
						new ItemStack(Items.blaze_rod, 1), Character.valueOf('7'), new ItemStack(Items.string, 1),});
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	static {
		Item.ToolMaterial enumt = EnumHelper.addToolMaterial("MACE", 1, 250, 7F, 7, 16);
		block = (new ItemMace() {
		}).setUnlocalizedName("Mace").setTextureName("mace");
		Item.itemRegistry.addObject(423, "Mace", block);

	}

	static class ItemMace extends Item {

		// harvest level
		int harvest = 1;

		protected float efficiencyOnProperMaterial;

		protected ItemMace() {
			efficiencyOnProperMaterial = 7;
			setMaxDamage(250);
			setMaxStackSize(1);
			this.setCreativeTab(CreativeTabs.tabTools);
		}

		public boolean canHarvestBlock(Block par1Block) {
			return true;
		}

		/**
		 * Returns the strength of the stack against a given block. 1.0F base,
		 * (Quality+1)*2 if correct blocktype, 1.5F if sword
		 */
		public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
			return efficiencyOnProperMaterial;
		}

		/**
		 * Current implementations of this method in child classes do not use
		 * the entry argument beside ev. They just raise the damage on the
		 * stack.
		 */
		public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
			par1ItemStack.damageItem(1, par3EntityLiving);
			return true;
		}

		public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6,
				EntityLivingBase par7EntityLiving) {
			par1ItemStack.damageItem(1, par7EntityLiving);
			return true;
		}

		/**
		 * Returns the damage against a given entity.
		 */
		public int getDamageVsEntity(Entity par1Entity) {
			return 7;
		}

		/**
		 * Returns True is the item is renderer in full 3D when hold.
		 */
		public boolean isFull3D() {
			return true;
		}

		/**
		 * Return the enchantability factor of the item, most of the time is
		 * based on material.
		 */
		public int getItemEnchantability() {
			// kok se lohk cara
			return 16;
		}
	}
}
