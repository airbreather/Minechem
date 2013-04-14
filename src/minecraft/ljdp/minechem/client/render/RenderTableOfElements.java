package ljdp.minechem.client.render;

import ljdp.minechem.common.entity.EntityTableOfElements;
import ljdp.minechem.common.utils.ConstantValue;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.EnumArt;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderTableOfElements extends Render
{
	private void blitTexture(EntityTableOfElements entityTable, int i, int j, int k, int l)
    {
		Double d1 = 64.0D;
		Double d2 = 32.0D;
		calculateBrightness(entityTable, 64.0F, 32.0F);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(d1, -d2, 1.0D, 0.0D, 1.0D);
	    tessellator.addVertexWithUV(-d1, -d2, 0.9D, 1.0D, 1.0D);
	    tessellator.addVertexWithUV(-d1, d2, 0.9D, 1.0D, 0.0D);
	    tessellator.addVertexWithUV(d1, d2, 0.9D, 0.0D, 0.0D);
	    tessellator.draw();
    }
	private void calculateBrightness(EntityTableOfElements entityTable, float f, float f1)
    {
        int i = MathHelper.floor_double(entityTable.posX);
        int j = MathHelper.floor_double(entityTable.posY + (double)(f1 / 16F));
        int k = MathHelper.floor_double(entityTable.posZ);
        if (entityTable.direction == 0)
        {
            i = MathHelper.floor_double(entityTable.posX + (double)(f / 16F));
        }
        if (entityTable.direction == 1)
        {
            k = MathHelper.floor_double(entityTable.posZ - (double)(f / 16F));
        }
        if (entityTable.direction == 2)
        {
            i = MathHelper.floor_double(entityTable.posX - (double)(f / 16F));
        }
        if (entityTable.direction == 3)
        {
            k = MathHelper.floor_double(entityTable.posZ + (double)(f / 16F));
        }
        int l = renderManager.worldObj.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int i1 = l % 0x10000;
        int j1 = l / 0x10000;
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

    public void renderThePainting(EntityTableOfElements entityTable, double d, double d1, double d2, float f, float f1)
    {
        //rand.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        loadTexture(ConstantValue.table_HEX);
        float f2 = 0.0625F;
        GL11.glScalef(f2, f2, f2);
        blitTexture(entityTable, entityTable.tableSizeX, entityTable.tableSizeY, 0, 0);
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }

    private void func_77010_a(EntityTableOfElements par1EntityPainting, int par2, int par3, int par4, int par5)
    {
        float f = (float)(-par2) / 2.0F;
        float f1 = (float)(-par3) / 2.0F;
        float f2 = 0.5F;
        float f3 = 0.75F;
        float f4 = 0.8125F;
        float f5 = 0.0F;
        float f6 = 0.0625F;
        float f7 = 0.75F;
        float f8 = 0.8125F;
        float f9 = 0.001953125F;
        float f10 = 0.001953125F;
        float f11 = 0.7519531F;
        float f12 = 0.7519531F;
        float f13 = 0.0F;
        float f14 = 0.0625F;

        for (int i1 = 0; i1 < par2 / 16; ++i1)
        {
            for (int j1 = 0; j1 < par3 / 16; ++j1)
            {
                float f15 = f + (float)((i1 + 1) * 16);
                float f16 = f + (float)(i1 * 16);
                float f17 = f1 + (float)((j1 + 1) * 16);
                float f18 = f1 + (float)(j1 * 16);
                this.func_77008_a(par1EntityPainting, (f15 + f16) / 2.0F, (f17 + f18) / 2.0F);
                float f19 = (float)(par4 + par2 - i1 * 16) / 256.0F;
                float f20 = (float)(par4 + par2 - (i1 + 1) * 16) / 256.0F;
                float f21 = (float)(par5 + par3 - j1 * 16) / 256.0F;
                float f22 = (float)(par5 + par3 - (j1 + 1) * 16) / 256.0F;
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, -1.0F);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)(-f2), (double)f20, (double)f21);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)(-f2), (double)f19, (double)f21);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)(-f2), (double)f19, (double)f22);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)(-f2), (double)f20, (double)f22);
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)f2, (double)f3, (double)f5);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)f2, (double)f4, (double)f5);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)f2, (double)f4, (double)f6);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)f2, (double)f3, (double)f6);
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)(-f2), (double)f7, (double)f9);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)(-f2), (double)f8, (double)f9);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)f2, (double)f8, (double)f10);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)f2, (double)f7, (double)f10);
                tessellator.setNormal(0.0F, -1.0F, 0.0F);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)f2, (double)f7, (double)f9);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)f2, (double)f8, (double)f9);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)(-f2), (double)f8, (double)f10);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)(-f2), (double)f7, (double)f10);
                tessellator.setNormal(-1.0F, 0.0F, 0.0F);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)f2, (double)f12, (double)f13);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)f2, (double)f12, (double)f14);
                tessellator.addVertexWithUV((double)f15, (double)f18, (double)(-f2), (double)f11, (double)f14);
                tessellator.addVertexWithUV((double)f15, (double)f17, (double)(-f2), (double)f11, (double)f13);
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)(-f2), (double)f12, (double)f13);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)(-f2), (double)f12, (double)f14);
                tessellator.addVertexWithUV((double)f16, (double)f18, (double)f2, (double)f11, (double)f14);
                tessellator.addVertexWithUV((double)f16, (double)f17, (double)f2, (double)f11, (double)f13);
                tessellator.draw();
            }
        }
    }

    private void func_77008_a(EntityTableOfElements par1EntityPainting, float par2, float par3)
    {
        int i = MathHelper.floor_double(par1EntityPainting.posX);
        int j = MathHelper.floor_double(par1EntityPainting.posY + (double)(par3 / 16.0F));
        int k = MathHelper.floor_double(par1EntityPainting.posZ);

        if (par1EntityPainting.hangingDirection == 2)
        {
            i = MathHelper.floor_double(par1EntityPainting.posX + (double)(par2 / 16.0F));
        }

        if (par1EntityPainting.hangingDirection == 1)
        {
            k = MathHelper.floor_double(par1EntityPainting.posZ - (double)(par2 / 16.0F));
        }

        if (par1EntityPainting.hangingDirection == 0)
        {
            i = MathHelper.floor_double(par1EntityPainting.posX - (double)(par2 / 16.0F));
        }

        if (par1EntityPainting.hangingDirection == 3)
        {
            k = MathHelper.floor_double(par1EntityPainting.posZ + (double)(par2 / 16.0F));
        }

        int l = this.renderManager.worldObj.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int i1 = l % 65536;
        int j1 = l / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)i1, (float)j1);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderThePainting((EntityTableOfElements)par1Entity, par2, par4, par6, par8, par9);
    }
}