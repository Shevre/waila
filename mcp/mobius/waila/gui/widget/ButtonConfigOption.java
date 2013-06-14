package mcp.mobius.waila.gui.widget;

import mcp.mobius.health.mod_Health;
import mcp.mobius.waila.mod_Waila;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ButtonConfigOption extends Button2States {

	String configKey;
	
	public ButtonConfigOption(int par1, String _stateFalse, String _stateTrue, String _label, String _configKey) {
		super(par1, 0, 0, 80, 20, _stateFalse, _stateTrue, _label, -1, false);
		this.setupInitialState(_configKey);
	}
	
	public ButtonConfigOption(int par1, int par2, int par3, String _stateFalse, String _stateTrue, String _label, int _labelSize, boolean _state, String _configKey) {
		super(par1, par2, par3, _stateFalse, _stateTrue, _label, _labelSize, _state);
		this.setupInitialState(_configKey);
	}

	public ButtonConfigOption(int par1, int par2, int par3, int par4, int par5,	String _stateFalse, String _stateTrue, String _label, int _labelSize, boolean _state, String _configKey) {
		super(par1, par2, par3, par4, par5, _stateFalse, _stateTrue, _label, _labelSize, _state);
		this.setupInitialState(_configKey);
	}

	public void setupInitialState(String _configKey){
		this.configKey = _configKey;
		this.state = this.readConfigKey(this.configKey);
		this.displayString = state ? stateTrue:stateFalse;		
	}
	
	public void pressButton(){
		super.pressButton();
		this.writeConfigKey(this.configKey, this.state);
	}	

	protected void writeConfigKey(String keyname, boolean value){
		mod_Waila.instance.config.getCategory(Configuration.CATEGORY_GENERAL).put(keyname, new Property(keyname,String.valueOf(value),Property.Type.BOOLEAN));
		mod_Waila.instance.config.save();
	}		
	
	protected boolean readConfigKey(String keyname){
		mod_Waila.instance.config.load();
		Property prop = mod_Waila.instance.config.get(Configuration.CATEGORY_GENERAL, keyname, true);
		return prop.getBoolean(true);
	}
	
}
