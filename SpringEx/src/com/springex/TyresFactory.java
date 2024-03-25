package com.springex;

public class TyresFactory {
	public Tyres getTyres(String typesType)
	{
		if(typesType==null)
			return null;
		if (typesType.equalsIgnoreCase("MICHELIN"))
			return new MichelinTyres();
		else if (typesType.equalsIgnoreCase("BRIDGESTONE")) {
			return new BridgeStoneTyres();
		}
		else
		{	return null; 
		}	
	}
}
