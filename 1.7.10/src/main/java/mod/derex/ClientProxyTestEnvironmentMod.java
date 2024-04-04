package mod.derex;

public class ClientProxyTestEnvironmentMod extends CommonProxyTestEnvironmentMod {

	@Override
	public void registerRenderers(TestEnvironmentMod ins) {
		ins.maceBackport.registerRenderers();

	}
}
